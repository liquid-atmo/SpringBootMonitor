package com.monitor.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Webconfig {
    @Value("${baseUrl}")
    String baseUrl;
    @Bean
    public WebClient openWeatherApiClient() {
        return WebClient.create(baseUrl);
    }
}
