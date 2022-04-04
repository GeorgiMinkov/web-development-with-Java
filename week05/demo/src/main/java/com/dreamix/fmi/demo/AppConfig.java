package com.dreamix.fmi.demo;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "config")
@Component
@Getter
public class AppConfig {

    private final Song song = new Song();

    @Data
    @ConfigurationProperties(prefix = "song")
    public class Song {
        private String rock;
        private String softRock;
    }
}
