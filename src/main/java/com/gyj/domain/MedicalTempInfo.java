package com.gyj.domain;

import lombok.Data;

/**
 * Created by duanxun on 2018-12-21.
 */
@Data
public class MedicalTempInfo {

    //依据的接口规范标准
    private String specType;

    //机构编码
    private String orgCode;

    //文件名称
    private String fileName;

    //文件字符串
    private byte[] fileIoByte;
}
