package com.proyectojava.tripbookingdetails.adapters.in;

import java.util.Optional;
import java.util.Scanner;

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

    public void startDetails() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "1. Crear Detalle\n2. Actualizar informacion de Detalle\n3. Buscar Detalle\n4. Eliminar Detalle\n5. Listar todas las Detalles\n6. Volver\n\n");
            System.out.println("Ingresa una opcion");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el id del trip_booking :");
                    int booking = sc.nextInt();

                    Optional<Tripbooking> optionalDetails = tripBookingDetailsService.findBooking(booking);

                    if (optionalDetails.isPresent()) {
                        System.out.println("Ingresa el id del cliente: ");
                        String cliente = sc.nextLine();

                        Optional<Customer> optionalCustomer = tripBookingDetailsService.findCustomer(cliente);
                        if (optionalCustomer.isPresent()) {
                            System.out.println("Ingresa el id de la tarifa: ");
                            int tarifa = sc.nextInt();

                            Optional<Flightfare> optionalFare = tripBookingDetailsService.findFareById(tarifa);
                            if (optionalFare.isPresent()) {
                                TripBokkingDetails detail = new TripBokkingDetails(booking, cliente, tarifa);
                                tripBookingDetailsService.createTripBookinDetail(detail);
                                System.out.println("El detalle ha sido correctamente creado!!");
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

                    TripBokkingDetails detail1 = new TripBokkingDetails(detalle,bookin,cliente,tarifa);
                    tripBookingDetailsService.updateTripBookingDetail(detail1);
                    System.out.println("\n\nEl detalle ha sido actualizado");

                    break;
                case 3:
                    System.out.println("Ingresa el id del detalle a modificar:");
                    int findId = sc.nextInt();

                    Optional<TripBokkingDetails> busca = tripBookingDetailsService.findDetailById(findId);
                    busca.ifPresentOrElse(
                        d -> System.out.println("Id: " + d.getId_trip_booking_details() + ", Id_Booking: " + d.getId_trip_booking() + ", Id_cliente: " + d.getId_cliente() + ", Id_tarifa: " + d.getId_tarifa()),
                        () -> System.out.println("No se encontro un detalle con el id "+ findId));

                    break;
                case 4:
                    System.out.println("Ingresa el ID del detalle a eliminar: ");
                    int deleteId = sc.nextInt();
                    tripBookingDetailsService.deleteDetail(deleteId);
                    System.out.println("\n\nEl detalle ha sido eliminado correctamente");
                    break;
                case 5:
                    System.out.println("DETALLES");
                    tripBookingDetailsService.findAllDetails().forEach(dl ->{
                        System.out.println("Id: " + dl.getId_trip_booking_details() + ", Id_Booking: " + dl.getId_trip_booking() + ", Id_cliente: " + dl.getId_cliente() + ", Id_tarifa: " + dl.getId_tarifa());
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
