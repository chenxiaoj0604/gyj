package com.gyj.domain;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author Qiang
 * @date 2018/6/28 12:36
 * @description 返回结果
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Response")
public class ResultVO {
    @XmlElement(name = "MessageHeader")
    private MessageHeader messageHeader;
//
//    @XmlElementWrapper(name = "List")
//    @XmlElement(name = "NumSourceInfo")
//    private List<ScheduleNumSourceDO> scheduleNumSourceDOList;
//
//    @XmlElementWrapper(name = "List")
//    @XmlElement(name = "OrderInfo")
//    private List<ScheduleNumListDO> scheduleNumListDOList;
//
//    @XmlElement(name = "Result")
//    private ScheduleUserInfoVO scheduleUserInfoVO;
//
//    @XmlElementWrapper(name = "List")
//    @XmlElement(name = "ResourceInfo")
//    private List<ResourceDoctInfoVO> resourceDoctInfoVOList;
//
//    @XmlElementWrapper(name = "List")
//    @XmlElement(name = "ResourceInfo")
//    private List<ResourceOutPatInfoVO> resourceOutPatInfoVOList;

}
