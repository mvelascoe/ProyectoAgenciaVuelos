package com.proyectojava.airline.adapters.in;

import java.text.ParseException;
import java.util.Optional;
import java.util.Scanner;

import com.proyectojava.airline.application.AirlineService;
import com.proyectojava.airline.domain.models.Airline;
import com.proyectojava.generalConsole.in.GeneralConsoleAdapter;

public class AirlineConsoleAdapter {
    private final AirlineService airlineService;

    public AirlineConsoleAdapter(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    public void startAirline() throws ParseException {
        Scanner sc = new Scanner(System.in);
        GeneralConsoleAdapter MP = new GeneralConsoleAdapter();

        while (true) {
            System.out.println(
                    "1. Crear aerolinea\n2. Actualizar informacion de aerolinea\n3. Buscar aerolinea\n4. Eliminar aerolinea\n5. Listar todas las aerolineas\n6. Volver\n\n");
            System.out.println("Ingresa una opcion");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el nombre de la Aerolinea: ");
                    String name = sc.next();

                    Airline newAirline = new Airline(name);
                    airlineService.createAirline(newAirline);

                    System.out.println("\n**************************************");
                    System.out.println("*    Aerolinea creada exitosamente   *");
                    System.out.println("**************************************\n");
                    break;
                case 2:
                    System.out.println("Ingresa el ID de la Aerolinea a actualizar: ");
                    int updateId = sc.nextInt();

                    System.out.println("Ingresa el nuevo nombre: ");
                    String updateName = sc.next();

                    Airline updatAirline = new Airline(updateId, updateName);
                    airlineService.updateAirline(updatAirline);
                    System.out.println("\n**************************************");
                    System.out.println("*   Aerolinea actualizada exitosamente *");
                    System.out.println("**************************************\n");
                    break;
                case 3:
                    System.out.println("Ingresa el ID de la Aerolinea a buscar: ");
                    int findId = sc.nextInt();

                    Optional<Airline> airline = airlineService.getAirlineById(findId);
                    airline.ifPresentOrElse(
                            a -> System.out
                                    .println("ID: " + a.getId_aerolinea() + " ,nombre: " + a.getNombre_aerolinea()),
                            () -> System.out.println("Pais no encontrado"));
                    break;
                case 4:
                    System.out.println("Ingrese el ID de la Aerolinea a eliminar: ");
                    int deleteId = sc.nextInt();
                    airlineService.deleteAirline(deleteId);

                    System.out.println("\n**************************************");
                    System.out.println("*  Aerolinea eliminada exitosamente   *");
                    System.out.println("**************************************\n");
                    break;
                case 5:
                listArolineas();
                    airlineService.getAllAirlines().forEach(a -> {
                        System.out.println("ID: " + a.getId_aerolinea() + ", Nombre: " + a.getNombre_aerolinea());
                    });
                    break;
                case 6:
                    System.out.println("Volviendo al menu principal... Adios");
                    MP.showMainMenu();
                    break;
                default:
                    System.out.println("Opcion invalida intentalo de nuevo");
                    break;
            }
        }
    }

    public void listArolineas(){
        System.out.println("  ###    #######  ######    #####   ####      ######  ##   ##  #######    ###     #####   ");
        System.out.println(" ## ##    ##   #   ##  ##  ### ###   ##         ##    ###  ##   ##   #   ## ##   ##   ##  ");
        System.out.println("##   ##   ##       ##  ##  ##   ##   ##         ##    #### ##   ##      ##   ##  ##       ");
        System.out.println("##   ##   ####     #####   ##   ##   ##         ##    #######   ####    ##   ##   #####   ");
        System.out.println("#######   ##       ## ##   ##   ##   ##         ##    ## ####   ##      #######       ##  ");
        System.out.println("##   ##   ##   #   ## ##   ### ###   ##  ##     ##    ##  ###   ##   #  ##   ##  ##   ##  ");
        System.out.println("##   ##  #######  #### ##   #####   #######   ######  ##   ##  #######  ##   ##   #####   ");

    }
}
