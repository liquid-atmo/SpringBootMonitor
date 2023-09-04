package com.monitor.services;

import com.monitor.model.DTO.WeatherUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.Duration;

@RequiredArgsConstructor
@Service
public class WeatherApiParser {
    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(5);
    private final WebClient openWeatherApiClient;
    @Value("${cityId}")
    private String cityId;
    @Value("${appId}")
    private String appId;
    @Value("${units}")
    private String units;

    public WeatherUnit getWeather() {
        return openWeatherApiClient
                .get()
                .uri("?id=" + cityId + "&appid=" + appId + "&units=" + units)
                .retrieve()
                .bodyToMono(WeatherUnit.class)
                .block(REQUEST_TIMEOUT);
    }
}
