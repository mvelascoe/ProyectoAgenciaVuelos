package com.proyectojava.employee.adapters.in;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

import com.proyectojava.employee.application.EmployeeService;
import com.proyectojava.employee.domain.models.Employee;

public class EmployeeConsoleAdapter {
    private final EmployeeService employeeService;

    public EmployeeConsoleAdapter(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void startEmployee() throws ParseException {
        Scanner sc = new Scanner(System.in);

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

                    System.out.println("Ingresa el id de rol del empleado: ");
                    int rol_empleado = sc.nextInt();

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

                    System.out.println("Ingresa el id de la aerolinea en la que trabaja el empleado: ");
                    int id_aerolinea = sc.nextInt();

                    System.out.println("Ingresa el ID del aeropuerto donde trabaja el empleado: ");
                    String id_aeropuerto = sc.next();

                    Employee employee = new Employee(id_empleado, nombre, rol_empleado, fecha_ingreso, id_aerolinea,id_aeropuerto);
                    employeeService.createEmployee(employee);

                    System.out.println("\n\nEmpleado creado con exito!!");
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
                            fecha_ingreso = dateFormat.parse(fecha);
                        } catch (ParseException e) {
                            System.out.println("Formato de fecha incorrecto. Debe ser dd/MM/yyyy.");
                        }
                    }

                    System.out.println("Ingresa la nueva aerolinea en la que trabaja el empleado: ");
                    int up_id_aerolinea = sc.nextInt();

                    System.out.println("Ingresa el nuevo ID del aeropuerto donde trabaja el empleado: ");
                    String up_id_aeropuerto = sc.next();

                    Employee employee2 = new Employee(up_id_empleado, up_up_nombre, up_rol_empleado, up_fecha_ingreso, up_id_aerolinea, up_id_aeropuerto);
                    employeeService.updateEmployee(employee2);

                    System.out.println("\n\nEmpleado actualizado con exito!!");
                    break;
                case 3:
                    System.out.println("Ingrese el id del empleado a buscar: ");
                    String findId = sc.next();

                    Optional<Employee>employee3 = employeeService.findEmployeeById(findId);
                        employee3.ifPresentOrElse(
                        e -> System.out.println("Id: " + e.getId_empleado() + "\nNombre: " + e.getNombre_empleado() + "\nId rol: " + e.getId_rol() + "\nFecha de ingreso: " + e.getFecha_ingreso() + "\nAerolinea con la que trabaja: " + e.getId_aerolinea() + "\nAeropuerto en el que trabaja: " + e.getId_aeropuerto() + "\n\n"),
                        () -> System.out.println("No se encontro un empleado con el id: " + findId));
                    break;
                case 4:
                    System.out.println("Ingresa el id del empleado a eliminar: ");
                    String deleteId = sc.next();
                    employeeService.deleteEmployee(deleteId);

                    System.out.println("\n\nEmpleado eliminado con exito!!");
                    break;
                case 5:
                    System.out.println("EMPLEADOS");
                    employeeService.findAllEmployees().forEach(el ->{
                        System.out.println("Id: " + el.getId_empleado() + "\nNombre: " + el.getNombre_empleado() + "\nId rol: " + el.getId_rol() + "\nFecha de ingreso: " + el.getFecha_ingreso() + "\nAerolinea con la que trabaja: " + el.getId_aerolinea() + "\nAeropuerto en el que trabaja: " + el.getId_aeropuerto() + "\n\n");
                    });
                    break;
                case 6:
                    System.out.println("Volviendo al menu principal... Adios");
                    break;
                default:
                    System.out.println("Opcion invalida. Intentalo de nuevo");
                    sc.close();
                    break;
            }
        }
    }
}
