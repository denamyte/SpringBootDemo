package com.denamyte.example.demo.tasks._14596;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @see <a href="https://hyperskill.org/learn/daily/14596">Getting data from REST -> Three endpoints</a>
 */
@RestController
@RequestMapping("/14596")
public class ThreeEndpointsController {

    @GetMapping("/value")
    public int getValue() {
        return 1;
    }

    @GetMapping("/text")
    public String getText() {
        return "two";
    }

    @GetMapping("/json")
    public Object getJson() {
        return Map.of("number", 3);
    }

}
