package com.proyectojava.tripulation.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.proyectojava.employee.domain.models.Employee;
import com.proyectojava.flightconnection.domain.models.FlightConnection;
import com.proyectojava.tripulation.application.TrpulationService;
import com.proyectojava.tripulation.domain.models.Tripulation;

public class TripulationConsoleAdapter {
    private final TrpulationService trpulationService;

    public TripulationConsoleAdapter(TrpulationService trpulationService) {
        this.trpulationService = trpulationService;
    }

    public void startTripulation(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "1. Crear Aeropuerto\n2. Actualizar informacion de Aeropuerto\n3. Buscar Aeropuerto\n4. Eliminar Aeropuerto\n5. Listar todos los Aeropuertos\n6. Volver\n\n");
            System.out.println("Ingresa una opcion");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el id del empleado");
                    String emp = sc.next();

                    Optional<Employee> optionalEmployee = trpulationService.EmployeeId(emp);
                    if(optionalEmployee.isPresent()){
                        System.out.println("Ingrese el id de la trayectoria");
                        int tra = sc.nextInt();

                        Optional<FlightConnection> optionalFlightC = trpulationService.FlightConnectionById(tra);
                        if (optionalFlightC.isPresent()) {
                            Tripulation team = new Tripulation(emp,tra);
                            trpulationService.createTripulation(team);
                            System.out.println("\n\nTripulacion creada correctamente!!");
                        }
                    }else{
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

                    Tripulation tr = new Tripulation(up_tri,up_emp,up_tra);
                    trpulationService.updateTripulation(tr);
                    System.out.println("\n\nLa tripulacionha sido actualizado correctamente!!");


                    break;
                case 3:
                System.out.println("Ingresa elId de la tripulacion a buscar: ");
                int findId = sc.nextInt();
                    Optional<Tripulation> tripula = trpulationService.findTripulationById(findId);
                    tripula.ifPresentOrElse(t -> System.out.println("Id: " + t.getId_tripulacion() + "Id empleado: "+ t.getId_empleado() + "Id trayectoria: " + t.getId_trayectoria())
                    ,() -> System.out.println("No se encontro la tripulacion con el id : " + findId));
                    break;
                case 4:
                    System.out.println("Ingresa el Id de la tripulacion a eliminar:");
                    int deletetri = sc.nextInt();
                    trpulationService.deleteTripulation(deletetri);
                    System.out.println("\n\nTripulacion eliminada correctamente!!");
                    break;
                case 5:
                    System.out.println("TRIPULACIONES");
                    trpulationService.findAllTripulation().forEach(tl ->{
                        System.out.println("Id: " + tl.getId_tripulacion() + "Id empleado: "+ tl.getId_empleado() + "Id trayectoria: " + tl.getId_trayectoria());
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
