package com.proyectojava.employee.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.airline.domain.models.Airline;
import com.proyectojava.airline.infrastructure.AirlineRepository;
import com.proyectojava.airport.domain.models.Airport;
import com.proyectojava.airport.infrastructure.AirportRepository;
import com.proyectojava.employee.domain.models.Employee;
import com.proyectojava.employee.infrastructure.EmployeeRepository;
import com.proyectojava.rols.domain.models.Rols;
import com.proyectojava.rols.infrastructure.RolsRepository;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final RolsRepository rolsRepository;
    private final AirlineRepository airlineRepository;
    private final AirportRepository airportRepository;

    public EmployeeService(EmployeeRepository employeeRepository, RolsRepository rolsRepository,
            AirlineRepository airlineRepository, AirportRepository airportRepository) {
        this.employeeRepository = employeeRepository;
        this.rolsRepository = rolsRepository;
        this.airlineRepository = airlineRepository;
        this.airportRepository = airportRepository;
    }

    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.update(employee);
    }

    public Optional<Employee> findEmployeeById(String id_empleado) {
        return employeeRepository.findById(id_empleado);
    }

    public void deleteEmployee(String id_empleado) {
        employeeRepository.delete(id_empleado);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    // ROL
    public Optional<Rols> findRol(int id_rol) {
        return rolsRepository.findById(id_rol);
    }

    public List<Rols> rolsAll() {
        return rolsRepository.findAll();
    }

    //AEROLINEA
    public Optional<Airline>findAirline(int id_aerolinea){
        return airlineRepository.findById(id_aerolinea);
    }

    public List<Airline>AllAirlines(){
        return airlineRepository.findAll();
    }

    //AEROPUERTO
    public Optional<Airport>findAirport(String id_aeropuerto){
        return airportRepository.findById(id_aeropuerto);
    }

    public List<Airport>AllAirports(){
        return airportRepository.findAll();
    }
}
