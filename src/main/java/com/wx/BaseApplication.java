package com.wx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wx.*.mapper")
public class BaseApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BaseApplication.class, args);
    }


}
