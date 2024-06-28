package com.proyectojava.flightconnection.adapters.in;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import com.proyectojava.generalConsole.in.GeneralConsoleAdapter;
import com.proyectojava.airport.domain.models.Airport;
import com.proyectojava.flightconnection.application.FlightConnectionService;
import com.proyectojava.flightconnection.domain.models.FlightConnection;
import com.proyectojava.plane.domain.models.Plane;
import com.proyectojava.trip.domain.models.Trip;

public class FlightConnectionConsoleAdapter {
    private final FlightConnectionService flightConnectionService;

    public FlightConnectionConsoleAdapter(FlightConnectionService flightConnectionService) {
        this.flightConnectionService = flightConnectionService;
    }

    public void startFlightConnection() throws ParseException {
        Scanner sc = new Scanner(System.in);
        GeneralConsoleAdapter MP = new GeneralConsoleAdapter();
        while (true) {
            System.out.println(
                    "1. Crear conexion\n2. Actualizar informacion de conexion\n3. Buscar conexion\n4. Eliminar conexion\n5. Listar todas las conexions\n6. Volver\n\n");
            System.out.println("Ingresa una opcion");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa numero de la conexion: ");
                    String num_trayectoria = sc.next();

                    List<Trip> trips = flightConnectionService.getAllTripes();
                    System.out.println("-------------------------------");
                    System.out.printf("%-15s ", "ID_Vuelo");
                    System.out.println("-------------------------------");
                    for (Trip trip : trips) {
                        System.out.printf("%-15s", trip.getId_trip());
                    }

                    System.out.println("Ingresa el id del vuelo: ");
                    int id_trip = sc.nextInt();

                    Optional<Trip> optionalTrip = flightConnectionService.getTripById(id_trip);
                    System.out.println("-------------------------------");
                    System.out.printf("%-15s ", "ID_Avion");
                    System.out.println("-------------------------------");
                    if (optionalTrip.isPresent()) {

                        List<Plane> planes = flightConnectionService.getAllPlanes();
                        for (Plane plane : planes) {
                            System.out.printf("%-15s", plane.getId_avion());
                        }

                        System.out.println("Ingresa el id del avion: ");
                        int id_plane = sc.nextInt();

                        Optional<Plane> optionalPlane = flightConnectionService.getPlaneById(id_plane);
                        if (optionalPlane.isPresent()) {

                            List<Airport> airports = flightConnectionService.findAllAirports();
                            System.out.println("-------------------------------");
                            System.out.printf("%-15s ", "ID_Aeropuerto");
                            System.out.println("-------------------------------");

                            for (Airport air : airports) {
                                System.out.printf("%-15s", air.getId_aeropuerto());
                            }

                            System.out.println("Ingresa el id de aeropuerto: ");
                            String id_airport = sc.next();

                            Optional<Airport> optionalAeropuerto = flightConnectionService.findAirportById(id_airport);
                            if (optionalAeropuerto.isPresent()) {
                                FlightConnection connection = new FlightConnection(num_trayectoria, id_trip, id_plane,
                                        id_airport);
                                flightConnectionService.createConnection(connection);
                                System.out.println("\n**************************************");
                                System.out.println("*    Conexion creada exitosamente     *");
                                System.out.println("**************************************\n");
                            }
                        }
                    }else{
                        System.out.println("Error: Datos inexsistentes...");
                    }
                    break;
                case 2:
                    System.out.println("Ingresa el id de la conexion a actualizar: ");
                    int up_id = sc.nextInt();

                    System.out.println("Ingresa el nuevo numero de conexion: ");
                    String up_num_trayectoria = sc.next();

                    System.out.println("Ingresa el nuevo id del vuelo: ");
                    int up_id_trip = sc.nextInt();

                    System.out.println("Ingresa el nuevo id del avion: ");
                    int up_id_plane = sc.nextInt();

                    System.out.println("Ingresa el nuevo id del aeropuerto: ");
                    String up_id_airport = sc.next();

                    FlightConnection connection2 = new FlightConnection(up_id, up_num_trayectoria, up_id_trip,
                            up_id_plane, up_id_airport);
                    flightConnectionService.updateConnecttion(connection2);

                    System.out.println("\n*************************************");
                    System.out.println("* Conexion actualizada correctamente *");
                    System.out.println("*************************************\n");
                    break;
                case 3:
                    System.out.println("Ingresa el id de la conexion a buscar: ");
                    int findID = sc.nextInt();

                    Optional<FlightConnection> connection3 = flightConnectionService.findConnecttionById(findID);
                    connection3.ifPresentOrElse(
                            c -> System.out.println("Id: " + c.getId_trayectoria() + ", Numero de trayectoria: "
                                    + c.getTrayectoria_numero() + ", Id del vuelo: " + c.getId_trip()
                                    + ", Id del avion: " + c.getId_avion() + ", Id del aeropuerto: "
                                    + c.getId_aeropuerto()),
                            () -> System.out.println("No se encontro una trayectoria con el id " + findID));
                    break;
                case 4:
                    System.out.println("Ingresa el id de la conexion a eliminar: ");
                    int deleteId = sc.nextInt();

                    flightConnectionService.deleteConnecttion(deleteId);
                    System.out.println("\n*************************************");
                    System.out.println("* Conexion eliminada correctamente *");
                    System.out.println("*************************************\n");
                    break;
                case 5:
                    System.out.println("  ####    #####   ##   ##  #######  ###  ##   ######   #####   ##   ##  #######   #####   ");                    
                    System.out.println(" ##  ##  ### ###  ###  ##   ##   #  ###  ##     ##    ### ###  ###  ##   ##   #  ##   ##  ");
                    System.out.println("##       ##   ##  #### ##   ##       #####      ##    ##   ##  #### ##   ##      ##       ");                
                    System.out.println("##       ##   ##  #######   ####      ###       ##    ##   ##  #######   ####     #####   ");                
                    System.out.println("##       ##   ##  ## ####   ##       #####      ##    ##   ##  ## ####   ##           ##  ");                
                    System.out.println(" ##  ##  ### ###  ##  ###   ##   #  ##  ###     ##    ### ###  ##  ###   ##   #  ##   ##  ");                
                    System.out.println("  ####    #####   ##   ##  #######  ##  ###   ######   #####   ##   ##  #######   #####   ");

                    flightConnectionService.findAllConnecttions().forEach(cl -> {
                        System.out.println("Id: " + cl.getId_trayectoria() + ", Numero de trayectoria: "
                                + cl.getTrayectoria_numero() + ", Id del vuelo: " + cl.getId_trip() + ", Id del avion: "
                                + cl.getId_avion() + ", Id del aeropuerto: " + cl.getId_aeropuerto());
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
