package com.proyectojava.tripbookingdetails.aplication;

import java.util.List;
import java.util.Optional;

import com.proyectojava.customer.domain.models.Customer;
import com.proyectojava.customer.infrastructure.CustomerRepository;
import com.proyectojava.flightfare.domain.models.Flightfare;
import com.proyectojava.flightfare.infrastructure.FlightfareRepository;
import com.proyectojava.tripbooking.domain.models.Tripbooking;
import com.proyectojava.tripbooking.infrastructure.TripbookingRepository;
import com.proyectojava.tripbookingdetails.domain.models.TripBokkingDetails;
import com.proyectojava.tripbookingdetails.infrastructure.TripBookkingDetailsRepository;

public class TripBookingDetailsService {
    private final TripBookkingDetailsRepository tripBookkingDetailsRepository;
    private final TripbookingRepository  tripbookingRepository;//TRIPBOOKING
    private final CustomerRepository customerRepository;//COSTUMER
    private final FlightfareRepository flightfareRepository;//FLIGTHFARE

    public TripBookingDetailsService(TripBookkingDetailsRepository tripBookkingDetailsRepository,
            TripbookingRepository tripbookingRepository, CustomerRepository customerRepository,
            FlightfareRepository flightfareRepository) {
        this.tripBookkingDetailsRepository = tripBookkingDetailsRepository;
        this.tripbookingRepository = tripbookingRepository;
        this.customerRepository = customerRepository;
        this.flightfareRepository = flightfareRepository;
    }

    public void createTripBookinDetail(TripBokkingDetails tripBokkingDetails){
        tripBookkingDetailsRepository.save(tripBokkingDetails);
    }

    public void updateTripBookingDetail(TripBokkingDetails tripBokkingDetails){
        tripBookkingDetailsRepository.update(tripBokkingDetails);
    }

    public Optional<TripBokkingDetails>findDetailById(int id_trip_booking_details){
        return tripBookkingDetailsRepository.findById(id_trip_booking_details);
    }

    public void deleteDetail(int id_trip_booking_details){
        tripBookkingDetailsRepository.delete(id_trip_booking_details);
    }

    public List<TripBokkingDetails>findAllDetails(){
        return tripBookkingDetailsRepository.findAll();
    }

    //METODOS PARA EXTRAER LOS OTRAS TABLAS
    //TRIPBOOKING
    public List<Tripbooking>findAllBooking(){
        return tripbookingRepository.findAll();
    }

    public Optional<Tripbooking>findBooking(int id_trip_booking){
        return tripbookingRepository.findById(id_trip_booking);
    }

    //COSTUMER
    public List<Customer>findAllCustomers(){
        return customerRepository.findAll();
    }

    public Optional<Customer>findCustomer(String id_cliente){
        return customerRepository.findById(id_cliente);
    }
    //FLIGTHFARE
    public List<Flightfare>findAllFares(){
        return flightfareRepository.findAll();
    }

    public Optional<Flightfare>findFareById(int id_tarifa){
        return flightfareRepository.findById(id_tarifa);
    }
}
