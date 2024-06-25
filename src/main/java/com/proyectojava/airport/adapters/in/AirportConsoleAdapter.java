package com.proyectojava.airport.adapters.in;

import java.util.Optional;
import java.util.Scanner;

import com.proyectojava.airport.application.AirportService;
import com.proyectojava.airport.domain.models.Airport;

public class AirportConsoleAdapter {
    private final AirportService airportService;

    public AirportConsoleAdapter(AirportService airportService) {
        this.airportService = airportService;
    }

    public void startAirports(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "1. Crear Aeropuerto\n2. Actualizar informacion de Aeropuerto\n3. Buscar Aeropuerto\n4. Eliminar Aeropuerto\n5. Listar todos los Aeropuertos\n6. Volver\n\n");
            System.out.println("Ingresa una opcion");
            int opcion = sc.nextInt();
        
            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el id del Aeropuerto: ");
                    String id = sc.next();

                    System.out.println("Ingresa el nombre del Aeropuerto: ");
                    String name = sc.next();

                    System.out.println("Ingresa el ID de la ciudad: ");
                    String id_ciudad = sc.next();

                    Airport airport = new Airport(id,name,id_ciudad);
                    airportService.createAirport(airport);
                    break;
                case 2: 
                    System.out.println("Ingresa el id del Aeropuerto a actualizar:");
                    String id_update = sc.next();

                    System.out.println("Nuevo nombre para Aeropuerto");
                    String name_update = sc.next();

                    System.out.println("Nuevo id de ciudad: ");
                    String idc_update = sc.next();

                    Airport airport2 = new Airport(id_update,name_update,idc_update);
                    airportService.updateAirport(airport2);
                    break;
                case 3:
                    System.out.println("Ingresa el ID del Aeropuerto a buscar: ");
                    String findID = sc.next();

                    Optional<Airport> airports = airportService.findAirportById(findID);
                    airports.ifPresentOrElse(
                        a -> System.out.println("ID: " + a.getId_aeropuerto() + ", Nombre: " + a.getNombre_aeropuerto() + ", Id ciudad: " + a.getId_ciudad()),
                        () -> System.out.println("No se encuntra ese aeropuerto"));
                    break;
                case 4:
                    System.out.println("Ingresa el ID de el Aeropuerto a eliminar");
                    String deleteID = sc.next();
                    airportService.deleteAirport(deleteID);
                    break;
                case 5:
                System.out.println("AEROPUERTOS");
                airportService.findAllAirports().forEach(la ->{
                    System.out.println("ID: " + la.getId_aeropuerto() + ", Nombre: " + la.getNombre_aeropuerto() + ", Id_ciudad: " + la.getId_ciudad());
                });
                    break;
                case 6:
                System.out.println("Volviendo al menu principal... Adios");
                    break;
                default:
                System.out.println("Opcion invalida. Intentalo de nuevo");
                    break;
            }
        }
    }
}
