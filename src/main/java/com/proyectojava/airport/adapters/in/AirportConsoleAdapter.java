package com.proyectojava.airport.adapters.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.proyectojava.airport.application.AirportService;
import com.proyectojava.airport.domain.models.Airport;
import com.proyectojava.cities.domain.models.Cities;
import com.proyectojava.country.domain.models.Country;

public class AirportConsoleAdapter {
    private final AirportService airportService;

    public AirportConsoleAdapter(AirportService airportService) {
        this.airportService = airportService;
    }

    public void startAirports() {
        Scanner sc = new Scanner(System.in);
        boolean bandera = true;
        while (bandera) {
            System.out.println(
                    "1. Crear Aeropuerto\n2. Actualizar informacion de Aeropuerto\n3. Buscar Aeropuerto\n4. Eliminar Aeropuerto\n5. Listar todos los Aeropuertos\n6. Volver\n\n");
            System.out.println("Ingresa una opcion");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el id del Aeropuerto: ");
                    String id = sc.next();
                    sc.nextLine();
                    System.out.println("Ingresa el nombre del Aeropuerto: ");
                    String name = sc.nextLine();

                      // Lista los países
                    List<Cities> city = airportService.allCities();

                    // Imprime la cabecera de la tabla
                    System.out.println("---------------------------------------");
                    System.out.printf("%-10s %-30s%n", "ID", "Nombre");
                    System.out.println("---------------------------------------");
            
                    // Imprime cada país en una fila de la tabla
                    for (Cities cities : city) {
                        System.out.printf("%-10s %-30s%n", cities.getId_ciudad(), cities.getNombre_ciudad());
                    }

                    System.out.println("Ingresa el ID de la ciudad: ");
                    String id_ciudad = sc.next();

                    Optional<Cities> optionalCities = airportService.citiesByID(id_ciudad);
                    if (optionalCities.isPresent()) {
                        Airport airport = new Airport(id, name, id_ciudad);
                        airportService.createAirport(airport);
                        System.out.println("\n\nAeropuerto creado correctamente!!");
                    } else {
                        System.out.println("Error: La ciudad " + id_ciudad + " no existe.");
                    }

                    break;
                case 2:
                    System.out.println("Ingresa el id del Aeropuerto a actualizar:");
                    String id_update = sc.next();

                    System.out.println("Nuevo nombre para Aeropuerto");
                    String name_update = sc.next();

                    System.out.println("Nuevo id de ciudad: ");
                    String idc_update = sc.next();

                    Airport airport2 = new Airport(id_update, name_update, idc_update);
                    airportService.updateAirport(airport2);
                    break;
                case 3:
                    System.out.println("Ingresa el ID del Aeropuerto a buscar: ");
                    String findID = sc.next();

                    Optional<Airport> airports = airportService.findAirportById(findID);
                    airports.ifPresentOrElse(
                            a -> System.out.println("ID: " + a.getId_aeropuerto() + ", Nombre: "
                                    + a.getNombre_aeropuerto() + ", Id ciudad: " + a.getId_ciudad()),
                            () -> System.out.println("No se encuntra ese aeropuerto"));
                    break;
                case 4:
                    System.out.println("Ingresa el ID de el Aeropuerto a eliminar");
                    String deleteID = sc.next();
                    airportService.deleteAirport(deleteID);
                    break;
                case 5:
                    System.out.println("AEROPUERTOS");
                    airportService.findAllAirports().forEach(la -> {
                        System.out.println("ID: " + la.getId_aeropuerto() + ", Nombre: " + la.getNombre_aeropuerto()
                                + ", Id_ciudad: " + la.getId_ciudad());
                    });
                    break;
                case 6:
                    bandera = false;
                    System.out.println("Volviendo al menu principal... Adios");
                    break;
                default:
                    System.out.println("Opcion invalida. Intentalo de nuevo");
                    break;
            }
        }
    }
}
