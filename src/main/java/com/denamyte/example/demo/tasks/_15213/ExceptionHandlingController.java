package com.denamyte.example.demo.tasks._15213;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @see <a href="https://hyperskill.org/learn/step/15213">Exception handling -> Improve the program</a>
 */
@RestController
@RequestMapping("/15213")
public class ExceptionHandlingController {
    final ConcurrentMap<Long, String> items = new ConcurrentHashMap<>(Map.of(
            535L, "Chair",
            99534533L, "Table",
            343455L, "Vase"
    ));

    @GetMapping("/items/{id}")
    ResponseEntity<String> getItem(@PathVariable long id) {
        return items.containsKey(id)
                ? ResponseEntity.ok(items.get(id))
                : ResponseEntity.notFound().build();
    }
}
