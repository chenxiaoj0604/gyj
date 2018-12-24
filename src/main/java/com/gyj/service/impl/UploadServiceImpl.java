package com.gyj.service.impl;

import com.gyj.dao.UploadDao;
import com.gyj.domain.*;
import com.gyj.service.UploadService;
import com.gyj.utils.XmlUtils;
import com.gyj.utils.sm4.Sm4WSImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by duanxun on 2018-09-10.
 */
@Service
@Slf4j
public class UploadServiceImpl implements UploadService {

    @Autowired
    private Sm4WSImpl sm4WS;

    @Autowired
    private WebServiceUrl webServiceUrl;

    @Autowired
    private UploadDao uploadDao;

    static String SECRETKEY = "ShDfyY1920jMl150";

    static String HOSPCODE = "42501633131011511A1001";

    JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();

    @Override
    public String uploadDrugPriceInfo() {
        try {
            List<DrugPriceTraceVo> drugPriceTraceVos = uploadDao.getDrugPriceTraceVo();
            String xml;
            String parameter;
            //动态调用
            Client client = dcf.createClient(webServiceUrl.getDrugPriceTraceWSUrl());
            Object[] objects = new Object[0];
            QName opName = new QName("http://drugpricetrace.ws.nmmps.dhcc.com/", "receiveDrugData");

            log.info("drugPriceTraceVos.size():" + drugPriceTraceVos.size());

            for (int i = 0; i < drugPriceTraceVos.size(); i++) {
                log.info("日期" + drugPriceTraceVos.get(i).getDataStartDate());
                List<DrugPriceInfo> drugPriceInfos = uploadDao.getDrugPriceInfosByDate(drugPriceTraceVos.get(i));
                drugPriceTraceVos.get(i).setDrugPriceTrace(drugPriceInfos);
                xml = XmlUtils.object2XmlStr(drugPriceTraceVos.get(i));
                xml = replaceBlank(xml);
                xml = xml.split("\\?>")[1];
                xml = xml.replaceAll("SMakeUnit","sMakeUnit");

                log.info("xml[" + i + "]: " + xml);

                parameter = sm4WS.encryptInfo(xml, SECRETKEY);
                objects = client.invoke(opName, HOSPCODE + parameter);
                log.info("返回数据:" + objects[0]);
            }
            return "执行成功";
        } catch (Exception e) {
            return "执行失败:" + e.getMessage();
        }
    }

    //todo
    @Override
    public String uploadMaterialPriceInfo() {
        try {
            List<MaterialPriceTraceVo> materialPriceTraceVos = uploadDao.getMaterialPriceTraceVo();
            String xml;
            String parameter;
            //动态调用
            Client client = dcf.createClient(webServiceUrl.getMaterialPriceTraceWSUrl());
            Object[] objects = new Object[0];
            QName opName = new QName("http://materialpricetrace.ws.nmmps.dhcc.com/", "receiveMaterialPriceData");
            for (int i = 0; i < materialPriceTraceVos.size(); i++) {
                log.info("日期" + materialPriceTraceVos.get(i).getDataStartDate());
                List<MaterialPriceInfo> materialPriceInfos = uploadDao.getMaterialPriceInfosByDate(materialPriceTraceVos.get(i));
                materialPriceTraceVos.get(i).setMaterialPriceTrace(materialPriceInfos);
                xml = XmlUtils.object2XmlStr(materialPriceTraceVos.get(i));
                xml = replaceBlank(xml);
                xml = xml.split("\\?>")[1];
                xml = xml.replaceAll("SMakeUnit","sMakeUnit");
                parameter = sm4WS.encryptInfo(xml, SECRETKEY);
//                log.info(xml);
                objects = client.invoke(opName, HOSPCODE + parameter);
                log.info("返回数据:" + objects[0]);
            }
            return "执行成功";
        } catch (Exception e) {
            return "执行失败:" + e.getMessage();
        }
    }

