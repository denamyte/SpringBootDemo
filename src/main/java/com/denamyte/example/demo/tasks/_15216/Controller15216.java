package com.denamyte.example.demo.tasks._15216;

import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @see  <a href="https://hyperskill.org/learn/daily/15216">Handling requests with bodies -> Adding new functionality</a>
 */
@RestController
@RequestMapping("/15216")
public class Controller15216 {
    Map<Integer, String> map = new ConcurrentHashMap<>();
    AtomicInteger idGenerator = new AtomicInteger();

    public static class Data {
        public String data;
    }

    @GetMapping("/api/data/{id}")
    public Map<String, String> getData(@PathVariable int id) {
        return Map.of("data", map.get(id));
    }

    @PostMapping("/api/data/new")
    public Map<String, Integer> createData(@RequestBody Data data) {
        Integer id = idGenerator.incrementAndGet();
        map.put(id, data.data);
        return Map.of("id", id);
    }

}
