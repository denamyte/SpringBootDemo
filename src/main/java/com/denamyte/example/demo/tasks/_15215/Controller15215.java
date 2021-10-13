package com.denamyte.example.demo.tasks._15215;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 
 */
@RestController
@RequestMapping("*15215")
public class Controller15215 {

    @GetMapping("/test/{status}")
    public ResponseEntity getStatus(@PathVariable int status) {
        return ResponseEntity.status(status).build();
    }
}
