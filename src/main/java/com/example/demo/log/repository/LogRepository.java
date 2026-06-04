package com.example.demo.log.repository;

import com.example.demo.log.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<LogEntity,Long> {


}
