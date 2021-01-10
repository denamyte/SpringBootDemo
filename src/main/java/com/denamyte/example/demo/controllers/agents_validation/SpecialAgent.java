package com.denamyte.example.demo.controllers.agents_validation;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@Validated
public class SpecialAgent {

    @NotNull
    private String name;
    private String surname;

    @Size(min = 1, max = 3, message = "The code must have length from 1 to 3")
    @Pattern(regexp = "[0-9]{1,3}", message = "The code must contain only digits")
    private String code;
    private String status;

    @Min(value = 18, message = "Age must be greater than or equal to 18")
    private int age;

    @Size(min = 1, max = 4)
    private List<String> cars;

    @Max(5)
    private int numberOfCurrentMissions;

    @NotNull
    @Email
    private String email;

}
