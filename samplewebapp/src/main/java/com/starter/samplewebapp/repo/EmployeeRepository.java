package com.starter.samplewebapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starter.samplewebapp.model.Employee;

public interface EmployeeRepository extends JpaRepository <Employee, Integer> {
    
}
