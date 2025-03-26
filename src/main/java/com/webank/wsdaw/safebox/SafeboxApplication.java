package com.webank.wsdaw.safebox;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(value = "com.webank.wsdaw.safebox.dao.mapper")
public class SafeboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SafeboxApplication.class, args);
    }
}
