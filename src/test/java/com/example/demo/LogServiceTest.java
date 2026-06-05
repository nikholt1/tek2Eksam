package com.example.demo;

import com.example.demo.log.entity.LogEntity;
import com.example.demo.log.repository.LogRepository;
import com.example.demo.log.service.LogService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
class LogServiceTest {

    @Mock
    private LogRepository logRepository;

    @InjectMocks
    private LogService logService;

    @Test
    void createLog_shouldSaveAndReturnLog() {
        // Arrange
        LogEntity savedLog = new LogEntity();
        savedLog.setId(1L);
        savedLog.setLogTime(LocalDateTime.now());

        when(logRepository.save(any(LogEntity.class)))
                .thenReturn(savedLog);

        // Act
        LogEntity result = logService.createLog();

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());

        verify(logRepository, times(1))
                .save(any(LogEntity.class));
    }
}
