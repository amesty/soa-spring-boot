package com.example.server.soa.dao.mysql.mapper;

import com.example.server.soa.dao.mysql.domain.ProductInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductInfoMapper {

    int insert(ProductInfo productInfo);

    ProductInfo selectById(Long productId);

    List<ProductInfo> selectAll();

    int updateById(ProductInfo productInfo);

    int deleteById(Long productId);
}
