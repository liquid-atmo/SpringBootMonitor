package com.monitor.DAO;

import com.monitor.model.DTO.WeatherUnit;
import com.monitor.services.WeatherApiParser;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@RequiredArgsConstructor
@Component
public class DataManager {
    private final WeatherApiParser wap;
    public static CopyOnWriteArrayList<WeatherUnit> weatherUnitsList = new CopyOnWriteArrayList<>();
    public static ConcurrentHashMap<Long, List<WeatherUnit>> weatherUnitsMap = new ConcurrentHashMap<>();

    @Value("${timeout}")
    private int timeout;
    @PostConstruct
    public void updateData() throws InterruptedException {

        for (int i = 0; i < 50; i++) {
            System.out.println("Timeout, min: " + timeout);
            WeatherUnit response = wap.getWeather() ;
            weatherUnitsList.add(response);
            weatherUnitsMap.computeIfAbsent(response.getId(), v -> new ArrayList<>()).add(response);

            System.out.println(weatherUnitsList.get(weatherUnitsList.size() - 1));
            Thread.sleep(1000 * 60 * timeout);
        }
    }
}
