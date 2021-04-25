package com.projetoavenue.controlepautas.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@ConfigurationProperties(prefix = "user-info")
public class UserInfoConfig {
    @Value("${user-info.schema}")
    private String schema;
    @Value("${user-info.url}")
    private String url;

}
