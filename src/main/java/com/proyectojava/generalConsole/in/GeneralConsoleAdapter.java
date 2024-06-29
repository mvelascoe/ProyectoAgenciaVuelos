package com.proyectojava.generalConsole.in;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.proyectojava.airline.adapters.in.AirlineConsoleAdapter;
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
import com.proyectojava.employee.adapters.in.EmployeeConsoleAdapter;
import com.proyectojava.employee.adapters.out.EmployeeMySQLRepository;
import com.proyectojava.employee.application.EmployeeService;
import com.proyectojava.flightconnection.adapters.in.FlightConnectionConsoleAdapter;
import com.proyectojava.flightconnection.adapters.out.FlightConnectionMySQLRepository;
import com.proyectojava.flightconnection.application.FlightConnectionService;
import com.proyectojava.flightconnection.domain.models.FlightConnection;
import com.proyectojava.flightfare.adapters.in.FlightfareConsoleAdapter;
import com.proyectojava.flightfare.adapters.out.FlightfareMySQLRepository;
import com.proyectojava.flightfare.application.FlightfareService;
import com.proyectojava.manufacturer.adapters.in.ManufacturerConsoleAdapter;
import com.proyectojava.manufacturer.adapters.out.ManufacturerMySQLRepository;
import com.proyectojava.manufacturer.application.ManufacturerService;
import com.proyectojava.models.adapters.in.ModelConsoleAdapter;
import com.proyectojava.models.adapters.out.ModelMySQLRepository;
import com.proyectojava.models.application.ModelService;
import com.proyectojava.plane.adapters.in.PlaneConsoleAdapter;
import com.proyectojava.plane.adapters.out.PlaneMySQLRepository;
import com.proyectojava.plane.application.PlaneService;
import com.proyectojava.revisions.adapters.in.RevisionsConsoleAdapter;
import com.proyectojava.revisions.adapters.out.RevisionsMySQLRepository;
import com.proyectojava.revisions.application.RevisionsService;
import com.proyectojava.rols.adapters.in.RolsConsoleAdapter;
import com.proyectojava.rols.adapters.out.RolsMySQLRepository;
import com.proyectojava.rols.application.RolsService;
import com.proyectojava.statusA.adapters.in.StatusConsoleAdapter;
import com.proyectojava.statusA.adapters.out.StatusMySQLRepository;
import com.proyectojava.statusA.application.StatusService;
import com.proyectojava.trip.adapters.in.TripConsoleAdapter;
import com.proyectojava.trip.adapters.out.TripMySQLRepository;
import com.proyectojava.trip.application.TripService;
import com.proyectojava.tripbooking.adapters.in.TripbookingConsoleAdapter;
import com.proyectojava.tripbooking.adapters.out.TripbookingMySQLRepository;
import com.proyectojava.tripbooking.application.TripbookingService;

public class GeneralConsoleAdapter {

    // Conexion con la base de datos
    String url = "jdbc:mysql://localhost:3306/Vuelos_globales";
    String user = "campus2023";
    String password = "Campus2023*";

    CountryMySQLRepository countryRepository = new CountryMySQLRepository(url, user, password);
    CitiesMySQLRepository citiesRepository = new CitiesMySQLRepository(url, user, password);
    PlaneMySQLRepository planeMySQLRepository = new PlaneMySQLRepository(url, user, password);
    AirportMySQLRepository airportMySQLRepository = new AirportMySQLRepository(url, user, password);
    DocumenttypeMySQLRepository documenttypeMySQLRepository = new DocumenttypeMySQLRepository(url, user, password);
    ModelMySQLRepository modelMySQLRepository = new ModelMySQLRepository(url, user, password);
    AirlineMySQLRepository airlineMySQLRepository = new AirlineMySQLRepository(url, user, password);
    ManufacturerMySQLRepository manufacturerMySQLRepository = new ManufacturerMySQLRepository(url, user, password);
    StatusMySQLRepository statusMySQLRepository = new StatusMySQLRepository(url, user, password);
    CustomerMySQLRepository customerMySQLRepository = new CustomerMySQLRepository(url, user, password);
    RolsMySQLRepository rolsMySQLRepository = new RolsMySQLRepository(url, user, password);
    EmployeeMySQLRepository employeeMySQLRepository = new EmployeeMySQLRepository(url, user, password);
    TripMySQLRepository tripMySQLRepository = new TripMySQLRepository(url, user, password);
    TripbookingMySQLRepository tripbookingMySQLRepository = new TripbookingMySQLRepository(url, user, password);
    FlightfareMySQLRepository flightfareMySQLRepository = new FlightfareMySQLRepository(url, user, password);
    RevisionsMySQLRepository revisionsMySQLRepository = new RevisionsMySQLRepository(url, user, password);
    FlightConnectionMySQLRepository flightConnectionMySQLRepository = new FlightConnectionMySQLRepository(url, user, password);

