package com.example.server.soa.service.product;

import com.example.server.soa.dao.mysql.domain.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductInfoServiceTests {

    @Resource
    private ProductInfoService productInfoService;

    @Test
    public void testCreate() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductName("phone");
        productInfo.setProductPrice(new BigDecimal(5999.99));
        productInfo.setProductStock(99);
        productInfo.setProductImageUrl("http://img1.example.com/201801.jpg");
        productInfo.setCategoryId(100L);
        boolean result = productInfoService.createProductInfo(productInfo);
        log.info("result: {}", result);
    }

    @Test
    public void testCreate10() {
        for (int i = 0; i < 10; i ++) {
            ProductInfo productInfo = new ProductInfo();
            productInfo.setProductName("computer");
            productInfo.setProductPrice(new BigDecimal(9999.99));
            productInfo.setProductStock(99);
            productInfo.setProductImageUrl("http://img1.example.com/201802.jpg");
            productInfo.setCategoryId(200L);
            boolean result = productInfoService.createProductInfo(productInfo);
            log.info("result: {}", result);
        }
    }

    @Test
    public void testQuery() {
        ProductInfo productInfo = productInfoService.getProductInfo(10000L);
        if (productInfo != null) {
            log.info("result: {}", productInfo.toString());
        }
    }

    @Test
    public void testQueryAll() {
        List<ProductInfo> productInfoList = productInfoService.getProductInfoList(2, 5);
        for (ProductInfo productInfo: productInfoList) {
            log.info("result: {}", productInfo);
        }
    }

    @Test
    public void testUpdate() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId(10000L);
        productInfo.setProductName("computer");
        productInfo.setProductPrice(new BigDecimal(9599.99));
        boolean result = productInfoService.updateProductInfo(productInfo);
        log.info("result: {}", result);
    }

    @Test
    public void testDelete() {
        boolean result = productInfoService.deleteProductInfoById(10000L);
        log.info("result: {}", result);
    }
}
