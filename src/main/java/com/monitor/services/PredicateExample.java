package com.monitor.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
@Service
public class PredicateExample {
    int[] input = {1,2,3,4,5,6,7,8,9,10};
    Predicate<Integer> greaterThenFive = i -> i > 5;



    public List<Integer> filteredList = Arrays.stream(input).filter(x -> greaterThenFive.test(x))
            .boxed().collect(Collectors.toList());

}
