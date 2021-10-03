package com.denamyte.example.demo.tasks._14595;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @see <a href="https://hyperskill.org/learn/step/14595">Getting data from REST -> Add annotations</a>
 */
@RestController
@RequestMapping("/14595")
public class SecretNumberController {
    private final Map<Long, Long> secret_numbers = Map.of(
            1L, 214071234072L,
            2L, 234923493247L,
            3L, 949493939949L,
            4L, 383832238472L,
            5L, 222993947872L
    );

    @GetMapping("/secret_numbers/{id}")
    public Map<String, Long> getNumberById(@PathVariable long id) {
        return Map.of("secret_number", secret_numbers.getOrDefault(id, -1L));
    }

}
