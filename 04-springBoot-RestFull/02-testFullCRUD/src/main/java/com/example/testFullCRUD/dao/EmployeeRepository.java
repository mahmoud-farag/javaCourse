package com.example.testFullCRUD.dao;

import com.example.testFullCRUD.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
