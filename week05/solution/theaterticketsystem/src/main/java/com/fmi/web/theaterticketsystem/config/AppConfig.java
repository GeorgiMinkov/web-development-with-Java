package com.fmi.web.theaterticketsystem.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "config")
@Configuration
@Data
public class AppConfig {
    private LoggerConfig logger = new LoggerConfig();

    @Data
    public class LoggerConfig {
        private String level;
    }
}
