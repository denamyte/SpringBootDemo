package com.denamyte.example.demo.tasks._14465;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @see <a href="https://hyperskill.org/learn/daily/14465">Getting data from REST -> Welcome</a>
 */
@RestController
@RequestMapping("/14465")
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome!";
    }
//    @GetMapping("/welcome")
//    public ResponseEntity<String> welcome() {
//        return new ResponseEntity<>("Welcome!", HttpStatus.OK);
//    }
}
