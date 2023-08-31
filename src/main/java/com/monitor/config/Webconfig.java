package com.monitor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Webconfig {
    @Bean
    public WebClient openWeatherApiClient() {
        return WebClient.create("https://api.openweathermap.org/data/2.5/weather");
    }
}
