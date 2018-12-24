package com.gyj.dao;

import com.gyj.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by duanxun on 2018-12-21.
 */
@Component
public interface UploadDao {

    //
    List<DrugPriceTraceVo> getDrugPriceTraceVo();

    List<DrugPriceInfo> getDrugPriceInfosByDate(DrugPriceTraceVo drugPriceTraceVo);

    //
    List<MaterialPriceTraceVo> getMaterialPriceTraceVo();

    List<MaterialPriceInfo> getMaterialPriceInfosByDate(MaterialPriceTraceVo materialPriceTraceVo);

    //
    List<ServicePriceTraceVo> getServicePriceTraceVo();

    List<ServicePriceInfo> getServicePriceInfosByDate(ServicePriceTraceVo servicePriceTraceVo);

    //
    HospitalResourceVo getHospitalResource();

}
