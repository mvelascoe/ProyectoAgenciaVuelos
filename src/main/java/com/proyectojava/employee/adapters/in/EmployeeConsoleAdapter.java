package com.proyectojava.employee.adapters.in;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.proyectojava.airline.domain.models.Airline;
import com.proyectojava.airport.domain.models.Airport;
import com.proyectojava.employee.application.EmployeeService;
import com.proyectojava.employee.domain.models.Employee;
import com.proyectojava.rols.domain.models.Rols;
import com.proyectojava.generalConsole.in.GeneralConsoleAdapter;

public class EmployeeConsoleAdapter {
    private final EmployeeService employeeService;

    public EmployeeConsoleAdapter(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void startEmployee() throws ParseException {
        Scanner sc = new Scanner(System.in);
        GeneralConsoleAdapter MP = new GeneralConsoleAdapter();
        while (true) {
            System.out.println(
                    "1. Crear Empleado\n2. Actualizar informacion de Empleado\n3. Buscar Empleado\n4. Eliminar Empleado\n5. Listar todas las Empleados\n6. Volver\n\n");
            System.out.println("Ingresa una opcion");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el ID del empleado: ");
                    String id_empleado = sc.next();

                    System.out.println("Ingresa el nombre del empleado: ");
                    String nombre = sc.next();

                    List<Rols> roles = employeeService.rolsAll();

                    System.out.println("-------------------------------------------------");
                    System.out.printf("%-15s %-40s%n", "ID_rol", "Nombre ");
                    System.out.println("--------------------------------------------------");

                    for (Rols rol : roles) {
                        System.out.printf("%-10s %30s%n", rol.getId_rol(), rol.getNombre_rol());
                    }

                    System.out.println("Ingresa el id de rol del empleado: ");
                    int rol_empleado = sc.nextInt();

                    Optional<Rols> optionalRols = employeeService.findRol(rol_empleado);
                    if (optionalRols.isPresent()) {
                        Date fecha_ingreso = null;
                        while (fecha_ingreso == null) {
                            System.out.println("Ingresa la fecha de ingreso del empleado (dd/MM/yyyy): ");
                            String fecha = sc.next();
                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                            try {
                                fecha_ingreso = dateFormat.parse(fecha);
                            } catch (ParseException e) {
                                System.out.println("Formato de fecha incorrecto. Debe ser dd/MM/yyyy.");
                            }
                        }

                        List<Airline> aerolineas = employeeService.AllAirlines();
                        System.out.println("-------------------------------------------------");
                        System.out.printf("%-15s %-40s%n", "ID_Aerolinea", "Nombre ");
                        System.out.println("--------------------------------------------------");

                        for (Airline airline : aerolineas) {
                            System.out.printf("%-15s %-40s%n", airline.getId_aerolinea(),
                                    airline.getNombre_aerolinea());
                        }

                        System.out.println("Ingresa el id de la aerolinea en la que trabaja el empleado: ");
                        int id_aerolinea = sc.nextInt();

                        Optional<Airline> optionalAirline = employeeService.findAirline(id_aerolinea);
                        if (optionalAirline.isPresent()) {

                            List<Airport> airports = employeeService.AllAirports();
                            System.out.println("-------------------------------------------------");
                            System.out.printf("%-15s %-40s%n", "ID_Aeropuerto", "Nombre ");
                            System.out.println("--------------------------------------------------");

                            for (Airport air : airports) {
                                System.out.printf("%-15s %-40s%n", air.getId_aeropuerto(), air.getNombre_aeropuerto());
                            }

                            System.out.println("Ingresa el ID del aeropuerto donde trabaja el empleado: ");
                            String id_aeropuerto = sc.next();

                            Optional<Airport> optionalAirport = employeeService.findAirport(id_aeropuerto);
                            if (optionalAirport.isPresent()) {
                                Employee employee = new Employee(id_empleado, nombre, rol_empleado, fecha_ingreso,
                                        id_aerolinea, id_aeropuerto);
                                employeeService.createEmployee(employee);

                                System.out.println("\n**************************************");
                                System.out.println("*    Empleado creado exitosamente     *");
                                System.out.println("**************************************\n");
                            }
                        } else {
                            System.out.println("Error: Hay datos que no coinciden...");
                        }

                    }

                    break;
                case 2:
                    System.out.println("Ingresa el ID del empleado a actualizar: ");
                    String up_id_empleado = sc.next();

                    System.out.println("Ingresa el nuevo nombre del empleado: ");
                    String up_up_nombre = sc.next();

                    System.out.println("Ingresa el nuevo id de rol del empleado: ");
                    int up_rol_empleado = sc.nextInt();

                    Date up_fecha_ingreso = null;
                    while (up_fecha_ingreso == null) {
                        System.out.println("Ingresa la nueva fecha de ingreso del empleado (dd/MM/yyyy): ");
                        String fecha = sc.next();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            up_fecha_ingreso = dateFormat.parse(fecha);
                        } catch (ParseException e) {
                            System.out.println("Formato de fecha incorrecto. Debe ser dd/MM/yyyy.");
                        }
                    }

                    System.out.println("Ingresa la nueva aerolinea en la que trabaja el empleado: ");
                    int up_id_aerolinea = sc.nextInt();

                    System.out.println("Ingresa el nuevo ID del aeropuerto donde trabaja el empleado: ");
                    String up_id_aeropuerto = sc.next();

                    Employee employee2 = new Employee(up_id_empleado, up_up_nombre, up_rol_empleado, up_fecha_ingreso,
                            up_id_aerolinea, up_id_aeropuerto);
                    employeeService.updateEmployee(employee2);

                    System.out.println("\n*************************************");
                    System.out.println("* Empleado actualizado correctamente *");
                    System.out.println("*************************************\n");
                    break;
                case 3:
                    System.out.println("Ingrese el id del empleado a buscar: ");
                    String findId = sc.next();

                    Optional<Employee> employee3 = employeeService.findEmployeeById(findId);
                    employee3.ifPresentOrElse(
                            e -> System.out.println("Id: " + e.getId_empleado() + "\nNombre: " + e.getNombre_empleado()
                                    + "\nId rol: " + e.getId_rol() + "\nFecha de ingreso: " + e.getFecha_ingreso()
                                    + "\nAerolinea con la que trabaja: " + e.getId_aerolinea()
                                    + "\nAeropuerto en el que trabaja: " + e.getId_aeropuerto() + "\n\n"),
                            () -> System.out.println("No se encontro un empleado con el id: " + findId));
                    break;
                case 4:
                    System.out.println("Ingresa el id del empleado a eliminar: ");
                    String deleteId = sc.next();
                    employeeService.deleteEmployee(deleteId);

                    System.out.println("\n**********************************");
                    System.out.println("* Empleado eliminado exitosamente *");
                    System.out.println("**********************************\n");
                    break;
                case 5:
                    System.out.println("#######  ##   ##  ######   ####     #######    ###    #####     #####    #####   ");
                    System.out.println(" ##   #  ### ###   ##  ##   ##       ##   #   ## ##    ## ##   ### ###  ##   ##  ");
                    System.out.println(" ##      #######   ##  ##   ##       ##      ##   ##   ##  ##  ##   ##  ##       ");
                    System.out.println(" ####    ## # ##   #####    ##       ####    ##   ##   ##  ##  ##   ##   #####   ");
                    System.out.println(" ##      ##   ##   ##       ##       ##      #######   ##  ##  ##   ##       ##  ");
                    System.out.println(" ##   #  ##   ##   ##       ##  ##   ##   #  ##   ##   ## ##   ### ###  ##   ##  ");
                    System.out.println("#######  ### ###  ####     #######  #######  ##   ##  #####     #####    #####   ");
                    employeeService.findAllEmployees().forEach(el -> {
                        System.out.println("Id: " + el.getId_empleado() + "\nNombre: " + el.getNombre_empleado()
                                + "\nId rol: " + el.getId_rol() + "\nFecha de ingreso: " + el.getFecha_ingreso()
                                + "\nAerolinea con la que trabaja: " + el.getId_aerolinea()
                                + "\nAeropuerto en el que trabaja: " + el.getId_aeropuerto() + "\n\n");
                    });
                    break;
                case 6:
                    System.out.println("Volviendo al menu principal... Adios");
                    MP.tripulations(sc);
                    break;
                default:
                    System.out.println("Opcion invalida. Intentalo de nuevo");
                    break;
            }
        }
    }
}
