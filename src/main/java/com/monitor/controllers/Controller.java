package com.monitor.controllers;

import com.monitor.services.Action;
import com.monitor.services.GreaterThan;
import com.monitor.services.Processor;
import com.monitor.services.WeatherApiParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;


import java.util.List;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final Processor processor;
    private final GreaterThan gt;
    private final WeatherApiParser wap;


    @RequestMapping("/monitor")
    @ResponseBody
    String filterGetParams(@RequestParam List<Integer> input) {
        return processor.filterWithPredicate(
                input.stream(), gt.greaterThan(6)).toString();
    }

    @RequestMapping("/monitor/function")
    @ResponseBody
    String processGetParams(@RequestParam List<Integer> input, @RequestParam Action action,
                            @RequestParam Integer param) {
        return processor.processWithFunction(input.stream(), action, param).toString();
    }

    @RequestMapping("/monitor/weatherByCity")
    String getWeatherByCity() {
        return wap.getWeather().toString();
    }
}

//todo 100% test coverage
// todo implement message service
// todo implement triggering mechanism
// todo implement frontend to set rules for monitoring
// todo implement authorization
// todo autodocumentation
// todo thread which parses weather data to measurement list
/* при старте приложение начинает коннектиться к weather api и сохранять данные в некий кэш thread1
* thread n читает из кэша измерений и если пороговое значение срабатывает - шлёт сообщение
* thread n запускается по кнопке с фронта и выключается по ней же
 */