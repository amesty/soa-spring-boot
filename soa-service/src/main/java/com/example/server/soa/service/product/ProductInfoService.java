package com.example.server.soa.service.product;

import com.example.server.soa.dao.mysql.domain.ProductInfo;

import java.util.List;

public interface ProductInfoService {

    boolean createProductInfo(ProductInfo productInfo);

    ProductInfo getProductInfo(Long productId);

    /**
     * 分页查询
     *
     * @param page  页码
     * @param rows 每页显示数量
     */
    List<ProductInfo> getProductInfoList(int page, int rows);

    boolean updateProductInfo(ProductInfo productInfo);

    boolean deleteProductInfoById(Long productId);
}
