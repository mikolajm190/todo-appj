package com.mm.todoapp.controller;

import com.mm.todoapp.dto.healthcheck.AppStatusResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/healthcheck")
public class HealthcheckController {

    @GetMapping("/app")
    public AppStatusResponse appStatus() {
        return new AppStatusResponse(
                "UP",
                LocalDateTime.now()
        );
    }
}
