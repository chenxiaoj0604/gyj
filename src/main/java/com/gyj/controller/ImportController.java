package com.gyj.controller;

import com.gyj.service.ImportService;
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
@RequestMapping("import")
@Slf4j
public class ImportController {

    @Autowired
    private ImportService importService;

    /**
     * 药品-对照 药品-院内上传
     * @return
     */
    @GetMapping("/importDrugPriceInfo")
    public String importDrugPriceInfo(){
        log.info("**********药品-对照 药品-院内上传");
        return importService.importDrugPriceInfo();
    }

    /**
     * 高值耗材-对照 高值耗材-院内上传
     * @return
     */
    @GetMapping("/importMaterialPriceInfo")
    public String importMaterialPriceInfo(){
        log.info("**********高值耗材-对照 高值耗材-院内上传");
        return importService.importMaterialPriceInfo();
    }

    /**
     * 医疗收费-对照 医疗收费-院内上传
     * @return
     */
    @GetMapping("/importServicePriceInfo")
    public String importServicePriceInfo(){
        log.info("**********医疗收费-对照 医疗收费-院内上传");
        return importService.importServicePriceInfo();
    }
}
