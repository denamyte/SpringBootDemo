package com.denamyte.example.demo.bot;

import lombok.Data;

@Data
public class UserInfo {
    private int id;
    private String name;
    private String phone;
    private boolean enabled;

    // getters and setters

    UserInfo() {}
}
