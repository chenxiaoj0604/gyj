package com.gyj.domain;

import lombok.Data;

/**
 * @author Qiang
 * @date 2018/6/29 10:24
 * @description 返回头信息
 */
@Data
public class MessageHeader {
    /**
     * 标识
     */
    private String code;

    /**
     * 响应描述
     */
    private String desc;


    public MessageHeader(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static MessageHeader fail(String failMsg){
        return new MessageHeader("1",failMsg);
    }

    public static MessageHeader success(){
        return new MessageHeader("0","成功");
    }

    public static MessageHeader fail(){
        return new MessageHeader("1","失败");
    }

}
