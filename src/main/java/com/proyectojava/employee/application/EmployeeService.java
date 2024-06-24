package com.proyectojava.employee.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.employee.domain.models.Employee;
import com.proyectojava.employee.infrastructure.EmployeeRepository;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;
   
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void createEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee){
        employeeRepository.update(employee);
    }

    public Optional<Employee> findEmployeeById(String id_empleado){
        return employeeRepository.findById(id_empleado);
    }

    public void deleteEmployee(String id_empleado){
        employeeRepository.delete(id_empleado);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }
}
