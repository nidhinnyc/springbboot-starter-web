package com.starter.samplewebapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.starter.samplewebapp.model.Employee;
import com.starter.samplewebapp.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    private EmployeeRepository repo;

    @Override
    public void saveEmployee(Employee emp){
        repo.save(emp);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        repo.deleteById(id);
        
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Optional<Employee> opt = repo.findById(id);
		if(opt.isEmpty()) {
			return null;
		}
		return opt.get();
    }

    @Override
    public void updateEmployee(Employee emp) {
        repo.save(emp);
    }
}
