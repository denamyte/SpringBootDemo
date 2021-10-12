package com.denamyte.example.demo.tasks._15214;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @see <a href="https://hyperskill.org/learn/step/15214">Exception handling -> Implement DELETE endpoint</a>
 */
@RestController
@RequestMapping("/15214")
public class Controller15214 {

    final Map<Long, String> users = new ConcurrentHashMap<>(Map.of(
            2234L, "Kate",
            234234234L, "Alice",
            2134L, "Jessica",
            3456L, "Olivia",
            98684L, "Emma",
            85L, "Liam",
            8495L, "James",
            48438L, "Henry"
    ));

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return (users.remove(id) == null
                ? ResponseEntity.notFound()
                : ResponseEntity.noContent()).build();
    }
}
