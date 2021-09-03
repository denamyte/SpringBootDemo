package com.denamyte.example.demo.tasks._14597;

import org.springframework.web.bind.annotation.*;

/**
 * @see <a href="https://hyperskill.org/learn/step/14597">Getting data from REST -> Receive and return ID</a>
 */
@RestController
@RequestMapping("/14597")
public class IdController {

    @GetMapping("/{id}")
    public Object getId(@PathVariable Object id) {
        return id;
    }
}
