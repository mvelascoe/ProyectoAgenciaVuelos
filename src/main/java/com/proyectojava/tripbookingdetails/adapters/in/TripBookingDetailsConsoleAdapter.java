package com.proyectojava.tripbookingdetails.adapters.in;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import com.proyectojava.generalConsole.in.GeneralConsoleAdapter;
import com.proyectojava.customer.domain.models.Customer;
import com.proyectojava.flightfare.domain.models.Flightfare;
import com.proyectojava.tripbooking.domain.models.Tripbooking;
import com.proyectojava.tripbookingdetails.aplication.TripBookingDetailsService;
import com.proyectojava.tripbookingdetails.domain.models.TripBokkingDetails;

public class TripBookingDetailsConsoleAdapter {
    private final TripBookingDetailsService tripBookingDetailsService;

    public TripBookingDetailsConsoleAdapter(TripBookingDetailsService tripBookingDetailsService) {
        this.tripBookingDetailsService = tripBookingDetailsService;
    }

    public void startDetails() throws ParseException {
        Scanner sc = new Scanner(System.in);
        GeneralConsoleAdapter MP = new GeneralConsoleAdapter();
        while (true) {
            System.out.println(
                    "1. Crear Detalle\n2. Actualizar informacion de Detalle\n3. Buscar Detalle\n4. Eliminar Detalle\n5. Listar todas las Detalles\n6. Volver\n\n");
            System.out.println("Ingresa una opcion");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    List<Tripbooking> reservas = tripBookingDetailsService.findAllBooking();
                    System.out.println("\n**********************************");
                    System.out.printf("%-15s", "ID_reservas");
                    System.out.println("************************************\n");

                    for (Tripbooking reserva : reservas) {
                        System.out.printf("%-15s", reserva.getId_trip_booking());
                    }

                    System.out.println("Ingresa el id de la reserva de vuelo:");
                    int booking = sc.nextInt();

                    Optional<Tripbooking> optionalDetails = tripBookingDetailsService.findBooking(booking);

                    if (optionalDetails.isPresent()) {

                        List<Customer> clientes = tripBookingDetailsService.findAllCustomers();
                        System.out.println("\n**********************************");
                        System.out.printf("%-15s", "ID_Clientes");
                        System.out.println("************************************\n");

                        for (Customer cliente : clientes) {
                            System.out.printf("%-15s", cliente.getId_cliente());
                        }

                        System.out.println("Ingresa el id del cliente: ");
                        String cliente = sc.nextLine();

                        Optional<Customer> optionalCustomer = tripBookingDetailsService.findCustomer(cliente);
                        if (optionalCustomer.isPresent()) {

                            List<Flightfare> tarifas = tripBookingDetailsService.findAllFares();

                            System.out.println("\n****************************");
                            System.out.printf("%-15s", "ID_Tarifas");
                            System.out.println("******************************\n");

                            for (Flightfare fare : tarifas) {
                                System.out.printf("%-15s", fare.getId_tarifa());
                            }
                            System.out.println("Ingresa el id de la tarifa: ");
                            int tarifa = sc.nextInt();

                            Optional<Flightfare> optionalFare = tripBookingDetailsService.findFareById(tarifa);
                            if (optionalFare.isPresent()) {
                                TripBokkingDetails detail = new TripBokkingDetails(booking, cliente, tarifa);
                                tripBookingDetailsService.createTripBookinDetail(detail);
                                System.out.println("\n*********************************");
                                System.out.println("* Detalle creado exitosamente. *");
                                System.out.println("*********************************\n");
                            }
                        }
                    } else {
                        System.out.println("Error...\nHay datos no existentes");
                    }

                    break;
                case 2:
                    System.out.println("Ingresa el id del detalle a actualizar:");
                    int detalle = sc.nextInt();

                    System.out.println("Ingresa el nuevo id del booking: ");
                    int bookin = sc.nextInt();

                    System.out.println("Ingresa el nuevo id del cliente:");
                    String cliente = sc.nextLine();

                    System.out.println("Ingresa el nuevo id de la tarifa: ");
                    int tarifa = sc.nextInt();

                    TripBokkingDetails detail1 = new TripBokkingDetails(detalle, bookin, cliente, tarifa);
                    tripBookingDetailsService.updateTripBookingDetail(detail1);
                    System.out.println("\n************************************");
                    System.out.println("* Detalle actualizado exitosamente. *");
                    System.out.println("************************************\n");

                    break;
                case 3:
                    System.out.println("Ingresa el id del detalle a modificar:");
                    int findId = sc.nextInt();

                    Optional<TripBokkingDetails> busca = tripBookingDetailsService.findDetailById(findId);
                    busca.ifPresentOrElse(
                            d -> System.out.println("Id: " + d.getId_trip_booking_details() + ", Id_Booking: "
                                    + d.getId_trip_booking() + ", Id_cliente: " + d.getId_cliente() + ", Id_tarifa: "
                                    + d.getId_tarifa()),
                            () -> System.out.println("No se encontro un detalle con el id " + findId));

                    break;
                case 4:
                    System.out.println("Ingresa el ID del detalle a eliminar: ");
                    int deleteId = sc.nextInt();
                    tripBookingDetailsService.deleteDetail(deleteId);
                    System.out.println("\n**********************************");
                    System.out.println("* Detalle eliminado exitosamente. *");
                    System.out.println("**********************************\n");
                    break;
                case 5:
                    System.out.println("#####    #######   # #####   ###    ####     ####     #######   #####   ");
                    System.out.println(" ## ##    ##   #  ## ## ##  ## ##    ##       ##       ##   #  ##   ##  ");
                    System.out.println(" ##  ##   ##         ##    ##   ##   ##       ##       ##      ##       ");
                    System.out.println(" ##  ##   ####       ##    ##   ##   ##       ##       ####     #####   ");
                    System.out.println(" ##  ##   ##         ##    #######   ##       ##       ##           ##  ");
                    System.out.println(" ## ##    ##   #     ##    ##   ##   ##  ##   ##  ##   ##   #  ##   ##  ");
                    System.out.println("#####    #######    ####   ##   ##  #######  #######  #######   #####   ");

                    tripBookingDetailsService.findAllDetails().forEach(dl -> {
                        System.out.println(
                                "Id: " + dl.getId_trip_booking_details() + ", Id_Booking: " + dl.getId_trip_booking()
                                        + ", Id_cliente: " + dl.getId_cliente() + ", Id_tarifa: " + dl.getId_tarifa());
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
