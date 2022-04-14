package com.fmi.web.theaterticketsystem.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "config")
@Configuration

public class AppConfig {
    private LoggerConfig logger = new LoggerConfig();

    public LoggerConfig getLogger() {
        return logger;
    }

    public void setLogger(LoggerConfig logger) {
        this.logger = logger;
    }

    public class LoggerConfig {
        private String level;

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }
    }
}
