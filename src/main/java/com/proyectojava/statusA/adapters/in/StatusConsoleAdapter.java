package com.proyectojava.statusA.adapters.in;

import java.text.ParseException;
import java.util.Optional;
import java.util.Scanner;
import com.proyectojava.generalConsole.in.GeneralConsoleAdapter;
import com.proyectojava.statusA.application.StatusService;
import com.proyectojava.statusA.domain.models.Status;

public class StatusConsoleAdapter {
    private final StatusService statusService;

    public StatusConsoleAdapter(StatusService statusService) {
        this.statusService = statusService;
    }

    public void startStatus() throws ParseException {
        Scanner sc = new Scanner(System.in);
        GeneralConsoleAdapter MP = new GeneralConsoleAdapter();
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
                    System.out.println("\n*******************************");
                    System.out.println("* Estado creado exitosamente. *");
                    System.out.println("*******************************\n");
                    break;
                case 2:
                    System.out.println("Ingresa el ID de el estado a actualizar: ");
                    int upID = sc.nextInt();

                    System.out.println("Ingresa el nuevo nombre: ");
                    String upName = sc.next();

                    Status upStatus = new Status(upID, upName);
                    statusService.updateStatus(upStatus);

                    System.out.println("\n**********************************");
                    System.out.println("* Estado actualizado exitosamente. *");
                    System.out.println("***********************************\n");
                    break;
                case 3:
                    System.out.println("Ingresa el ID de el estado a buscar: ");
                    int findId = sc.nextInt();

                    Optional<Status> statusA = statusService.getStatusById(findId);
                    statusA.ifPresentOrElse(
                            s -> System.out.println("ID: " + s.getId_estado() + ", Nombre: " + s.getNombre_estado()),
                            () -> System.out.println("No hay un estado con el id " + findId));
                    break;
                case 4:
                    System.out.println("Ingrese el ID del estado a eliminar: ");
                    int deleteID = sc.nextInt();
                    statusService.deleteStatus(deleteID);
                    System.out.println("\n**********************************");
                    System.out.println("* Estado eliminada exitosamente. *");
                    System.out.println("***********************************\n");
                    break;
                case 5:
                    System.out.println("#######   #####    # #####   ###    #####     #####    #####   ");
                    System.out.println(" ##   #  ##   ##  ## ## ##  ## ##    ## ##   ### ###  ##   ##  ");
                    System.out.println(" ##      ##          ##    ##   ##   ##  ##  ##   ##  ##       ");
                    System.out.println(" ####     #####      ##    ##   ##   ##  ##  ##   ##   #####   ");
                    System.out.println(" ##           ##     ##    #######   ##  ##  ##   ##       ##  ");
                    System.out.println(" ##   #  ##   ##     ##    ##   ##   ## ##   ### ###  ##   ##  ");
                    System.out.println("#######   #####     ####   ##   ##  #####     #####    #####   ");

                    statusService.getAllStatuses().forEach(s -> {
                        System.out.println("ID: " + s.getId_estado() + ", Nombre: " + s.getNombre_estado());
                    });
                    break;
                case 6:
                    System.out.println("Volviendo al menu principal Adios....");
                    MP.showMainMenu();
                    break;
                default:
                    System.out.println("solo opciones validas");
                    break;
            }

        }
    }
}
