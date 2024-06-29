package com.proyectojava.trip.adapters.in;

import com.proyectojava.trip.application.TripService;
import com.proyectojava.trip.domain.models.Trip;
import com.proyectojava.utility.Validations;
import com.proyectojava.generalConsole.in.GeneralConsoleAdapter;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TripConsoleAdapter {
    private final TripService tripService;
    private final Scanner scanner;
    private final Validations validations;

    public TripConsoleAdapter(TripService tripService) {
        this.tripService = tripService;
        this.scanner = new Scanner(System.in);
        this.validations = new Validations();
    }

    public void start() throws ParseException {
        GeneralConsoleAdapter MP = new GeneralConsoleAdapter();
        while (true) {
            menuTrips();
            int choice = validations.validarInt("Seleccione una opción: ");

            switch (choice) {
                case 1:
                    createTrip();
                    break;

                case 2:
                    updateTrip();
                    break;

                case 3:
                    findTripById();
                    break;

                case 4:
                    deleteTrip();
                    break;

                case 5:
                    listAllTrips();
                    break;

                case 6:
                    exit();
                    MP.showAdminMenu(scanner);
                    break;

                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }
    }

    private void menuTrips() {
        System.out.println("1. Crear Viaje");
        System.out.println("2. Actualizar Viaje");
        System.out.println("3. Buscar Viaje por ID");
        System.out.println("4. Eliminar Viaje");
        System.out.println("5. Listar todos los Viajes");
        System.out.println("6. Salir");
    }

    private void createTrip() {
        double precio = validations.validarDouble("Ingrese el precio del viaje: ");
        String lugarIda = validations.caracteres("Ingrese el lugar de Origen: ", 50);
        //Pendiente Listar Ciudades
        String lugarLlegada = validations.caracteres("Ingrese el Destino: ", 50);
        //Pendiente Listar Ciudades

        Trip newTrip = new Trip(0, precio, lugarIda, lugarLlegada);
        tripService.createTrip(newTrip);

        System.out.println("\n****************************");
        System.out.println("* Viaje creado exitosamente. *");
        System.out.println("******************************\n");



    }


    private void updateTrip() {
        int idTrip = validations.validarInt("Ingrese el ID del viaje a actualizar: ");
        double precio = validations.validarDouble("Ingrese el nuevo precio del viaje: ");
        String lugarIda = validations.caracteres("Ingrese el nuevo lugar de ida: ", 50);
        String lugarLlegada = validations.caracteres("Ingrese el nuevo lugar de llegada: ", 50);
        Trip updatedTrip = new Trip(idTrip, precio, lugarIda, lugarLlegada);
        tripService.updateTrip(updatedTrip);
        System.out.println("\n************************************");
        System.out.println("* Viaje actualizado exitosamente. *");
        System.out.println("************************************\n");
    }

    public void findTripById() {
        int idTrip = validations.validarInt("Ingrese el ID del viaje a buscar: ");
        Optional<Trip> trip = tripService.getTripById(idTrip);
        trip.ifPresentOrElse(
                t -> System.out.println("ID: " + t.getId_trip() + ", Precio: " + t.getPrecio() + ", Lugar de Ida: "
                        + t.getLugar_ida() + ", Lugar de Llegada: " + t.getLugar_llegada()),
                () -> System.out.println("Viaje con id " + idTrip + "no encontrado"));
    }

    private void deleteTrip() {
        int idTrip = validations.validarInt("Ingrese el ID del viaje a eliminar: ");
        tripService.deleteTrip(idTrip);
        System.out.println("\n*******************************");
        System.out.println("* Viaje eliminado exitosamente. *");
        System.out.println("*********************************\n");
    }

    public void listAllTrips() {
        System.out.println("##   ##   ######    ###         ##  #######   #####   ");
        System.out.println("##   ##     ##     ## ##        ##   ##   #  ##   ##  ");
        System.out.println("##   ##     ##    ##   ##       ##   ##      ##       ");
        System.out.println(" ## ##      ##    ##   ##       ##   ####     #####   ");
        System.out.println(" ## ##      ##    #######  ##   ##   ##           ##  ");
        System.out.println("  ###       ##    ##   ##   ## ##    ##   #  ##   ##  ");
        System.out.println("  ###     ######  ##   ##    ###    #######   #####   ");

        tripService.getAllTripes().forEach(t -> {
            System.out.println("ID: " + t.getId_trip() + ", Precio: " + t.getPrecio() + ", Lugar de Ida: "
                    + t.getLugar_ida() + ", Lugar de Llegada: " + t.getLugar_llegada());
        });
    }

    private void exit() {
        System.out.println("Volviendo al menu principal...");
    }

    public void listIdTrip(){
        List<Trip> idTrip = tripService.getAllTripes(); 

        System.out.println("----------------------");
        System.out.printf("%-10s", "ID");
        System.out.println("-----------------------");

        for(Trip id : idTrip){
            System.out.printf("%-10s",id.getId_trip() );
        }
    }
}
