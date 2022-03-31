package com.fmi.web.theaterticketsystem.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

// annotation for configuration
@ConfigurationProperties(prefix = "config")
@Configuration
public class AppConfig {

    private final LoggerConfig logger = new LoggerConfig();

    public LoggerConfig getLogger() {
        return logger;
    }

    @ConfigurationProperties(prefix = "logger")
    @Data
    public class LoggerConfig {
        private String level;
    }
}
