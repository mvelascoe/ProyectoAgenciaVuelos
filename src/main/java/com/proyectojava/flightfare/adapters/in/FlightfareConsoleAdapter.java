package com.proyectojava.flightfare.adapters.in;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import com.proyectojava.generalConsole.in.GeneralConsoleAdapter;
import com.proyectojava.flightfare.application.FlightfareService;
import com.proyectojava.flightfare.domain.models.Flightfare;

public class FlightfareConsoleAdapter {
    private final FlightfareService flightfareService;

    public FlightfareConsoleAdapter(FlightfareService flightfareService) {
        this.flightfareService = flightfareService;
    }

    public void startFlightFare() throws ParseException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            GeneralConsoleAdapter MP = new GeneralConsoleAdapter();
            System.out.println(
                    "1. Crear tarifa\n2. Actualizar informacion de tarifa\n3. Buscar tarifa\n4. Eliminar tarifa\n5. Listar todas las tarifas\n6. Volver\n\n");
            System.out.println("Ingresa una opcion");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa la descripcion de la tarifa: ");
                    String descripcion = sc.next();

                    System.out.println("Ingresa los detalles de la tarifa: ");
                    String detalles = sc.next();

                    System.out.println("Ingresa el valor de la tarifa: ");
                    Double valor = sc.nextDouble();

                    Flightfare fare = new Flightfare(descripcion, detalles, valor);
                    flightfareService.createFlightFare(fare);

                    System.out.println("\n**************************************");
                    System.out.println("*     Tarifa creada exitosamente    *");
                    System.out.println("**************************************\n");
                    break;
                case 2:
                    System.out.println("Ingresa el ID de la tarifa a actualizar: ");
                    int upID = sc.nextInt();

                    System.out.println("Ingresa la nueva descripcion: ");
                    String upDes = sc.next();

                    System.out.println("Ingresa los nuevos detalles: ");
                    String upDe = sc.next();

                    System.out.println("Ingresa el  nuevo valor de la tarifa: ");
                    Double upVa = sc.nextDouble();

                    Flightfare fares = new Flightfare(upID, upDes, upDe, upVa);
                    flightfareService.updateFligtFare(fares);

                    System.out.println("\n**************************************");
                    System.out.println("*    Tarifa actualizada exitosamente  *");
                    System.out.println("**************************************\n");
                    break;
                case 3:
                    consultaTarifa();
                    break;
                case 4:
                    System.out.println("Ingresa el ID de la tarifa a eliminar: ");
                    int deleteID = sc.nextInt();
                    flightfareService.deleteFlightFare(deleteID);

                    System.out.println("\n**************************************");
                    System.out.println("*   Tarifa eliminada exitosamente    *");
                    System.out.println("**************************************\n");
                    break;
                case 5:
                    System.out.println(" # #####   ###    ######    ######   #######   ###     #####   ");
                    System.out.println("## ## ##  ## ##    ##  ##     ##      ##   #  ## ##   ##   ##  ");
                    System.out.println("   ##    ##   ##   ##  ##     ##      ##     ##   ##  ##       ");
                    System.out.println("   ##    ##   ##   #####      ##      ####   ##   ##   #####   ");
                    System.out.println("   ##    #######   ## ##      ##      ##     #######       ##  ");
                    System.out.println("   ##    ##   ##   ## ##      ##      ##     ##   ##  ##   ##  ");
                    System.out.println("  ####   ##   ##  #### ##   ######   ####    ##   ##   #####   ");

                    flightfareService.findAllFlightfares().forEach(tt -> {
                        System.out.println("ID: " + tt.getId_tarifa() + ", Descripcion: " + tt.getDescripcion()
                                + ", Detalles: " + tt.getDetalles() + ", Valor: " + tt.getValor());
                    });
                    break;
                case 6:
                    System.out.println("Volviendo al menu principal... Adios");
                    MP.showClientMenu(sc);
                    break;
                default:
                    System.out.println("Opcion invalida. Intentalo de nuevo");
                    break;
            }
        }
    }

    public void consultaTarifa() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el ID de la tarifa a buscar: ");
        int idT = sc.nextInt();

        Optional<Flightfare> flightfare = flightfareService.findFligthFareById(idT);
        flightfare.ifPresentOrElse(
                ff -> System.out
                        .println("ID: " + ff.getId_tarifa() + ", Descripcion: " + ff.getDescripcion()
                                + ", Detalles: " + ff.getDetalles() + ", Valor: " + ff.getValor()),
                () -> System.out.println("No se encontraron tarifas"));
    }

    public void listIDFare(){
        List<Flightfare> idFares = flightfareService.findAllFlightfares();

        System.out.println("----------------------");
        System.out.printf("%-10s", "ID");
        System.out.println("-----------------------");

        for(Flightfare id : idFares){
            System.out.printf("%-10s",id.getId_tarifa() );
        }
    }
}