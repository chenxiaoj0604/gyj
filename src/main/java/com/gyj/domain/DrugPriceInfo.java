package com.gyj.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by duanxun on 2018-12-21.
 */
@Data
public class DrugPriceInfo {

    //国家药管平台编码
    private String ypid;

    //省级药品集中采购平台药品编码
    private String drugId;

    //院内药品编码
    private String drugCode;

    private String cadnType;

    private String drugName;

    private String brand;

    private String approvalNum;

    private String isHosMake;

    private String drugForm;

    private String formId;

    private String drugSpec;

    private String specCode;

    private String sMakeUnit;

    private String drugUnit;

    private BigDecimal drugFacotr;

    private String factoryName;

    private BigDecimal buyPrice;

    private BigDecimal oneBuyPrice;

    private BigDecimal buyNum;

    private BigDecimal oneBuyNum;

    private BigDecimal sellPrice;

    private BigDecimal oneSellPrice;

    private BigDecimal sellNum;

    private BigDecimal oneSellNum;

    private BigDecimal seqNumber;

}
