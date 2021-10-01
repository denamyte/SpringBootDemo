package com.denamyte.example.demo.tasks._14467;

import org.springframework.web.bind.annotation.*;

import java.util.List;

class Task {
    private final int id;
    private final String name;
    private final String description;

    Task(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

/**
 * @see <a href="https://hyperskill.org/learn/step/14467">Getting data from REST -> Retrieving specific task</a>
 */
@RestController
@RequestMapping("/14467")
public class DefaultTaskController {
    List<Task> tasks = List.of(
            new Task(405, "Improve UI", "implement ..."),
            new Task(406, "Color bug", "fix ...")
    );

    private static final Task defaultTask = new Task(0, null, null);

    @GetMapping("/task/{id}")
    public Task getTask(@PathVariable int id) {
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElse(defaultTask);
    }

}
