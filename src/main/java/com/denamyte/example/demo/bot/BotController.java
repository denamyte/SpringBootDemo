package com.denamyte.example.demo.bot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BotController {

    @PostMapping(value = "/greet", consumes = "application/json")
    public String greet(@RequestBody UserInfo userInfo) {
        StringBuilder message = new StringBuilder("Hello! Nice to see you, %s!");
        if (!userInfo.isEnabled()) {
            message.append(" Your account is disabled");
        }
        return String.format(message.toString(), userInfo.getName());
    }

    @PostMapping(value = "/logout", consumes = "application/json")
    public String logout(@RequestBody List<UserInfo> userInfoList) {
        //logging out users
        return String.format("OK, %d of the users have been logged out!", userInfoList.size());
    }

}
