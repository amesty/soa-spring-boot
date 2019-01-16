package com.example.server.soa.dao.mysql.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductInfo {
    /**
     * 商品id,主键
     */
    private Long productId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品单价
     */
    private BigDecimal productPrice;
    /**
     * 商品库存
     */
    private Integer productStock;
    /**
     * 商品图片的路径
     */
    private String productImageUrl;
    /**
     * 类目编号
     */
    private Long categoryId;
    /**
     * 商品状态,1-正常,2-已下架,3-已删除
     */
    private Integer status;
    /**
     * 主动创建时间
     */
    private Date gmtCreate;
    /**
     * 被动更新时间
     */
    private Date gmtModified;
}
