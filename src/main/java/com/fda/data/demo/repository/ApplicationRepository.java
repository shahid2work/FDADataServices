package com.fda.data.demo.repository;

import com.fda.data.demo.Entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}