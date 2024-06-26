package com.proyectojava;

import java.util.Scanner;

import com.proyectojava.airport.adapters.in.AirportConsoleAdapter;
import com.proyectojava.airport.adapters.out.AirportMySQLRepository;
import com.proyectojava.airport.application.AirportService;
import com.proyectojava.cities.adapters.in.CitiesConsoleAdapter;
import com.proyectojava.cities.adapters.out.CitiesMySQLRepository;
import com.proyectojava.cities.application.CitiesService;
import com.proyectojava.country.adapters.in.CountryConsoleAdapter;
import com.proyectojava.country.adapters.out.CountryMySQLRepository;
import com.proyectojava.country.application.CountryService;
import com.proyectojava.customer.adapters.in.CustomerConsoleAdapter;
import com.proyectojava.customer.adapters.out.CustomerMySQLRepository;
import com.proyectojava.customer.application.CustomerService;
import com.proyectojava.documenttype.adapters.in.DocumenttypeConsoleAdapter;
import com.proyectojava.documenttype.adapters.out.DocumenttypeMySQLRepository;
import com.proyectojava.documenttype.application.DocumenttypeService;
import com.proyectojava.flightfare.adapters.in.FlightfareConsoleAdapter;
import com.proyectojava.flightfare.adapters.out.FlightfareMySQLRepository;
import com.proyectojava.flightfare.application.FlightfareService;
import com.proyectojava.gate.adapters.in.GateConsoleAdapter;
import com.proyectojava.gate.adapters.out.GateMySQLRepository;
import com.proyectojava.gate.application.GateService;
import com.proyectojava.manufacturer.adapters.in.ManufacturerConsoleAdapter;
import com.proyectojava.manufacturer.adapters.out.ManufacturerMySQLRepository;
import com.proyectojava.manufacturer.application.ManufacturerService;
import com.proyectojava.models.adapters.in.ModelConsoleAdapter;
import com.proyectojava.models.adapters.out.ModelMySQLRepository;
import com.proyectojava.models.application.ModelService;
import com.proyectojava.tripbooking.adapters.in.TripbookingConsoleAdapter;
import com.proyectojava.tripbooking.adapters.out.TripbookingMySQLRepository;
import com.proyectojava.tripbooking.application.TripbookingService;
import com.proyectojava.tripbookingdetails.adapters.in.TripBookingDetailsConsoleAdapter;
import com.proyectojava.tripbookingdetails.adapters.out.TripBookingDetailsMySQLRepository;
import com.proyectojava.tripbookingdetails.aplication.TripBookingDetailsService;

