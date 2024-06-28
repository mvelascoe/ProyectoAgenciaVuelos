package com.proyectojava.tripulation.adapters.in;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import com.proyectojava.generalConsole.in.GeneralConsoleAdapter;
import com.proyectojava.employee.domain.models.Employee;
import com.proyectojava.flightconnection.domain.models.FlightConnection;
import com.proyectojava.tripulation.application.TrpulationService;
import com.proyectojava.tripulation.domain.models.Tripulation;

public class TripulationConsoleAdapter {
    private final TrpulationService trpulationService;

    public TripulationConsoleAdapter(TrpulationService trpulationService) {
        this.trpulationService = trpulationService;
    }

    public void startTripulation() throws ParseException {
        GeneralConsoleAdapter MP = new GeneralConsoleAdapter();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "1. Crear Aeropuerto\n2. Actualizar informacion de Aeropuerto\n3. Buscar Aeropuerto\n4. Eliminar Aeropuerto\n5. Listar todos los Aeropuertos\n6. Volver\n\n");
            System.out.println("Ingresa una opcion");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    List<Employee> empleados = trpulationService.EmployeeAll();
                    System.out.println("\n********************************");
                    System.out.printf("%-15s", "Id_empleados");
                    System.out.println("********************************\n");

                    for (Employee em : empleados) {
                        System.out.printf("%-15s", em.getId_empleado());
                    }

                    System.out.println("\nIngresa el id del empleado");
                    String emp = sc.next();

                    Optional<Employee> optionalEmployee = trpulationService.EmployeeId(emp);
                    if (optionalEmployee.isPresent()) {

                        List<FlightConnection> escalas = trpulationService.allConnections();
                        System.out.println("\n********************************");
                        System.out.printf("%-15s", "Id_conexion");
                        System.out.println("********************************\n");

                        for (FlightConnection esc : escalas) {
                            System.out.printf("%-15s", esc.getId_trayectoria());
                        }
                        System.out.println("Ingrese el id de la conexion");
                        int tra = sc.nextInt();

                        Optional<FlightConnection> optionalFlightC = trpulationService.FlightConnectionById(tra);
                        if (optionalFlightC.isPresent()) {
                            Tripulation team = new Tripulation(emp, tra);
                            trpulationService.createTripulation(team);
                            System.out.println("\n*************************************");
                            System.out.println("* Tripulacion creada correctamente *");
                            System.out.println("************************************\n");
                        }
                    } else {
                        System.out.println("Error: Hay datos que no coinciden...");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese id de la tripulacion a actualizar");
                    int up_tri = sc.nextInt();

                    System.out.println("Ingresa el nuevo id del empleado: ");
                    String up_emp = sc.nextLine();

                    System.out.println("Ingresa el nuevo id de trayectoria: ");
                    int up_tra = sc.nextInt();

                    Tripulation tr = new Tripulation(up_tri, up_emp, up_tra);
                    trpulationService.updateTripulation(tr);
                    System.out.println("\n***************************************");
                    System.out.println("* Tripulacion actualizada correctamente *");
                    System.out.println("*****************************************\n");

                    break;
                case 3:
                    System.out.println("Ingresa elId de la tripulacion a buscar: ");
                    int findId = sc.nextInt();
                    Optional<Tripulation> tripula = trpulationService.findTripulationById(findId);
                    tripula.ifPresentOrElse(
                            t -> System.out.println("Id: " + t.getId_tripulacion() + "Id empleado: "
                                    + t.getId_empleado() + "Id trayectoria: " + t.getId_trayectoria()),
                            () -> System.out.println("No se encontro la tripulacion con el id : " + findId));
                    break;
                case 4:
                    System.out.println("Ingresa el Id de la tripulacion a eliminar:");
                    int deletetri = sc.nextInt();
                    trpulationService.deleteTripulation(deletetri);
                    System.out.println("\n*************************************");
                    System.out.println("* Tripulacion eliminada correctamente *");
                    System.out.println("************************************\n");
                    break;
                case 5:
                    System.out.println("TRIPULACIONES");
                    trpulationService.findAllTripulation().forEach(tl -> {
                        System.out.println("Id: " + tl.getId_tripulacion() + "Id empleado: " + tl.getId_empleado()
                                + "Id trayectoria: " + tl.getId_trayectoria());
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

}
