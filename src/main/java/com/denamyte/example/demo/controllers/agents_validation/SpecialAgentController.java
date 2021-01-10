package com.denamyte.example.demo.controllers.agents_validation;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@RestController
@Validated
public class SpecialAgentController {

    @GetMapping("/agents/{id}")
    ResponseEntity<String> validateAgentPathVariable(
            @PathVariable("id") @Min(1) int id) {
        return ResponseEntity.ok("Agent id is valid.");
    }

    @GetMapping("/agents/validate")
    ResponseEntity<String> validateAgentRequestParam(
            @RequestParam("code") @Pattern(regexp = "[0-9]{1,3}") String code) {
        return ResponseEntity.ok("Agent code is valid.");
    }

    @PostMapping("/agents/validate/agent")
    public ResponseEntity<String> validate(@Valid @RequestBody SpecialAgent agent) {
        if (agent == null) {
            throw new NullPointerException();
        }
        return ResponseEntity.ok("Agent info is valid.");
    }
}
