package com.gyj.config;

import com.gyj.utils.sm4.Sm4WSImpl;
import com.gyj.utils.sm4.Sm4WSImplService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by duanxun on 2018-12-21.
 */

@Configuration
public class Sn4WSConfig {

    @Bean
    public Sm4WSImpl Sm4WSImpl(){
        Sm4WSImplService sm4WSImplService = new Sm4WSImplService();
        return sm4WSImplService.getSm4WSImplPort();
    }
}
