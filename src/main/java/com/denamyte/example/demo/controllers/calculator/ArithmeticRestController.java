package com.denamyte.example.demo.controllers.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.function.BiFunction;

@RestController
public class ArithmeticRestController {

    private Map<String, BiFunction<Integer, Integer, Long>> operations = Map.of(
            "add", (a, b) -> (long) a + b,
            "subtract", (a, b) -> (long) a - b,
            "mult", (a, b) -> (long) a * b
    );

    @GetMapping(path = "/calc/{operation}")
    public String calculate(@PathVariable String operation,
                            @RequestParam int a,
                            @RequestParam int b) {
        return operations.containsKey(operation)
                ? "" + operations.get(operation).apply(a, b)
                : "Unknown operation";
    }
}