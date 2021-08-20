package com.denamyte.example.demo.tasks._14599;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @see <a href="https://hyperskill.org/learn/daily/14599">Getting data from REST -> Two endpoints</a>
 */
@RestController
@RequestMapping("/14599")
public class StudentController {

    private Map<Integer, Student> studentMap = new ConcurrentSkipListMap<>(Map.of(
            1, new Student(1, "Mark"),
            2, new Student(2, "Jane"),
            3, new Student(3, "Alex"))
    );

    @GetMapping("/students")
    public ResponseEntity<Collection<Student>> getAll() {
        return ResponseEntity.ok(studentMap.values());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getById(@PathVariable int id) {
        return ResponseEntity.ok(studentMap.get(id));
    }

    static class Student {

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public final int id;
        public final String name;
    }

}
