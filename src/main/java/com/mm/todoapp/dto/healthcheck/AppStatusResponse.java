package com.mm.todoapp.dto.healthcheck;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AppStatusResponse {

    private String status;
    private LocalDateTime timestamp;
}
