/*
 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : spring_test

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 12/10/2018 17:26:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info`  (
  `product_id` bigint(18) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品id,主键',
  `product_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `product_price` decimal(8, 2) UNSIGNED NOT NULL DEFAULT 99999.99 COMMENT '商品单价',
  `product_stock` int(8) UNSIGNED NOT NULL DEFAULT 0 COMMENT '商品库存',
  `product_image_url` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品图片的路径',
  `category_id` bigint(8) NOT NULL COMMENT '类目编号',
  `status` int(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '商品状态,1-正常,2-已下架,3-已删除',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '主动创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '被动更新时间',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10001 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品信息表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
