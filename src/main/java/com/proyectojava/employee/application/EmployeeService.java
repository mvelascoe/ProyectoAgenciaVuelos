package com.proyectojava.employee.application;

import java.util.List;
import java.util.Optional;
import com.proyectojava.employee.adapters.out.EmployeeMySQLRepository;
import com.proyectojava.employee.domain.models.Employee;

public class EmployeeService {
    private final EmployeeMySQLRepository employeeMySQLRepository;

    public EmployeeService(EmployeeMySQLRepository employeeMySQLRepository) {
        this.employeeMySQLRepository = employeeMySQLRepository;
    }

    public void createEmployee(Employee employee){
        employeeMySQLRepository.save(employee);
    }

    public void updateEmployee(Employee employee){
        employeeMySQLRepository.update(employee);
    }

    public Optional<Employee> findEmployeeById(String id_empleado){
        return employeeMySQLRepository.findById(id_empleado);
    }

    public void deleteEmployee(String id_empleado){
        employeeMySQLRepository.delete(id_empleado);
    }

    public List<Employee> findAllEmployees(){
        return employeeMySQLRepository.findAll();
    }
}
