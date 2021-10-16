package com.denamyte.example.demo.tasks._15218;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @see <a href="https://hyperskill.org/learn/step/15218">Handling requests with bodies -> Important message</a>
 */
@RestController
@RequestMapping("/15218")
public class Controller15218 {

    public static final String NAME = "importantMessage";
    private String message = "";

    @PostMapping("/message")
    public ResponseEntity saveMessage(@RequestBody Map<String, String> body) {
        this.message = body.get(NAME);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/message")
    public ResponseEntity<Map<String, String>> message() {
        return ResponseEntity.ok(Map.of(NAME, message));
    }
}
