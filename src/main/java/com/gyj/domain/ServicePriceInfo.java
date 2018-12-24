package com.gyj.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by duanxun on 2018-12-21.
 */

@Data
public class ServicePriceInfo {
    /**
     * 医疗服务制定依据
     */
    String baVer;
    /**
     * 医疗服务制定依据名称
     */
    String baVerName;
    /**
     * 全国医疗服务价格项目价目编码
     */
    String baseCode;
    /**
     * 全国医疗服务价格项目价目名称
     */
    String baseName;
    /**
     * 地方收费标准对应医疗服务价格项目编码
     */
    String baYjCode;
    /**
     * 地方收费标准对应医疗服务价格项目名称
     */
    String baYjName;
    /**
     * 院内服务项目编码
     */
    String serviceCode;
    /**
     * 院内服务项目名称
     */
    String serviceName;
    /**
     * 是否院内或地方新增项目
     */
    String isBase;
    /**
     * 计价单位
     */
    String unit;
    /**
     * 服务价格
     */
    BigDecimal sellPrice;
    /**
     * 服务数量
     */
    BigDecimal sellNum;
    /**
     * 计价说明
     */
    String priceExplain;
    /**
     * 顺序号
     */
    BigDecimal seqNumber;

}
