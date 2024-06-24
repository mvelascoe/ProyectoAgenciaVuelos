package com.proyectojava.statusA.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.proyectojava.statusA.application.StatusService;
import com.proyectojava.statusA.domain.models.Status;

public class StatusConsoleAdapter {
    private final StatusService statusService;

    public StatusConsoleAdapter(StatusService statusService) {
        this.statusService = statusService;
    }

    public void startStatus() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "1. Crear estatus\n2. Actualizar informacion de estatus\n3. Buscar estatus\n4. Eliminar estatus\n5. Listar todas los estatus\n6. Volver\n\n");
            System.out.println("Ingresa una opcion");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el nombre de estado: ");
                    String name = sc.next();

                    Status status = new Status(name);
                    statusService.createStatus(status);
                    break;
                case 2:
                    System.out.println("Ingresa el ID de el estado a actualizar: ");
                    int upID = sc.nextInt();

                    System.out.println("Ingresa el nuevo nombre: ");
                    String upName = sc.next();

                    Status upStatus = new Status(upID,upName);
                    statusService.updateStatus(upStatus);
                    break;
                case 3:
                    System.out.println("Ingresa el ID de el estado a buscar: ");
                    int findId = sc.nextInt();

                    Optional<Status> statusA = statusService.getStatusById(findId);
                    statusA.ifPresentOrElse(
                    s -> System.out.println("ID: " + s.getId_estado() + ", Nombre: " + s.getNombre_estado()),
                    () -> System.out.println("No hay Status ingresados")); 
                    break;
                case 4:
                    System.out.println("Ingrese el ID del estado a eliminar: ");
                    int deleteID = sc.nextInt();
                    statusService.deleteStatus(deleteID);
                    break;
                case 5:
                    System.out.println("STATUS");
                    statusService.getAllStatuses().forEach(s -> {
                        System.out.println("ID: " + s.getId_estado() + ", Nombre: " + s.getNombre_estado());
                    });
                    break;
                case 6:
                    System.out.println("Volviendo al menu principal Adios....");
                    break;
                default:
                    System.out.println("solo opciones validas");
                    sc.close();
                    break;
            }

        }
    }
}
