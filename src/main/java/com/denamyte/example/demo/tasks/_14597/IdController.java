package com.denamyte.example.demo.tasks._14597;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/14597")
public class IdController {

    @GetMapping("/{id}")
    public Object getId(@PathVariable Object id) {
        return id;
    }
}
