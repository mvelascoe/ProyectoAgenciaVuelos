package com.proyectojava.tripbooking.adapters.in;

import com.proyectojava.trip.domain.models.Trip;
import com.proyectojava.tripbooking.application.TripbookingService;
import com.proyectojava.tripbooking.domain.models.Tripbooking;
import com.proyectojava.utility.Validations;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class TripbookingConsoleAdapter {
    private final TripbookingService tripbookingService;
    private final Validations validations;

    public TripbookingConsoleAdapter(TripbookingService tripbookingService) {
        this.tripbookingService = tripbookingService;
        this.validations = new Validations();
    }

    public void start() {
        System.out.println("Bienvenido al sistema de gestión de reservas de viajes.");

        while (true) {
            menuTripB();
            int choice = validations.validarInt("Seleccione una opción: ");

            switch (choice) {
                case 1:
                    createTripbooking();
                    break;

                case 2:
                    updateTripbooking();
                    break;

                case 3:
                    findTripbookingById();
                    break;

                case 4:
                    deleteTripbooking();
                    break;

                case 5:
                    listAllTripbookings();
                    break;

                case 6:
                    exit();
                    return; // Salir del método start() al elegir salir

                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }
    }

    private void menuTripB() {
        System.out.println("1. Crear reserva de viaje");
        System.out.println("2. Actualizar reserva de viaje");
        System.out.println("3. Buscar reserva de viaje por ID");
        System.out.println("4. Eliminar reserva de viaje");
        System.out.println("5. Listar todas las reservas de viaje");
        System.out.println("6. Salir");
    }

    private void createTripbooking() {
        System.out.println("\nCreación de reserva de viaje:");

        Date fechaTicket = validations.validarFecha("Ingrese la fecha del ticket (YYYY-MM-DD):");
        int idTrip = validations.validarInt("Ingrese el ID del viaje:");

        Optional<Trip>optionalTrip = tripbookingService.findTrip(idTrip);
        if(optionalTrip.isPresent()){
            Tripbooking nuevaReserva = new Tripbooking(0, fechaTicket, idTrip);
        tripbookingService.createTripbooking(nuevaReserva);
        System.out.println("Reserva de viaje creada exitosamente.");
        }else{
            System.out.println("No se encontro la reserva del viaje con id "+ idTrip);
        }
        
    }

    private void updateTripbooking() {
        System.out.println("\nActualización de reserva de viaje:");

        int idReserva = validations.validarInt("Ingrese el ID de la reserva a actualizar:");
        Date fechaTicket = validations.validarFecha("Ingrese la nueva fecha del ticket (YYYY-MM-DD):");
        int idTrip = validations.validarInt("Ingrese el nuevo ID del viaje:");

        Tripbooking reservaActualizada = new Tripbooking(idReserva, fechaTicket, idTrip);
        tripbookingService.updateTripbooking(reservaActualizada);
        System.out.println("Reserva de viaje actualizada exitosamente.");
    }

    private void findTripbookingById() {
        System.out.println("\nBúsqueda de reserva de viaje por ID:");

        int idReserva = validations.validarInt("Ingrese el ID de la reserva a buscar:");
        Optional<Tripbooking> optionalReserva = tripbookingService.getTripbookingById(idReserva);
        optionalReserva.ifPresentOrElse(
            reserva -> {
                System.out.println("ID de reserva: " + reserva.getId_trip_booking());
                System.out.println("Fecha del ticket: " + reserva.getFecha_ticket());
                System.out.println("ID del viaje: " + reserva.getId_trip());
            },
            () -> System.out.println("No se encontró la reserva con ID: " + idReserva)
        );
    }

    private void deleteTripbooking() {
        System.out.println("\nEliminación de reserva de viaje:");

        int idReserva = validations.validarInt("Ingrese el ID de la reserva a eliminar:");
        tripbookingService.deleteTripbooking(idReserva);
        System.out.println("Reserva de viaje eliminada exitosamente.");
    }

    private void listAllTripbookings() {
        System.out.println("\nListado de todas las reservas de viaje:");
        List<Tripbooking> reservas = tripbookingService.getAllTripbooking();
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas de viaje registradas.");
        } else {
            reservas.forEach(reserva -> {
                System.out.println("ID de reserva: " + reserva.getId_trip_booking());
                System.out.println("Fecha del ticket: " + reserva.getFecha_ticket());
                System.out.println("ID del viaje: " + reserva.getId_trip());
                System.out.println("-----------------------");
            });
        }
    }

    private void exit() {
        System.out.println("Saliendo del programa...");
        System.exit(0);
    }
}

