package com.webank.wsdaw.safebox.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;



@Configuration
@ConfigurationProperties("system")
@Data
public class SystemConfig {

    private String encryptPrivateKey;
}
