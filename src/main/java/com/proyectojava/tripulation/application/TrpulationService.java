package com.proyectojava.tripulation.application;

import java.util.List;
import java.util.Optional;

import com.proyectojava.employee.domain.models.Employee;
import com.proyectojava.employee.infrastructure.EmployeeRepository;
import com.proyectojava.tripulation.domain.models.Tripulation;
import com.proyectojava.flightconnection.domain.models.FlightConnection;
import com.proyectojava.flightconnection.infrastructure.FlightConnectionRepository;
import com.proyectojava.tripulation.infrastructure.TripulationRepository;

public class TrpulationService {
    private final TripulationRepository tripulationRepository;
    private final EmployeeRepository employeeRepository;
    private final FlightConnectionRepository flightConnectionRepository;


    public TrpulationService(TripulationRepository tripulationRepository, EmployeeRepository employeeRepository,
            com.proyectojava.flightconnection.infrastructure.FlightConnectionRepository flightConnectionRepository) {
        this.tripulationRepository = tripulationRepository;
        this.employeeRepository = employeeRepository;
        this.flightConnectionRepository = flightConnectionRepository;
    }

    public void createTripulation(Tripulation tripulation){
        tripulationRepository.save(tripulation);
    }

    public void updateTripulation(Tripulation tripulation){
        tripulationRepository.update(tripulation);
    }

    public Optional<Tripulation> findTripulationById(int id_tripulacion){
        return tripulationRepository.findById(id_tripulacion);
    }

    public void deleteTripulation(int id_tripulacion){
        tripulationRepository.delete(id_tripulacion);
    }

    public List<Tripulation>findAllTripulation(){
        return tripulationRepository.findAll();
    }

    //EMPLOYEE
    public Optional<Employee>EmployeeId(String id_empleado){
        return employeeRepository.findById(id_empleado);
    }

    public List<Employee>EmployeeAll(){
        return employeeRepository.findAll();
    }

    //FLIGHTConnection
    public Optional<FlightConnection>FlightConnectionById(int id_trayectoria){
        return flightConnectionRepository.findById(id_trayectoria);
    }

    public List<FlightConnection> allConnections(){
        return flightConnectionRepository.findAll();
    }
}
