package com.gyj.service.impl;

import com.google.gson.Gson;
import com.gyj.service.ImportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gyj.utils.ImportExcelUtil.parseExcel;

/**
 * Created by duanxun on 2018-12-21.
 */
@Service
@Slf4j
public class ImportServiceImpl implements ImportService {

    /**
     * 药品-对照 药品-院内上传
     * @return
     */
    @Override
    public String importDrugPriceInfo() {
        Map<String, String> ypzdMap = new HashMap<String, String>();
        ypzdMap.put("药品编码", "ypId");
        ypzdMap.put("产品通用名称", "cptym");
        ypzdMap.put("药品大类", "ypdl");
        ypzdMap.put("药理分类/功效", "ylfl");
        ypzdMap.put("批准文号", "pzwh");
        ypzdMap.put("剂型", "jx");
        ypzdMap.put("制剂规格", "zjgg");
        ypzdMap.put("制剂单位", "zzdw");
        ypzdMap.put("最小销售包装单位", "zxbzdw");
        ypzdMap.put("包装规格（转换系数）", "zhxs");


        Map<String, String> ypdzMap = new HashMap<String, String>();
        ypdzMap.put("药管平台编码YPID", "ypId");
        ypdzMap.put("院内药品编码", "byypId");
        ypdzMap.put("商品名", "spm");
        ypdzMap.put("药品生产企业名称", "ypcd");
        try {
            List<Map<String, Object>> ypzd = importDZ("ypdz.xlsx",ypzdMap,3);
            List<Map<String, Object>> ypdz = importYL("ypyl.xlsx",ypdzMap,3);

            log.info(ypzd.size() + "ypzd!!size!!ypdz" + ypdz.size());
            return new Gson().toJson(ypzd);
        }catch (IOException e){
            e.printStackTrace();
            return "IOException" + e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return "Exception" + e.getMessage();
        }
    }

    /**
     * 高值耗材-对照 高值耗材-院内上传
     * @return
     */
    @Override
    public String importMaterialPriceInfo() {
        Map<String, String> gzhczdMap = new HashMap<String, String>();
        gzhczdMap.put("高值医用耗材统一标识码HCBS", "gzhcbm");
        gzhczdMap.put("高值医用耗材名称*", "gzhcmc");
        gzhczdMap.put("注册证产品名称", "zczcpmc");
        gzhczdMap.put("商品名", "spm");
        gzhczdMap.put("注册证号/备案号/生产许可证号", "zczbh");
        gzhczdMap.put("型号*", "xh");
        gzhczdMap.put("规格*", "gg");
        gzhczdMap.put("最小计量单位*", "zxjldw");
        gzhczdMap.put("最小销售包装*", "zxbz");
        gzhczdMap.put("包装规格（转换系数）*", "zhxs");
        gzhczdMap.put("高值医用耗材生产企业名称", "gzhcscqymc");
        gzhczdMap.put("产品统一码", "cptym");
        gzhczdMap.put("注册证ID", "zczId");

        Map<String, String> gzhcdzMap = new HashMap<String, String>();
        gzhcdzMap.put("高值医用耗材统一标识码HCBS", "gzyyhctybzm");
        gzhcdzMap.put("院内高值医用耗材编码*", "bygzhcbm");
        try {
            List<Map<String, Object>> gzhczd = importDZ("gzhcdz.xlsx",gzhczdMap,2);
            List<Map<String, Object>> gzhcdz = importYL("gzhcyl.xlsx",gzhcdzMap,2);
            log.info(gzhczd.size() + "gzhczd!!size!!gzhcdz" + gzhcdz.size());
            return new Gson().toJson(gzhczd);
        }catch (IOException e){
            e.printStackTrace();
            return "IOException" + e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return "Exception" + e.getMessage();
        }
    }

    /**
     * 医疗收费-对照 医疗收费-院内上传
     * @return
     */
    @Override
    public String importServicePriceInfo() {
        Map<String, String> ylzdMap = new HashMap<String, String>();
        ylzdMap.put("医疗服务价格项目编码*", "ylfwjgxmbm");
        ylzdMap.put("医疗服务价格项目制定依据名称", "ylfwjgxmmc");
        ylzdMap.put("项目内涵", "xmnh");
        ylzdMap.put("计价单位*", "jjdw");
        ylzdMap.put("全国医疗服务价格项目规范编码", "qgylfwjgxmbm");
        ylzdMap.put("全国医疗服务价格项目规范名称", "qgylfwjgxmgfmc");
        ylzdMap.put("计价说明", "jjsm");

        Map<String, String> yldzMap = new HashMap<String, String>();
        yldzMap.put("全国医疗服务价格项目规范编码", "qgylfwjgxmbm");
        yldzMap.put("院内医疗服务价格项目编码*", "byfyId");
        try {
            List<Map<String, Object>> ylzd = importDZ("ylsfdz.xlsx",ylzdMap,2);
            List<Map<String, Object>> yldz = importYL("ylsfyl.xlsx",yldzMap,2);
            log.info(ylzd.size() + "ylzd!!size!!yldz" + yldz.size());
            return new Gson().toJson(ylzd);
        }catch (IOException e){
            e.printStackTrace();
            return "IOException" + e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return "Exception" + e.getMessage();
        }
    }

    private List<Map<String, Object>> importDZ(String fileName,Map<String, String> m,int titleRowNum) throws Exception {
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        List<Map<String, Object>> ls = parseExcel(fis, file.getName(), m,false,titleRowNum);
        return ls;
    }

    private List<Map<String, Object>> importYL(String fileName,Map<String, String> m,int titleRowNum) throws Exception {
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        List<Map<String, Object>> ls = parseExcel(fis, file.getName(), m,true,titleRowNum);
        return ls;
    }
}
