package com.monitor.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class Processor {

    public List<Integer> filterWithPredicate(Stream<Integer> input, Predicate<Integer> predicate) {
        return input.filter(predicate::test)
                .collect(Collectors.toList());
    }

    public List<Number> processWithFunction(Stream<Integer> input, Action action, Integer param ) {
        switch (action) {
            case GREATER_THAN -> {
                System.out.println("Greater then " + param);
                return input.filter(x -> x > param)
                        .collect(Collectors.toList());
            }
            case LESS_THAN -> {
                System.out.println("Less than " + param);
                return input.filter(x -> x < param)
                        .collect(Collectors.toList());
            }
            case EQUALS -> {
                System.out.println("Equals " + param);
                return input.filter(x -> x.equals(param))
                        .collect(Collectors.toList());
            }
            case AVERAGE -> {
                System.out.println("Average");
                OptionalDouble res = input.mapToInt(i -> i).average();
                if (res.isPresent()) {
                    return List.of(res.getAsDouble());
                } else {
                    return Collections.emptyList();
                }

            }
            default -> {
                System.out.println("No such action!");
                throw new IllegalArgumentException();
            }
        }
    }

}
