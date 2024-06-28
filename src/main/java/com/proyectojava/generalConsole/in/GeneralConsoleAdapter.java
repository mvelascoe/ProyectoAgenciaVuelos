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
import com.proyectojava.manufacturer.adapters.in.ManufacturerConsoleAdapter;
import com.proyectojava.manufacturer.adapters.out.ManufacturerMySQLRepository;
import com.proyectojava.manufacturer.application.ManufacturerService;
import com.proyectojava.models.adapters.in.ModelConsoleAdapter;
import com.proyectojava.models.adapters.out.ModelMySQLRepository;
import com.proyectojava.models.application.ModelService;
import com.proyectojava.plane.adapters.in.PlaneConsoleAdapter;
import com.proyectojava.plane.adapters.out.PlaneMySQLRepository;
import com.proyectojava.plane.application.PlaneService;
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
    String password = "campus2023";

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
    TripService tripService = new TripService(tripMySQLRepository);
    TripbookingService tripbookingService = new TripbookingService(tripbookingMySQLRepository, tripMySQLRepository);

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
            System.out.println("1. Gestionar Paises y Ciudades");
            System.out.println("2. Gestionar Aviones");
            System.out.println("3. Gestionar Aeropuertos");
            System.out.println("4. Gestionar Tripulación");
            System.out.println("5. Gestionar Tipo de documento");
            System.out.println("6.Asignar Aeronave al proyecto");
            System.out.println("7. Consultar informacion de vuelo");
            System.out.println("8. Volver al menú principal");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("GESTIONAR PAISES Y CIUDADES");
                    cityAndCountrys(scanner);
                    break;

                case 2:
                    System.out.println("GESTIONAR AVIONES");
                    planeConsoleAdapter.start();

                    break;
                case 3:
                    System.out.println("GESTIONAR AEROPUERTOS");
                    airportConsoleAdapter.startAirports();

                    break;
                case 4:
                    System.out.println("GESTIONAR TRIPULACION");
                    tripulations(scanner);

                    break;

                case 5:
                    System.out.println("GESTIONAR TIPO DE DOCUMENTO");
                    documenttypeConsoleAdapter.start();

                case 6:

                    break;
                case 7:
                tripbookingConsoleAdapter.listAllTripbookings();
                    break;
                case 8:
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

    // gestion de tripulacion
    public void tripulations(Scanner scanner) throws ParseException {
        int choice;
        do {
            System.out.println("GESTIONAR TRIPULACION");
            System.out.println("1. Gestion de roles");
            System.out.println("2. Gestion de Empleado");
            System.out.println("3. Asignar trayecto");
            System.out.println("3. Volver el menu principal");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    rolsConsoleAdapter.startRols();
                    break;
                case 2:
                    employeeConsoleAdapter.startEmployee();
                    break;
                case 3:
                showAdminMenu(scanner);
                    break;
                default:    
                System.out.println("Solo numeros validos...");
                    break;
            }
        } while (choice != 2);

    }

    // Seccion del Agente de Ventas

    public void showSalesAgentMenu(Scanner scanner) throws ParseException {
        int choice;
        do {
            System.out.println("Agente de ventas:");
            System.out.println("1. Gestionar clientes");
            System.out.println("2. Gestionar reservas de vuelo");
            System.out.println("3. Opción 3");
            System.out.println("4. Opción 4");
            System.out.println("5. Volver al menú principal");

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
                    System.out.println("Agente de ventas - Opción 3 seleccionada.");
                    break;
                case 4:
                    System.out.println("Agente de ventas - Opción 4 seleccionada.");
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

    // Seccion del cliente

    private void showClientMenu(Scanner scanner) throws ParseException {
        int choice;
        do {
            System.out.println("Cliente:");
            System.out.println("1. Opción 1");
            System.out.println("2. Opción 2");
            System.out.println("3. Opción 3");
            System.out.println("4. Opción 4");
            System.out.println("5. Volver al menú principal");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Cliente - Opción 1 seleccionada.");
                    break;
                case 2:
                    System.out.println("Cliente - Opción 2 seleccionada.");
                    break;
                case 3:
                    System.out.println("Cliente - Opción 3 seleccionada.");
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

    private void showMaintenanceTechMenu(Scanner scanner) throws ParseException {
        int choice;
        do {
            System.out.println("Técnico de mantenimiento:");
            System.out.println("1. Opción 1");
            System.out.println("2. Opción 2");
            System.out.println("3. Opción 3");
            System.out.println("4. Opción 4");
            System.out.println("5. Volver al menú principal");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Técnico de mantenimiento - Opción 1 seleccionada.");
                    break;
                case 2:
                    System.out.println("Técnico de mantenimiento - Opción 2 seleccionada.");
                    break;
                case 3:
                    System.out.println("Técnico de mantenimiento - Opción 3 seleccionada.");
                    break;
                case 4:
                    System.out.println("Técnico de mantenimiento - Opción 4 seleccionada.");
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
}
