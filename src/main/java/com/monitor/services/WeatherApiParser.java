package com.monitor.services;

import com.monitor.model.DTO.WeatherUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.Duration;

@RequiredArgsConstructor
@Service
public class WeatherApiParser {
    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(5);

    private final WebClient openWeatherApiClient;
//todo убрать хардкод сити айди и апп айди
    public WeatherUnit getWeather() {
        return openWeatherApiClient
                .get()
                .uri("?id=551847&appid=a1f0903165400cdcb97075a147be4037&units=metric")
                .retrieve()
                .bodyToMono(WeatherUnit.class)
                .block(REQUEST_TIMEOUT);
    }
}
