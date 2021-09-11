package com.denamyte.example.demo.tasks._14466;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

class Task {
    private final String name;
    private final String description;

    Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

/**
 * @see <a href="https://hyperskill.org/learn/step/14466">Getting data from REST -> Getting all tasks </a>
 */
@RestController
@RequestMapping("/14466")
public class TaskController2 {
    List<Task> tasks = List.of(
            new Task("Improve UI", "implement ..."),
            new Task("Color bug", "fix ...")
    );

    @GetMapping("/tasks/all")
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(tasks);
    }
}
