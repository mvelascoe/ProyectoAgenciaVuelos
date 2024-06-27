package com.proyectojava;

import java.text.ParseException;
import java.util.Scanner;

import com.proyectojava.generalConsole.in.GeneralConsoleAdapter;

/*import com.proyectojava.airline.adapters.in.AirlineConsoleAdapter;
import com.proyectojava.airline.adapters.out.AirlineMySQLRepository;
import com.proyectojava.airline.application.AirlineService;
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
import com.proyectojava.plane.adapters.out.PlaneMySQLRepository;
import com.proyectojava.trip.adapters.in.TripConsoleAdapter;
import com.proyectojava.trip.adapters.out.TripMySQLRepository;
import com.proyectojava.trip.application.TripService;
import com.proyectojava.tripbooking.adapters.in.TripbookingConsoleAdapter;
import com.proyectojava.tripbooking.adapters.out.TripbookingMySQLRepository;
import com.proyectojava.tripbooking.application.TripbookingService;
import com.proyectojava.tripbookingdetails.adapters.in.TripBookingDetailsConsoleAdapter;
import com.proyectojava.tripbookingdetails.adapters.out.TripBookingDetailsMySQLRepository;
import com.proyectojava.tripbookingdetails.aplication.TripBookingDetailsService;*/

public class Main {
    public static void main(String[] args) throws ParseException {

         GeneralConsoleAdapter adapter = new GeneralConsoleAdapter();
         adapter.showMainMenu();

        /*    String url = "jdbc:mysql://localhost:3306/Vuelos_globales";
            String user = "campus2023";
            String password = "campus2023";

        CountryMySQLRepository countryRepository = new CountryMySQLRepository(url,user,password);
        CitiesMySQLRepository citiesRepository = new CitiesMySQLRepository(url,user,password);
        AirportMySQLRepository airportMySQLRepository = new AirportMySQLRepository(url,user,password);
        ModelMySQLRepository modelMySQLRepository = new ModelMySQLRepository(url,user,password);
        ManufacturerMySQLRepository manufacturerMySQLRepository = new ManufacturerMySQLRepository(url,user,password);
        GateMySQLRepository gateMySQLRepository = new GateMySQLRepository(url, user,password);
        
        DocumenttypeMySQLRepository documenttypeMySQLRepository = new DocumenttypeMySQLRepository(url,user,password);
        TripbookingMySQLRepository tripbookingMySQLRepository = new TripbookingMySQLRepository(url,user,password);
        FlightfareMySQLRepository flightfareMySQLRepository = new FlightfareMySQLRepository(url,user,password);
        TripBookingDetailsMySQLRepository tripBookingDetailsMySQLRepository = new TripBookingDetailsMySQLRepository(url,user,password);
        TripMySQLRepository tripbookingMySQLrepository = new TripMySQLRepository(url,user,password);
        AirlineMySQLRepository airlineMySQLRepository = new AirlineMySQLRepository(url, user, password);
        PlaneMySQLRepository planeMySQLRepository = new PlaneMySQLRepository(url, user, password);


        CountryService countryService = new CountryService(countryRepository);
        CitiesService citiesService = new CitiesService(citiesRepository, countryRepository);
        AirportService airportService = new AirportService(airportMySQLRepository, citiesRepository);
        ModelService modelService = new ModelService(modelMySQLRepository, manufacturerMySQLRepository);
        ManufacturerService manufacturerService = new ManufacturerService(manufacturerMySQLRepository);
        GateService gateService = new GateService(gateMySQLRepository, airportMySQLRepository);
        
        DocumenttypeService documenttypeService = new DocumenttypeService(documenttypeMySQLRepository);
        TripbookingService tripbookingService2 = new TripbookingService(tripbookingMySQLRepository,tripbookingMySQLrepository);
        FlightfareService flightfareService = new FlightfareService(flightfareMySQLRepository);
        TripBookingDetailsService tripBookingDetailsService = new TripBookingDetailsService(tripBookingDetailsMySQLRepository, tripbookingMySQLRepository, customerMySQLRepository,flightfareMySQLRepository);
        TripService tripService = new TripService(tripbookingMySQLrepository);
        AirlineService airlineService = new AirlineService(airlineMySQLRepository);
  //    PlaneService planeService = new PlaneService(planeMySQLRepository, null, modelMySQLRepository);

        

        // Inicialización de los adaptadores de consola
        CitiesConsoleAdapter citiesConsoleAdapter = new CitiesConsoleAdapter(citiesService);
        CountryConsoleAdapter countryConsoleAdapter = new CountryConsoleAdapter(countryService);
        AirportConsoleAdapter airportConsoleAdapter = new AirportConsoleAdapter(airportService);
        ModelConsoleAdapter modelConsoleAdapter = new ModelConsoleAdapter(modelService);
        ManufacturerConsoleAdapter manufacturerConsoleAdapter = new ManufacturerConsoleAdapter(manufacturerService);
        GateConsoleAdapter gateConsoleAdapter = new GateConsoleAdapter(gateService);
        CustomerConsoleAdapter customerConsoleAdapter = new CustomerConsoleAdapter(customerService);
        DocumenttypeConsoleAdapter documenttypeConsoleAdapter = new DocumenttypeConsoleAdapter(documenttypeService);
        TripbookingConsoleAdapter tripbookingConsoleAdapter = new TripbookingConsoleAdapter(tripbookingService2);
        FlightfareConsoleAdapter flightfareConsoleAdapter = new FlightfareConsoleAdapter(flightfareService);
        TripBookingDetailsConsoleAdapter tripBookingDetailsConsoleAdapter = new TripBookingDetailsConsoleAdapter(tripBookingDetailsService);
        TripConsoleAdapter tripConsoleAdapter = new TripConsoleAdapter(tripService);
        AirlineConsoleAdapter airlineConsoleAdapter = new AirlineConsoleAdapter(airlineService);
        //   PlaneConsoleAdapter planeConsoleAdapter = new PlaneConsoleAdapter(planeService);

        // Iniciar la aplicación desde el adaptador de consola de ciudades
        System.out.println("------------- Bienvenido ------------------");
        System.out.println("           VUELOS GLOBALES                 ");
        int choice;
        do {
            System.out.println(
                    "\n\n1. Ciudades\n2. Paises\n3. Aeropuertos\n4. Modelos avion\n5. manufacturer\n6. Puertas\n7. Clientes\n8. Tipo de documento\n9. Booking\n10 .Tarifa\n11. Detalle\n12. Viaje\n13. Reserva de vuelos\nSelecciona la opcion que deseas usar");
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
                case 12:
                    tripConsoleAdapter.start();
                    break;
                case 13:
                    tripbookingConsoleAdapter.start();
                    break;
                case 14:
                    airlineConsoleAdapter.startAirline();
                    break;
                case 15:
                 //   planeConsoleAdapter.start(); pendiente arreglar


                default:
                    System.out.println("Opción no válida. Saliendo del programa.");
                    break;
            }

        } while (choice != 16);*/

    }

}