package com.example.server.soa.service.product.impl;

import com.example.server.soa.dao.mysql.mapper.ProductInfoMapper;
import com.example.server.soa.dao.mysql.domain.ProductInfo;
import com.example.server.soa.service.base.BaseService;
import com.example.server.soa.service.product.ProductInfoService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ProductInfoServiceImpl extends BaseService implements ProductInfoService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean createProductInfo(ProductInfo productInfo) {
        if (productInfo == null) {
            return false;
        }
        return productInfoMapper.insert(productInfo) == 1;
    }

    @Override
    public ProductInfo getProductInfo(Long productId) {
        if (productId == null) {
            return null;
        }
        return productInfoMapper.selectById(productId);
    }

    @Override
    public List<ProductInfo> getProductInfoList(int page, int rows) {
        // 物理分页
        PageHelper.startPage(page, rows);
        PageHelper.orderBy("product_id desc");
        return  productInfoMapper.selectAll();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateProductInfo(ProductInfo productInfo) {
        if (productInfo == null || productInfo.getProductId() == null) {
            return false;
        }
        return productInfoMapper.updateById(productInfo) == 1;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteProductInfoById(Long productId) {
        if (productId == null) {
            return false;
        }
        return productInfoMapper.deleteById(productId) == 1;
    }
}
