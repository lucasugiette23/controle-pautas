package com.projetoavenue.controlepautas.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@ConfigurationProperties(prefix = "user-info")
public class UserInfoConfig {
    private String schema;
    private String url;

}