    CountryService countryService = new CountryService(countryRepository);
    CitiesService citiesService = new CitiesService(citiesRepository, countryRepository);
    PlaneService planeService = new PlaneService(planeMySQLRepository, statusMySQLRepository, modelMySQLRepository,
                airlineMySQLRepository);
    AirportService airportService = new AirportService(airportMySQLRepository, citiesRepository);
    DocumenttypeService documenttypeService = new DocumenttypeService(documenttypeMySQLRepository);
    ModelService modelService = new ModelService(modelMySQLRepository, manufacturerMySQLRepository);
    AirlineService airlineService = new AirlineService(airlineMySQLRepository);
    ManufacturerService manufacturerService = new ManufacturerService(manufacturerMySQLRepository);
    StatusService statusService = new StatusService(statusMySQLRepository);
    CustomerService customerService = new CustomerService(customerMySQLRepository, documenttypeMySQLRepository);
    RolsService rolsService = new RolsService(rolsMySQLRepository);
    EmployeeService employeeService = new EmployeeService(employeeMySQLRepository, rolsMySQLRepository, 
                    airlineMySQLRepository, airportMySQLRepository);
    TripService tripService = new TripService(tripMySQLRepository, flightConnectionMySQLRepository);
    TripbookingService tripbookingService = new TripbookingService(tripbookingMySQLRepository, tripMySQLRepository);
    FlightfareService flightfareService = new FlightfareService(flightfareMySQLRepository);
    RevisionsService revisionsService = new RevisionsService(revisionsMySQLRepository, planeMySQLRepository);
    FlightConnectionService flightConnectionService = new FlightConnectionService(flightConnectionMySQLRepository, tripMySQLRepository, planeMySQLRepository, airportMySQLRepository, employeeMySQLRepository);

    // Inicialización de los adaptadores de consola

    CitiesConsoleAdapter citiesConsoleAdapter = new CitiesConsoleAdapter(citiesService);
    CountryConsoleAdapter countryConsoleAdapter = new CountryConsoleAdapter(countryService);
    PlaneConsoleAdapter planeConsoleAdapter = new PlaneConsoleAdapter(planeService);
    AirportConsoleAdapter airportConsoleAdapter = new AirportConsoleAdapter(airportService);
    DocumenttypeConsoleAdapter documenttypeConsoleAdapter = new DocumenttypeConsoleAdapter(documenttypeService);
    ModelConsoleAdapter modelConsoleAdapter = new ModelConsoleAdapter(modelService);
    AirlineConsoleAdapter airlineConsoleAdapter = new AirlineConsoleAdapter(airlineService);
    ManufacturerConsoleAdapter manufacturerConsoleAdapter = new ManufacturerConsoleAdapter(manufacturerService);
    StatusConsoleAdapter statusConsoleAdapter = new StatusConsoleAdapter(statusService);
    CustomerConsoleAdapter customerConsoleAdapter = new CustomerConsoleAdapter(customerService);
    RolsConsoleAdapter rolsConsoleAdapter = new RolsConsoleAdapter(rolsService);
    EmployeeConsoleAdapter employeeConsoleAdapter = new EmployeeConsoleAdapter(employeeService);
    TripConsoleAdapter tripConsoleAdapter = new TripConsoleAdapter(tripService);
    TripbookingConsoleAdapter tripbookingConsoleAdapter = new TripbookingConsoleAdapter(tripbookingService);
    FlightfareConsoleAdapter flightfareConsoleAdapter = new FlightfareConsoleAdapter(flightfareService);
    RevisionsConsoleAdapter revisionsConsoleAdapter = new RevisionsConsoleAdapter(revisionsService);
    FlightConnectionConsoleAdapter flightConnectionConsoleAdapter = new FlightConnectionConsoleAdapter(flightConnectionService, employeeService);

    // Menu Principal, Seleccion de usuario
    private Map<Integer, String> rolePasswords;

    public GeneralConsoleAdapter() {

        // Definimos la contraseña para cada rol

        rolePasswords = new HashMap<>();
        rolePasswords.put(1, "admin123"); // Contraseña para Administrador del sistema
        rolePasswords.put(2, "ventas123"); // Contraseña paras el de ventas
        rolePasswords.put(3, "cliente123"); // contraseña para cliente
        rolePasswords.put(4, "tech123"); // contraseña para el de mantenimiento
    }

    public void showMainMenu() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int mainChoice;

