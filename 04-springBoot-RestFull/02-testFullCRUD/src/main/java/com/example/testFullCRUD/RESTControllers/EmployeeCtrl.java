package com.example.testFullCRUD.RESTControllers;


import com.example.testFullCRUD.Entities.Employee;
import com.example.testFullCRUD.Services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeCtrl {

    private EmployeeService employeeService;

    public EmployeeCtrl (EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeID}")
    public Employee getEmployeeByID (@PathVariable int employeeID) {

        return employeeService.findByID(employeeID);
    }
}
