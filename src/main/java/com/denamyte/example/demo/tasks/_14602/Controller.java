package com.denamyte.example.demo.tasks._14602;

import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @see <a href="https://hyperskill.org/learn/step/14602">Posting and deleting data via REST -> Deleting items</a>
 */
@RestController
@RequestMapping("/14602")
public class Controller {
    final ConcurrentHashMap<Long, String> items = new ConcurrentHashMap<>(Map.of(
            55L, "Chair",
            99L, "Table",
            345L, "Vase"
    ));

    final String ERROR = "Item wasn't found";

    @GetMapping("/items/{id}")
    String getItem(@PathVariable long id) {
        String item = items.get(id);

        return item != null ? item : ERROR;
    }

    // Add your code below this line and do not change the code above the line.

    @DeleteMapping("/items/{id}")
    String deleteById(@PathVariable long id) {
        return items.containsKey(id) ? items.remove(id) : ERROR;
    }
}
