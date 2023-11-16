package com.scurtis.cfs.config;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.util.Assert.hasText;

@Data
@Configuration
@ConfigurationProperties(prefix = "cfs")
public class CfsConfig {

    private String baseUrl;
    private String apiKey;

    @PostConstruct
    public void postConstruct() {
        hasText(baseUrl, "cfs.base-url is a required property");
        hasText(apiKey, "cfs.api-key is a required property");
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
            .baseUrl(baseUrl)
            .defaultHeader("Authorization", "Bearer " + apiKey)
            .build();
    }

}