public class Main {
    public static void main(String[] args) {
        CountryMySQLRepository countryRepository = new CountryMySQLRepository(
                "jdbc:mysql://localhost:3306/Vuelos_globales", "campus2023", "campus2023");
        CitiesMySQLRepository citiesRepository = new CitiesMySQLRepository(
                "jdbc:mysql://localhost:3306/Vuelos_globales", "campus2023", "campus2023");
        AirportMySQLRepository airportMySQLRepository = new AirportMySQLRepository(
                "jdbc:mysql://localhost:3306/Vuelos_globales", "campus2023", "campus2023");
        ModelMySQLRepository modelMySQLRepository = new ModelMySQLRepository(
                "jdbc:mysql://localhost:3306/Vuelos_globales", "campus2023", "campus2023");

        ManufacturerMySQLRepository manufacturerMySQLRepository = new ManufacturerMySQLRepository(
                "jdbc:mysql://localhost:3306/Vuelos_globales", "campus2023", "campus2023");
        GateMySQLRepository gateMySQLRepository = new GateMySQLRepository("jdbc:mysql://localhost:3306/Vuelos_globales",
                "campus2023", "campus2023");
        CustomerMySQLRepository customerMySQLRepository = new CustomerMySQLRepository(
                "jdbc:mysql://localhost:3306/Vuelos_globales", "campus2023", "campus2023");
        DocumenttypeMySQLRepository documenttypeMySQLRepository = new DocumenttypeMySQLRepository(
                "jdbc:mysql://localhost:3306/Vuelos_globales", "campus2023", "campus2023");
        TripbookingMySQLRepository tripbookingMySQLRepository = new TripbookingMySQLRepository(
                "jdbc:mysql://localhost:3306/Vuelos_globales", "campus2023", "campus2023");
        FlightfareMySQLRepository flightfareMySQLRepository = new FlightfareMySQLRepository(
                "jdbc:mysql://localhost:3306/Vuelos_globales", "campus2023", "campus2023");
        TripBookingDetailsMySQLRepository tripBookingDetailsMySQLRepository = new TripBookingDetailsMySQLRepository(
                "jdbc:mysql://localhost:3306/Vuelos_globales", "campus2023", "campus2023");

        CountryService countryService = new CountryService(countryRepository);
        CitiesService citiesService = new CitiesService(citiesRepository, countryRepository);
        AirportService airportService = new AirportService(airportMySQLRepository, citiesRepository);
        ModelService modelService = new ModelService(modelMySQLRepository, manufacturerMySQLRepository);
        ManufacturerService manufacturerService = new ManufacturerService(manufacturerMySQLRepository);
        GateService gateService = new GateService(gateMySQLRepository, airportMySQLRepository);
        CustomerService customerService = new CustomerService(customerMySQLRepository, documenttypeMySQLRepository);
        DocumenttypeService documenttypeService = new DocumenttypeService(documenttypeMySQLRepository);
        TripbookingService tripbookingService = new TripbookingService(tripbookingMySQLRepository);
        FlightfareService flightfareService = new FlightfareService(flightfareMySQLRepository);
        TripBookingDetailsService tripBookingDetailsService = new TripBookingDetailsService(tripBookingDetailsMySQLRepository, tripbookingMySQLRepository, customerMySQLRepository, flightfareMySQLRepository);

        // Inicialización de los adaptadores de consola
        CitiesConsoleAdapter citiesConsoleAdapter = new CitiesConsoleAdapter(citiesService);
        CountryConsoleAdapter countryConsoleAdapter = new CountryConsoleAdapter(countryService);
        AirportConsoleAdapter airportConsoleAdapter = new AirportConsoleAdapter(airportService);
        ModelConsoleAdapter modelConsoleAdapter = new ModelConsoleAdapter(modelService);
        ManufacturerConsoleAdapter manufacturerConsoleAdapter = new ManufacturerConsoleAdapter(manufacturerService);
        GateConsoleAdapter gateConsoleAdapter = new GateConsoleAdapter(gateService);
        CustomerConsoleAdapter customerConsoleAdapter = new CustomerConsoleAdapter(customerService);
        DocumenttypeConsoleAdapter documenttypeConsoleAdapter = new DocumenttypeConsoleAdapter(documenttypeService);
        TripbookingConsoleAdapter tripbookingConsoleAdapter = new TripbookingConsoleAdapter(tripbookingService);
        FlightfareConsoleAdapter flightfareConsoleAdapter = new FlightfareConsoleAdapter(flightfareService);
        TripBookingDetailsConsoleAdapter tripBookingDetailsConsoleAdapter = new TripBookingDetailsConsoleAdapter(tripBookingDetailsService);
        // Iniciar la aplicación desde el adaptador de consola de ciudades
        System.out.println("------------- Bienvenido ------------------");
        System.out.println("           VUELOS GLOBALES                 ");
        int choice;
        do {
            System.out.println(
                    "\n\n1. Ciudades\n2. Paises\n3. Aeropuertos\n4. Modelos avion\n5. manufacturer\n6. Puertas\n7. Clientes\n8. Tipo de documento\n9. Booking\n10 .Tarifa\n11. Detalle\nSelecciona la opcion que deseas usar");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    citiesConsoleAdapter.start();
                    break;
                case 2:
                    countryConsoleAdapter.start();
                    break;
                case 3:
                    airportConsoleAdapter.startAirports();
                    break;
                case 4:
                    modelConsoleAdapter.start();
                    break;
                case 5:
                    manufacturerConsoleAdapter.start();
                    break;
                case 6:
                    gateConsoleAdapter.startGate();
                    break;
                case 7:
                    customerConsoleAdapter.startCustomer();
                    break;
                case 8:
                    documenttypeConsoleAdapter.start();
                    break;
                case 9: 
                    tripbookingConsoleAdapter.start();
                    break;
                case 10:
                    flightfareConsoleAdapter.startFlightFare();
                    break;
                case 11:
                    tripBookingDetailsConsoleAdapter.startDetails();
                    break;
                default:
                    System.out.println("Opción no válida. Saliendo del programa.");
                    break;
            }

        } while (choice != 11);

    }

}