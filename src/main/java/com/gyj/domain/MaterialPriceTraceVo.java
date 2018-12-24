package com.gyj.domain;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by duanxun on 2018-12-21.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "materialPriceTraceVo")
public class MaterialPriceTraceVo {

    //医疗机构代码
    private String orgCode;

    //医疗结构名称
    private String hospName;

    //医疗机构某日药品明细上传总条数
    private BigDecimal submitTotalNum;

    //数据开始日期
    private String dataStartDate;

    //数据结束日期
    private String dataEndDate;

    //高值耗材信息
    @XmlElementWrapper(name = "materialPriceTraces")
    @XmlElement(name = "materialPriceTrace")
    private List<MaterialPriceInfo> materialPriceTrace;
}
