package com.gyj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gyj.dao")
public class GyjApplication {

	public static void main(String[] args) {
		SpringApplication.run(GyjApplication.class, args);
	}

}

