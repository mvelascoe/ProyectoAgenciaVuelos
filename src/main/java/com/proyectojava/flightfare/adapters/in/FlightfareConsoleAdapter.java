package com.proyectojava.flightfare.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.proyectojava.flightfare.application.FlightfareService;
import com.proyectojava.flightfare.domain.models.Flightfare;

public class FlightfareConsoleAdapter {
    private final FlightfareService flightfareService;

    public FlightfareConsoleAdapter(FlightfareService flightfareService) {
        this.flightfareService = flightfareService;
    }

    public void startFlightFare() {
        Scanner sc = new Scanner(System.in);

        while (true) {
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

                    Flightfare fare = new Flightfare(descripcion,detalles,valor);
                    flightfareService.createFlightFare(fare);
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

                    Flightfare fares = new Flightfare(upID,upDes,upDe,upVa);
                    flightfareService.updateFligtFare(fares);
                    break;
                case 3: 
                    System.out.println("Ingresa el ID de la tarifa a buscar: ");
                    int idT = sc.nextInt();

                    Optional<Flightfare> flightfare = flightfareService.findFligthFareById(idT);
                    flightfare.ifPresentOrElse(
                        ff -> System.out.println("ID: " + ff.getId_tarifa() + ", Descripcion: " + ff.getDescripcion() + ", Detalles: " + ff.getDetalles() + ", Valor: " + ff.getValor()),
                        () -> System.out.println("No se encontraron tarifas"));
                    break;
                case 4:
                    System.out.println("Ingresa el ID de la tarifa a eliminar: ");
                    int deleteID = sc.nextInt();
                    flightfareService.deleteFlightFare(deleteID);
                    break;
                case 5:
                System.out.println("TARIFAS");
                flightfareService.findAllFlightfares().forEach(tt ->{
                    System.out.println("ID: " + tt.getId_tarifa() + ", Descripcion: " + tt.getDescripcion() + ", Detalles: " + tt.getDetalles() + ", Valor: " + tt.getValor());
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