    @Override
    public String uploadServicePriceInfo() {
        try {
            List<ServicePriceTraceVo> servicePriceTraceVos = uploadDao.getServicePriceTraceVo();
            String xml;
            String parameter;
            //动态调用
            Client client = dcf.createClient(webServiceUrl.getServicePriceTraceWSUrl());

            HTTPConduit http = (HTTPConduit) client.getConduit();
            HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
            httpClientPolicy.setAllowChunking(false);
//            httpClientPolicy.setAutoRedirect(true);
            http.setClient(httpClientPolicy);

            Object[] objects = new Object[0];
            QName opName = new QName("http://servicepricetrace.ws.nmmps.dhcc.com/", "receiveServiceData");
            for (int i = 0; i < servicePriceTraceVos.size(); i++) {
                log.info("日期" + servicePriceTraceVos.get(i).getDataStartDate());
                List<ServicePriceInfo> servicePriceInfos = uploadDao.getServicePriceInfosByDate(servicePriceTraceVos.get(i));
                servicePriceTraceVos.get(i).setServicePriceTrace(servicePriceInfos);

                xml = XmlUtils.object2XmlStr(servicePriceTraceVos.get(i));

                xml = replaceBlank(xml);
                xml = xml.split("\\?>")[1];
                parameter = sm4WS.encryptInfo(xml, SECRETKEY);
                objects = client.invoke(opName, HOSPCODE + parameter);
                log.info("返回数据:" + objects[0]);
            }
            return "执行成功";
        } catch (Exception e) {
            return "执行失败:" + e.getMessage();
        }
    }

    //todo
    @Override
    public String uploadHospitalResource() {
        try {
            HospitalResourceVo hospitalResourceVo = uploadDao.getHospitalResource();
            //动态调用
            Client client = dcf.createClient(webServiceUrl.getHospitalResourceWSUrl());
            Object[] objects = new Object[0];
            QName opName = new QName("http://hospitalresource.ws.nmmps.dhcc.com/", "receiveResourceData");
            String xml = XmlUtils.object2XmlStr(hospitalResourceVo);
            xml = replaceBlank(xml);
            xml = xml.split("\\?>")[1];
            String parameter = sm4WS.encryptInfo(xml, SECRETKEY);
//            log.info(xml);
            objects = client.invoke(opName, HOSPCODE + parameter);
            log.info("返回数据:" + objects[0]);
            return "执行成功" + objects[0];
        } catch (Exception e) {
            return "执行失败:" + e.getMessage();
        }
    }

    @Override
    public String uploadMedicalTempInfo() {
        MedicalTempInfo medicalTempInfo = new MedicalTempInfo();
        File file = new File("hqms_db_2017-11-01.xls");
        byte[] bytes = new byte[0];
        try {
            bytes = FileUtils.readFileToByteArray(file);
            medicalTempInfo.setSpecType("hqms");
            medicalTempInfo.setOrgCode("42501633131011511A1001");
            medicalTempInfo.setFileName("hqms_db_2017-11-01.xls");
            medicalTempInfo.setFileIoByte(bytes);
            log.info(bytes.length + "byte!");

            //动态调用
            Client client = dcf.createClient(webServiceUrl.getMedicalTempWSUrl());

            HTTPConduit http = (HTTPConduit) client.getConduit();
            HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
            httpClientPolicy.setAllowChunking(false);
            httpClientPolicy.setConnectionTimeout(30000); //连接超时时间
            httpClientPolicy.setReceiveTimeout(180000);//请求超时时间.
//            httpClientPolicy.setAutoRedirect(true);
            http.setClient(httpClientPolicy);

            Object[] objects = new Object[0];
            //invoke("方法名",参数1,参数2,参数3....);
            QName opName = new QName("http://medicaltemp.ws.drgs.dhcc.com/", "collection");
            objects = client.invoke(opName, medicalTempInfo.getSpecType(), medicalTempInfo.getOrgCode(), medicalTempInfo.getFileName(), medicalTempInfo.getFileIoByte());
            log.info("返回数据:" + objects[0]);
            return "执行成功,返回结果:" + objects[0];
        } catch (Exception e) {
            return "执行失败:" + e.getStackTrace();
        }
    }



    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
}
