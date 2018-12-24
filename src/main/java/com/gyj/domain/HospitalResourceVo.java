package com.gyj.domain;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

/**
 * Created by duanxun on 2018-12-21.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "hospitalResourceVo")
public class HospitalResourceVo {

    //医疗机构代码
    private String orgCode;

    //医疗结构名称
    private String hospName;

    //数据开始日期
    private String dataStartDate;

    //数据结束日期
    private String dataEndDate;

    //实有床位
    private BigDecimal bedsNum;

    //执业（助理）医师数
    private BigDecimal doctorsNum;

    //总诊疗人次数
    private BigDecimal diagnosesNum;

    //出院人数
    private BigDecimal leaveNum;

    //是否取消药品加成
    private String drugPlus;

    //取消药品加成日期
    private String drugPlusDate;

    //中药饮片总支出额
    private BigDecimal drinkBuyMoney;

    //中药饮片总销售额
    private BigDecimal drinkSellMoney;

    //中药颗粒剂总支出额
    private BigDecimal grainBuyMoney;

    //中药颗粒剂总销售额
    private BigDecimal grainSellMoney;

    //医用耗材总支出额
    private BigDecimal SuppliBuyMoney;

    //医用耗材总销售额
    private BigDecimal suppliSellMoney;

}
