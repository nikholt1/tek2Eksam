package com.example.demo.log.service;


import com.example.demo.log.entity.LogEntity;
import com.example.demo.log.repository.LogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogService {

    private final LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public LogEntity createLog() {
        LogEntity logEntity = new LogEntity();
        logEntity.setLogTime(LocalDateTime.now());

        LogEntity saved = logRepository.save(logEntity);

        if (saved.getId() == null) {
            throw new RuntimeException("Failed to save log");
        }

        return saved;
    }
}
