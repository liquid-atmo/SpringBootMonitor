package com.monitor.services;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;
@Component
public class GreaterThan {
    public Predicate<Integer> greaterThan (Integer than) {
        Predicate<Integer> result = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > than;
            }
        };
        return result;
    }

}
