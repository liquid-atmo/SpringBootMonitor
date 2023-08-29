package com.monitor.controllers;

import com.monitor.services.Action;
import com.monitor.services.GreaterThan;
import com.monitor.services.Processor;
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
}
