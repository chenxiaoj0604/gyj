package com.gyj.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by duanxun on 2018-12-21.
 */
@Component
@Data
@ConfigurationProperties(prefix = "webServiceUrl")
public class WebServiceUrl {

    private String DrugPriceTraceWSUrl;
    private String MaterialPriceTraceWSUrl;
    private String ServicePriceTraceWSUrl;
    private String HospitalResourceWSUrl;
    private String MedicalTempWSUrl;

}
