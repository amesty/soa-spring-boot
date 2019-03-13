package com.example.server.soa.web.controller.product;

import com.example.server.soa.common.enums.ResultEnum;
import com.example.server.soa.common.protocol.ActionResult;
import com.example.server.soa.common.util.ResultTool;
import com.example.server.soa.web.controller.base.BaseController;
import com.example.server.soa.dao.mysql.domain.ProductInfo;
import com.example.server.soa.service.product.ProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ProductInfoController extends BaseController {

    @Autowired
    private ProductInfoService productInfoService;

    @PostMapping("/productinfo/create")
    public Object createProductInfo(@RequestBody ProductInfo productInfo) {
        try {
            if (productInfo.getProductName() == null) {
                return ResultTool.error(ResultEnum.PARAM_ERROR, "productName must be filled");
            }
            if (productInfo.getProductPrice() == null) {
                return ResultTool.error(ResultEnum.PARAM_ERROR, "productPrice must be filled");
            }
            if (productInfo.getProductStock() == null) {
                return ResultTool.error(ResultEnum.PARAM_ERROR, "productStock must be filled");
            }
            if (productInfo.getProductImageUrl() == null) {
                return ResultTool.error(ResultEnum.PARAM_ERROR, "productImageUrl must be filled");
            }
            if (productInfo.getCategoryId() == null) {
                return ResultTool.error(ResultEnum.PARAM_ERROR, "categoryId must be filled");
            }
            if (productInfoService.createProductInfo(productInfo)) {
                return ResultTool.success();
            }
            return ResultTool.error();
        } catch (Throwable e) {
            log.error("ProductInfoController.createProductInfo:{}", e.getMessage(), e);
            return ResultTool.exception(e);
        }
    }

    @GetMapping("/productinfo/query/{id}")
    public Object queryProductInfo(@PathVariable("id") Long productId) {
        try {
            ActionResult result = new ActionResult();
            ProductInfo productInfo = productInfoService.getProductInfo(productId);
            if (productInfo != null) {
                result.addResult("productInfo", productInfo);
                return ResultTool.success(result);
            }
            return ResultTool.success();
        } catch (Throwable e) {
            log.error("ProductInfoController.queryProductInfo:{}", e.getMessage(), e);
            return ResultTool.exception(e);
        }
    }

    @GetMapping("/productinfo/query/list")
    public Object queryProductInfoList(@RequestParam(value = "page", defaultValue = "1") int page,
                                       @RequestParam(value = "rows", defaultValue = "10") int rows) {
        try {
            ActionResult result = new ActionResult();
            List<ProductInfo> productInfoList = productInfoService.getProductInfoList(page, rows);
            if (productInfoList != null && productInfoList.size() > 0) {
                result.addResult("productInfoList", productInfoList);
                return ResultTool.success(result);
            }
            return ResultTool.success();
        } catch (Throwable e) {
            log.error("ProductInfoController.queryProductInfoList:{}", e.getMessage(), e);
            return ResultTool.exception(e);
        }
    }

    @PostMapping("/productinfo/edit")
    public Object editProductInfo(ProductInfo productInfo) {
        try {
            if (productInfo.getProductId() == null) {
                return ResultTool.error(ResultEnum.PARAM_ERROR, "productId");
            }
            if (productInfoService.updateProductInfo(productInfo)) {
                return ResultTool.success();
            }
            return ResultTool.error();
        } catch (Throwable e) {
            log.error("ProductInfoController.editProductInfo:{}", e.getMessage(), e);
            return ResultTool.exception(e);
        }
    }

    @PostMapping("/productinfo/delete")
    public Object deleteProductInfo(Long id) {
        try {
            if (productInfoService.deleteProductInfoById(id)) {
                return ResultTool.success();
            }
            return ResultTool.error();
        } catch (Throwable e) {
            log.error("ProductInfoController.deleteProductInfo:{}", e.getMessage(), e);
            return ResultTool.exception(e);
        }
    }
}
