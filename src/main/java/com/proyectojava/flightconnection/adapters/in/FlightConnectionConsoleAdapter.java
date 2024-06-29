package com.proyectojava.flightconnection.adapters.in;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import com.proyectojava.generalConsole.in.GeneralConsoleAdapter;
import com.proyectojava.airport.domain.models.Airport;
import com.proyectojava.country.domain.models.Country;
import com.proyectojava.employee.application.EmployeeService;
import com.proyectojava.employee.domain.models.Employee;
import com.proyectojava.flightconnection.application.FlightConnectionService;
import com.proyectojava.flightconnection.domain.models.FlightConnection;
import com.proyectojava.flightconnection.domain.models.FlightConnectionInfo;
import com.proyectojava.plane.domain.models.Plane;
import com.proyectojava.trip.domain.models.Trip;

public class FlightConnectionConsoleAdapter {
    private final FlightConnectionService flightConnectionService;
    private final EmployeeService employeeService;

    public FlightConnectionConsoleAdapter(FlightConnectionService flightConnectionService, EmployeeService employeeService) {
        this.flightConnectionService = flightConnectionService;
        this.employeeService = employeeService;
    }

    public void startFlightConnection() throws ParseException {
        Scanner sc = new Scanner(System.in);
        GeneralConsoleAdapter MP = new GeneralConsoleAdapter();
        while (true) {
            System.out.println(
                    "1. Crear conexion\n2. Actualizar informacion de conexion\n3. Buscar conexion\n4. Eliminar conexion\n5. Listar todas las conexions\n6. Volver\n\n");
            System.out.println("Ingresa una opcion");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa numero de la conexion: ");
                    String num_trayectoria = sc.next();

                    List<Trip> trips = flightConnectionService.getAllTripes();
                    System.out.println("-------------------------------");
                    System.out.printf("%-15s ", "ID_Vuelo");
                    System.out.println("-------------------------------");
                    for (Trip trip : trips) {
                        System.out.printf("%-15s", trip.getId_trip());
                    }

                    System.out.println("Ingresa el id del vuelo: ");
                    int id_trip = sc.nextInt();

                    Optional<Trip> optionalTrip = flightConnectionService.getTripById(id_trip);
                    System.out.println("-------------------------------");
                    System.out.printf("%-15s ", "ID_Avion");
                    System.out.println("-------------------------------");

                    if (optionalTrip.isPresent()) {

                        List<Plane> planes = flightConnectionService.getAllPlanes();
                        for (Plane plane : planes) {
                            System.out.printf("%-15s", plane.getId_avion());
                        }

                        System.out.println("Ingresa el id del avion: ");
                        int id_plane = sc.nextInt();

                        Optional<Plane> optionalPlane = flightConnectionService.getPlaneById(id_plane);
                        if (optionalPlane.isPresent()) {

                            List<Airport> airports = flightConnectionService.findAllAirports();
                            System.out.println("-------------------------------");
                            System.out.printf("%-15s ", "ID_Aeropuerto");
                            System.out.println("-------------------------------");

                            for (Airport air : airports) {
                                System.out.printf("%-15s", air.getId_aeropuerto());
                            }

                            System.out.println("Ingresa el id de aeropuerto: ");
                            String id_airport = sc.next();

                            Optional<Airport> optionalAeropuerto = flightConnectionService.findAirportById(id_airport);
                            if (optionalAeropuerto.isPresent()) {
                                FlightConnection connection = new FlightConnection(num_trayectoria, id_trip, id_plane,
                                        id_airport);
                                flightConnectionService.createConnection(connection);
                                System.out.println("\n**************************************");
                                System.out.println("*    Conexion creada exitosamente     *");
                                System.out.println("**************************************\n");
                            }
                        }
                    } else {
                        System.out.println("Error: Datos inexsistentes...");
                    }
                    break;

                case 2:
                    System.out.println("Ingresa el id de la conexion a actualizar: ");
                    int up_id = sc.nextInt();

                    System.out.println("Ingresa el nuevo numero de conexion: ");
                    String up_num_trayectoria = sc.next();

                    System.out.println("Ingresa el nuevo id del vuelo: ");
                    int up_id_trip = sc.nextInt();

                    System.out.println("Ingresa el nuevo id del avion: ");
                    int up_id_plane = sc.nextInt();

                    System.out.println("Ingresa el nuevo id del aeropuerto: ");
                    String up_id_airport = sc.next();

                    FlightConnection connection2 = new FlightConnection(up_id, up_num_trayectoria, up_id_trip,
                            up_id_plane, up_id_airport);
                    flightConnectionService.updateConnecttion(connection2);

                    System.out.println("\n*************************************");
                    System.out.println("* Conexion actualizada correctamente *");
                    System.out.println("*************************************\n");
                    break;
                case 3:
                    System.out.println("Ingresa el id de la conexion a buscar: ");
                    int findID = sc.nextInt();

                    Optional<FlightConnection> connection3 = flightConnectionService.findConnecttionById(findID);
                    connection3.ifPresentOrElse(
                            c -> System.out.println("Id: " + c.getId_trayectoria() + ", Numero de trayectoria: "
                                    + c.getTrayectoria_numero() + ", Id del vuelo: " + c.getId_trip()
                                    + ", Id del avion: " + c.getId_avion() + ", Id del aeropuerto: "
                                    + c.getId_aeropuerto()),
                            () -> System.out.println("No se encontro una trayectoria con el id " + findID));
                    break;
                case 4:
                    System.out.println("Ingresa el id de la conexion a eliminar: ");
                    int deleteId = sc.nextInt();

                    flightConnectionService.deleteConnecttion(deleteId);
                    System.out.println("\n*************************************");
                    System.out.println("* Conexion eliminada correctamente *");
                    System.out.println("*************************************\n");
                    break;
                case 5:
                    System.out.println(
                            "  ####    #####   ##   ##  #######  ###  ##   ######   #####   ##   ##  #######   #####   ");
                    System.out.println(
                            " ##  ##  ### ###  ###  ##   ##   #  ###  ##     ##    ### ###  ###  ##   ##   #  ##   ##  ");
                    System.out.println(
                            "##       ##   ##  #### ##   ##       #####      ##    ##   ##  #### ##   ##      ##       ");
                    System.out.println(
                            "##       ##   ##  #######   ####      ###       ##    ##   ##  #######   ####     #####   ");
                    System.out.println(
                            "##       ##   ##  ## ####   ##       #####      ##    ##   ##  ## ####   ##           ##  ");
                    System.out.println(
                            " ##  ##  ### ###  ##  ###   ##   #  ##  ###     ##    ### ###  ##  ###   ##   #  ##   ##  ");
                    System.out.println(
                            "  ####    #####   ##   ##  #######  ##  ###   ######   #####   ##   ##  #######   #####   ");

                    flightConnectionService.findAllConnecttions().forEach(cl -> {
                        System.out.println("Id: " + cl.getId_trayectoria() + ", Numero de trayectoria: "
                                + cl.getTrayectoria_numero() + ", Id del vuelo: " + cl.getId_trip() + ", Id del avion: "
                                + cl.getId_avion() + ", Id del aeropuerto: " + cl.getId_aeropuerto());
                    });
                    break;
                case 6:
                    System.out.println("Volviendo al menu principal... Adios");
                    MP.showMainMenu();
                    break;
                default:
                    System.out.println("Opcion invalida. Intentalo de nuevo");
                    break;
            }
        }

    }

    public void asignacionTrayecto() {
        Scanner sc = new Scanner(System.in);
    
        // Mostrar trayectos disponibles
        List<FlightConnectionInfo> flightConnections = flightConnectionService.findAllFlightConnections();
        System.out.println("---------------------------------------------");
        System.out.printf("%-15s %-20s %-20s %-20s\n", "ID Trayectoria", "Trayectoria Numero", "Lugar Ida", "Lugar Llegada");
        System.out.println("---------------------------------------------");
        for (FlightConnectionInfo connection : flightConnections) {
            System.out.printf("%-15d %-20s %-20s %-20s\n", connection.getId_trayectoria(), connection.getTrayectoria_numero(), connection.getLugar_ida(), connection.getLugar_llegada());
        }
        System.out.println("---------------------------------------------");
    
        System.out.println("Seleccione el trayecto al que desea asignar un empleado (ingrese ID):");
        int selectedTrayectoId = sc.nextInt();
    
        // Mostrar empleados disponibles
        List<Employee> employees = flightConnectionService.findAllEmployees();
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-10s %-15s %-10s %-10s%n", "ID Empleado", "Nombre Empleado", "ID Rol", "Fecha Ingreso", "ID Aerolínea", "ID Aeropuerto");
        System.out.println("-----------------------------------------------------------------");
        for (Employee employee : employees) {
            System.out.printf("%-15s %-20s %-10d %-15s %-10d %-10s%n", employee.getId_empleado(), employee.getNombre_empleado(), employee.getId_rol(), employee.getFecha_ingreso(), employee.getId_aerolinea(), employee.getId_aeropuerto());
        }
        System.out.println("-----------------------------------------------------------------");
    
        // Permitir la selección de empleados
        System.out.println("Seleccione los empleados que desea asignar (ingrese IDs separados por comas):");
        sc.nextLine(); // Limpiar el buffer del scanner
        String selectedEmployeeIds = sc.nextLine();
        String[] employeeIdArray = selectedEmployeeIds.split(",");
    
        // Realizar la asignación de empleados al trayecto seleccionado
        for (String employeeId : employeeIdArray) {
            employeeId = employeeId.trim();
            Optional<Employee> optionalEmployee = flightConnectionService.findEmployeeById(employeeId);
            if (optionalEmployee.isPresent()) {
                // Aquí deberías llamar a un método de servicio para asignar el empleado al trayecto
                flightConnectionService.assignEmployeeToTrayecto(employeeId, selectedTrayectoId);
                System.out.println("Empleado " + employeeId + " asignado correctamente al trayecto " + selectedTrayectoId);
            } else {
                System.out.println("Empleado con ID " + employeeId + " no encontrado.");
            }
        }
    
        System.out.println("\n************************************");
        System.out.println("*       Trayectoria Asignada       *");
        System.out.println("*************************************\n");
    }
}


