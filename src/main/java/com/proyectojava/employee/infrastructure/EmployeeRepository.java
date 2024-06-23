package com.proyectojava.employee.infrastructure;

import java.util.List;
import java.util.Optional;

import com.proyectojava.employee.domain.models.Employee;

public interface EmployeeRepository {
    void save(Employee employee);
    void update(Employee employee);
    Optional<Employee> findById(String id_empleado);
    void delete(String id_empleado);
    List<Employee> findAll();
}
