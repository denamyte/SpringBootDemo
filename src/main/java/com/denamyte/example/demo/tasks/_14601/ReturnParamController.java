package com.denamyte.example.demo.tasks._14601;

import org.springframework.web.bind.annotation.*;

/**
 * @see <a href="https://hyperskill.org/learn/daily/14601">Posting and deleting data via REST -> Return query parameter</a>
 */
@RestController
@RequestMapping("/14601")
public class ReturnParamController {

    @PostMapping("/test")
    public String paramBack(@RequestParam String param) {
        return param;
    }
}
