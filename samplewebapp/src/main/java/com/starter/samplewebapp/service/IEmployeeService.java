package com.starter.samplewebapp.service;

import java.util.List;

import com.starter.samplewebapp.model.Employee;

public interface IEmployeeService {
    void saveEmployee(Employee emp);
    List<Employee> getAllEmployees();
    void deleteEmployeeById(Integer id);
	Employee getEmployeeById(Integer id);
	void updateEmployee(Employee emp);
}