        do {
            System.out.println("\n\n\nSeleccione su rol:");
            System.out.println("1. Administrador del sistema");
            System.out.println("2. Agente de ventas");
            System.out.println("3. Cliente");
            System.out.println("4. Técnico de mantenimiento");
            System.out.println("5. Salir del programa");

            mainChoice = scanner.nextInt();
            scanner.nextLine();

            if (mainChoice >= 1 && mainChoice <= 4) {
                System.out.println("Ingrese la clave para el rol seleccionado:");
                String password = scanner.nextLine();

                if (validatePassword(mainChoice, password)) {
                    switch (mainChoice) {
                        case 1:
                            showAdminMenu(scanner);
                            break;
                        case 2:
                            showSalesAgentMenu(scanner);
                            break;
                        case 3:
                            showClientMenu(scanner);
                            break;
                        case 4:
                            showMaintenanceTechMenu(scanner);
                            break;
                    }
                } else {
                    System.out.println("Clave incorrecta. Verifiquela de nuevo.");
                }
            } else if (mainChoice == 5) {
                System.out.println("Finalizando el Sistema");
            } else {
                System.out.println("Opción no válida. Por favor, inténtelo de nuevo.");
            }
        } while (mainChoice != 5);

        scanner.close();
    }

    // validacion de la contraseña
    private boolean validatePassword(int role, String password) {
        return rolePasswords.get(role).equals(password);
    }

    // Seccion del administrador

    public void showAdminMenu(Scanner scanner) throws ParseException {
        int choice;
        do {
            System.out.println("\n\nADMINISTRADOR DEL SISTEMA\n");
            System.out.println("1. Gestionar Paises y Ciudades");// INSERTARE PAISES Y CIUDADES
            System.out.println("2. Gestionar Aerolineas");
            System.out.println("3. Gestionar Aviones");// HECHOS
            System.out.println("4. Gestionar Aeropuertos");// HECHOS
            System.out.println("5. Gestionar Tripulación");
            System.out.println("6. Gestionar Tipo de documento");// HECHOS
            System.out.println("7. Asignar Aeronave al trayecto"); 
            System.out.println("8. Consultar informacion de vuelo");// INSERTARE VUELOS
            System.out.println("9. Gestionar tarifas de vuelo");// HECHOS
            System.out.println("10. Volver al menú principal");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("GESTIONAR PAISES Y CIUDADES");// Voy a insertar datos para paises y ciudades
                    cityAndCountrys(scanner);
                    break;
                
                case 2:
                    System.out.println("REGISTRO DE AEROLINEAS");
                    airlineConsoleAdapter.startAirline();

                case 3:
                    System.out.println("GESTIONAR AVIONES"); //Revisar tablas - pendiente arreglar menus se devuelven al primero
                    gestionAviones(scanner);

                    break;
                case 4:
                    System.out.println("GESTIONAR AEROPUERTOS"); 
                    airportConsoleAdapter.startAirports();

                    break;
                case 5:
                    System.out.println("GESTIONAR TRIPULACION");
                    tripulations(scanner);
                    break;
                case 6:
                    System.out.println("GESTIONAR TIPO DE DOCUMENTO");
                    documenttypeConsoleAdapter.start();

                case 7:
                    System.out.println("GESTIONAR TRAYECTOS Y ESCALAS");
                    trayectoEscala(scanner);
                    
                case 8:
                    System.out.println("INFO DE VUELOS");
                    tripConsoleAdapter.listIdTrip();
                    tripConsoleAdapter.findTripById();
                    break;
                case 9:
                    System.out.println("GESTIONA TARIFAS DE VUELO");
                    flightfareConsoleAdapter.startFlightFare();
                    break;
                case 10:
                    System.out.println("Volviendo al menu principal...");
                    showMainMenu();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, inténtelo de nuevo.");
            }
        } while (choice != 7);
    }

    // Registro de Paises y ciudades
    public void cityAndCountrys(Scanner scanner) throws ParseException {
        int choice;
        do {
            System.out.println("REGISTRO DE PAISES Y CIUDADES");
            System.out.println("1. Gestionar Paises");
            System.out.println("2. Gestionar Ciudades");
            System.out.println("3. Volver al menu anterior");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    countryConsoleAdapter.start();
                    break;
                case 2:
                    citiesConsoleAdapter.start();
                case 3:
                    showAdminMenu(scanner);
                    break;
                default:
                    System.out.println("Solo numeros validos...");
                    break;
            }
        } while (choice != 2);
    }

    //Gestionar Aviones
    public void gestionAviones(Scanner scanner) throws ParseException{
        int choice;
        do{
            System.out.println(" Gestion de aviones");
            System.out.println("");
            System.out.println("1. Gestioner los fabricantes de aviones");
            System.out.println("2. Gestionar los modelos");
            System.out.println("3. Gestionar los estados");
            System.out.println("4. Registrar Avion");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manufacturerConsoleAdapter.start();
                case 2:
                    modelConsoleAdapter.start();
                    break;
                case 3: 
                    statusConsoleAdapter.startStatus();
                    break;
                case 4:
                    planeConsoleAdapter.start();
                    break;
            }
        }while(choice != 4);
    }

    // gestion de tripulacion
    public void tripulations(Scanner scanner) throws ParseException {
        int choice;
        do {
            System.out.println("1. Gestion de roles");
            System.out.println("2. Gestion de Empleado");
            System.out.println("3. Asignar tripulacion a trayecto");
            System.out.println("4. Volver el menu principal");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    rolsConsoleAdapter.startRols();
                    break;
                case 2:
                    employeeConsoleAdapter.startEmployee();
                    break;
                case 3:
                    flightConnectionConsoleAdapter.asignacionTrayecto();
                    break;
                case 4:
                    showAdminMenu(scanner);
                    break;
                default:
                    System.out.println("Solo numeros validos...");
                    break;
            }
        } while (choice != 2);

    }

    //gestion de trayectos y escalas

    public void trayectoEscala(Scanner scanner) throws ParseException{
        int choice;
        do{
            System.out.println("1. Ingresar un Vuelo");
            System.out.println("2. Asignacion de Escalas, Avion, y Aeropuerto");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    tripConsoleAdapter.start();                    
                    break;
                case 2:
                    flightConnectionConsoleAdapter.startFlightConnection();
                    break;
            }
        }while(choice != 2);    
    }

    // Seccion del Agente de Ventas

    public void showSalesAgentMenu(Scanner scanner) throws ParseException {
        int choice;
        do {
            System.out.println("Agente de ventas:");
            System.out.println("1. Gestionar clientes");/// HECHOS
            System.out.println("2. Gestionar reservas de vuelo");/// HECHOS
            System.out.println("3. Consulta tarifa de vuelo");/// HECHOS
            System.out.println("4. Consulta informacion de vuelo");/// HECHOS
            System.out.println("5. Consulta tipo de documento");/// HECHOS
            System.out.println("6. Volver al menú principal");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Agente de ventas - Registrar cliente seleccionada.");
                    customerConsoleAdapter.startCustomer();
                    break;
                case 2:
                    System.out.println("Agente de ventas - Reservas de vuelo seleccionada.");
                    tripbookingConsoleAdapter.start();
                    break;
                case 3:
                    System.out.println("Agente de ventas - Consulta tarifa de vuelo seleccionada.");
                    flightfareConsoleAdapter.listIDFare();
                    flightfareConsoleAdapter.consultaTarifa();
                    break;
                case 4:
                    System.out.println("Agente de ventas - Consulta informacion de vuelo seleccionada.");
                    tripConsoleAdapter.listIdTrip();
                    tripConsoleAdapter.findTripById();
                    break;
                case 5:
                    System.out.println("Consulta tipo de documento");
                    documenttypeConsoleAdapter.idDocuments();
                    documenttypeConsoleAdapter.findDocumentById();
                case 6:
                    System.out.println("Volviendo al menú principal.");
                    showMainMenu();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, inténtelo de nuevo.");
            }
        } while (choice != 5);
    }

    // Seccion del cliente

    public void showClientMenu(Scanner scanner) throws ParseException {
        int choice;
        do {
            System.out.println("Cliente:");
            System.out.println("1.  Gestion de reserva de vuelo");
            System.out.println("2. Opción 2");
            System.out.println("3. Consulta tarifa de vuelo");
            System.out.println("4. Opción 4");
            System.out.println("5. Volver al menú principal");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Cliente - reserva de vuelo");
                    tripbookingConsoleAdapter.start();
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Cliente -.");
                    break;
                case 4:
                    System.out.println("Cliente - Opción 4 seleccionada.");
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal.");
                    showMainMenu();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, inténtelo de nuevo.");
            }
        } while (choice != 5);
    }

    // Seccion del servicio de Mantenimiento

    public void showMaintenanceTechMenu(Scanner scanner) throws ParseException {
        int choice;
        do {
            System.out.println("Técnico de mantenimiento:");
            System.out.println("1. Gestion revisiones");
            System.out.println("2. Consulta revision por matricula");
            System.out.println("3. Volver al menú principal");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    revisionsConsoleAdapter.start();
                    break;
                case 2:
                    revisionsConsoleAdapter.reviMatricula();
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal.");
                    showMainMenu();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, inténtelo de nuevo.");
            }
        } while (choice != 3);
    }
}
