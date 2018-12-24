package com.gyj.controller;

import com.gyj.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by duanxun on 2018-12-21.
 */
@Controller
@ResponseBody
@RequestMapping("upload")
@Slf4j
public class UploadController {

    @Autowired
    private UploadService uploadService;

    /**
     * 药品价格上传
     * @return
     */
    @GetMapping("/uploadDrugPriceInfo")
    public String uploadDrugPriceInfo(){
        log.info("**********药品价格上传");
        return uploadService.uploadDrugPriceInfo();
    }

    /**
     * 高值耗材上传
     * @return
     */
    @GetMapping("/uploadMaterialPriceInfo")
    public String uploadMaterialPriceInfo(){
        log.info("**********高值耗材上传");
        return uploadService.uploadMaterialPriceInfo();
    }

    /**
     * 医疗服务价格上传
     * @return
     */
    @GetMapping("/uploadServicePriceInfo")
    public String uploadServicePriceInfo(){
        log.info("**********医疗服务价格上传");
        return uploadService.uploadServicePriceInfo();
    }

    /**
     * 医疗机构资源上传
     * @return
     */
    @GetMapping("/uploadHospitalResource")
    public String uploadHospitalResource(){
        log.info("**********医疗机构资源上传");
        return uploadService.uploadHospitalResource();
    }

    /**
     * 病案首页上传
     * @return
     */
    @GetMapping("/uploadMedicalTempInfo")
    public String uploadMedicalTempInfo(){
        log.info("**********病案首页上传");
        return uploadService.uploadMedicalTempInfo();
    }

}
