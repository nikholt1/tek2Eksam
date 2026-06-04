package com.example.demo.log.controller;


import com.example.demo.log.entity.LogEntity;
import com.example.demo.log.service.LogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public ResponseEntity<LogEntity> save() {
        try {
            LogEntity savedLog = logService.createLog();

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(savedLog);

        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .badRequest()
                    .build();

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @GetMapping
    public ResponseEntity<List<LogEntity>> getAll() {
        List<LogEntity> logs = logService.getAllLogs();

        if (logs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(logs);
    }
}
