package com.denamyte.example.demo.controllers.tasks._14600;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @see <a href="https://hyperskill.org/learn/step/14600">Posting and deleting data via REST -> Storing user names<a/>
 */
@RestController
@RequestMapping("/14600/users")
public class UserController {

    private final ConcurrentLinkedQueue<String> names = new ConcurrentLinkedQueue<>();


    @PostMapping("")
    public ResponseEntity<?> addUser(@RequestParam String name) {
        names.add(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Collection<String>> getUsers() {
        return new ResponseEntity<>(names, HttpStatus.OK);
    }

    @GetMapping("/echo")
    public ResponseEntity<?> echo() {
        return new ResponseEntity<>("It works", HttpStatus.OK);
    }
}
