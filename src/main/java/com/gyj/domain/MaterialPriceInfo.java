package com.gyj.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by duanxun on 2018-12-21.
 */

@Data
public class MaterialPriceInfo {

    /**
     * 高值医用耗材统一标识码
     */
    String hcbs;

    /**
     * 省级药品集中采购平台高值医用耗材编码
     */
    String sjhcbs;

    /**
     * 耗材院内编码
     */
    String ynhcbs;

    /**
     * 耗材院内名称
     */
    String materialName;

    /**
     * 商品名
     */
    String brand;

    /**
     * 注册证产品名称
     */
    String regcardName;

    /**
     * 注册证号/备案号/生产许可证号
     */
    String regcardNm;

    /**
     * 型号
     */
    String producttype;

    /**
     * 规格
     */
    String prodouctoutlookc;

    /**
     * 最小计量单位
     */
    String productminpunit;

    /**
     * 最小销售包装单位
     */
    String productunit;

    /**
     * 转换系数
     */
    BigDecimal productmfactor;

    /**
     * 高值医用耗材生产企业名称
     */
    String factoryName;

    /**
     * 最小销售包装进货价格
     */
    BigDecimal buyPrice;

    /**
     * 最小计量单位进货价格
     */
    BigDecimal productminpunitBuyPrice;

    /**
     * 最小销售包装进货数量
     */
    BigDecimal buyNum;

    /**
     * 最小计量单位进货数量
     */
    BigDecimal productminpunitBuyNum;

    /**
     * 最小销售包装销售价格
     */
    BigDecimal sellPrice;

    /**
     * 最小计量单位销售价格
     */
    BigDecimal productminpunitSellPrice;

    /**
     * 最小销售包装销售数量
     */
    BigDecimal sellNum;

    /**
     * 最小计量单位销售数量
     */
    BigDecimal productminpunitSellNum;

    /**
     * 顺序号
     */
    BigDecimal seqNumber;

}
