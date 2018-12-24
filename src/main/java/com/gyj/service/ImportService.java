package com.gyj.service;

/**
 * Created by duanxun on 2018-12-21.
 */
public interface ImportService {

    /**
     * 药品-对照 药品-院内上传
     * @return
     */
    String importDrugPriceInfo();

    /**
     * 高值耗材-对照 高值耗材-院内上传
     * @return
     */
    String importMaterialPriceInfo();

    /**
     * 医疗收费-对照 医疗收费-院内上传
     * @return
     */
    String importServicePriceInfo();

}
