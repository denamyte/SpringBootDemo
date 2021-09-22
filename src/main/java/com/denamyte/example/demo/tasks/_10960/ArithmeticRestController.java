package com.denamyte.example.demo.tasks._10960;

import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.function.BiFunction;

/**
 * @see <a href="https://hyperskill.org/learn/step/10960">Posting and deleting data via REST -> Web calculator </a>
 */
@RestController
@RequestMapping("/10960")
public class ArithmeticRestController {

    private final Map<String, BiFunction<Integer, Integer, String>> operations = Map.of(
            "add", (a, b) -> a + b + "",
            "subtract", (a, b) -> a - b + "",
            "mult", (a, b) -> a * b + ""
    );

    @GetMapping(path = "/{operation}")
    public String calculate(@PathVariable String operation,
                            @RequestParam int a,
                            @RequestParam int b) {
        return operations.containsKey(operation)
                ? operations.get(operation).apply(a, b)
                : "Unknown operation";
    }
}