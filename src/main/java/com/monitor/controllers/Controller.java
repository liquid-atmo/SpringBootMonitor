package com.monitor.controllers;

import com.monitor.services.PredicateExample;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;


import java.util.Map;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final PredicateExample predicateExample;

    @Value("#{systemProperties}")
    private Map<String, String> systemPropertiesMap;

    @RequestMapping("/")
    String home() {
       return predicateExample.filteredList.toString();
    }


}
//todo прикрутить ломбок