package com.sp.sp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "limit")
@Data
public class LimitConfig {
    private String setParam;
    private String useParam;

}
