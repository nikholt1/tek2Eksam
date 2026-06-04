package com.example.demo.config;

import com.example.demo.log.entity.LogEntity;
import com.example.demo.log.repository.LogRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Configuration
public class InitApp {

    @Bean
    CommandLineRunner initDatabase(LogRepository logRepository) {

        return args -> {

            LogEntity log1 = new LogEntity();
            log1.setLogTime(LocalDateTime.of(2018, Month.OCTOBER, 24, 12, 30));

            LogEntity log2 = new LogEntity();
            log2.setLogTime(LocalDateTime.of(2019, Month.JANUARY, 10, 9, 15));

            LogEntity log3 = new LogEntity();
            log3.setLogTime(LocalDateTime.of(2020, Month.MARCH, 5, 18, 45));

            LogEntity log4 = new LogEntity();
            log4.setLogTime(LocalDateTime.of(2021, Month.JULY, 20, 14, 0));

            LogEntity log5 = new LogEntity();
            log5.setLogTime(LocalDateTime.of(2022, Month.NOVEMBER, 2, 6, 10));

            LogEntity log6 = new LogEntity();
            log6.setLogTime(LocalDateTime.of(2023, Month.DECEMBER, 31, 23, 59));

            logRepository.saveAll(List.of(log1, log2, log3, log4, log5, log6));
        };
    }
}