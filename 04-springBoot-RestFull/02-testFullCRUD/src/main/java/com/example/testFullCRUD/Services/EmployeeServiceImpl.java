package com.example.testFullCRUD.Services;

import com.example.testFullCRUD.Entities.Employee;
import com.example.testFullCRUD.dao.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee findByID(int id) {
        Optional<Employee>  result = employeeRepository.findById(id);

        Employee emp = null;
        if (result.isPresent()) {
            emp = result.get();
        } else {
            throw new RuntimeException("Employee Did not found - " + id);
        }

        return emp;
    }
}
