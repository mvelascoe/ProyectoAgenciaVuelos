package com.proyectojava.gate.adapters.in;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.proyectojava.airport.domain.models.Airport;
import com.proyectojava.gate.application.GateService;
import com.proyectojava.gate.domain.models.Gate;
import com.proyectojava.generalConsole.in.GeneralConsoleAdapter;

public class GateConsoleAdapter {
    private final GateService gateService;

    public GateConsoleAdapter(GateService gateService) {
        this.gateService = gateService;
    }

    public void startGate() throws ParseException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            GeneralConsoleAdapter MP = new GeneralConsoleAdapter();
            System.out.println(
                    "1. Crear puerta \n2. Actualizar informacion de puerta\n3. Buscar puerta\n4. Eliminar puerta\n5. Listar todas las puertas\n6. Volver\n\n");
            System.out.println("Ingresa una opcion");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el numero de puerta");
                    int numP = sc.nextInt();

                    List<Airport> aeropuertos = gateService.findAllAirports();

                    System.out.println("---------------------------------------");
                    System.out.printf("%-10s %-30s%n", "ID", "Nombre");
                    System.out.println("---------------------------------------");

                    for(Airport air : aeropuertos){
                        System.out.printf("%-10s %-30s", air.getId_aeropuerto(),air.getNombre_aeropuerto());
                    } 

                    System.out.println("\nIngresa el id del aeropuerto al que pertenece la puerta");
                    String numA = sc.next();

                    Optional<Airport> optionalAirport = gateService.findAirport(numA);
                    if (optionalAirport.isPresent()) {
                        Gate gate = new Gate(numP, numA);
                        gateService.createGate(gate);
                        System.out.println("\n*********************************************");
                        System.out.println("*    Puerta de aerpuerto creada exitosamente   *");
                        System.out.println("***********************************************\n");
                    } else {
                        System.out.println("Aeropuerto con id " + numA + " no existe.");
                    }

                    break;
                case 2:
                    System.out.println("Ingresa el ID de la puerta a actualizar: ");
                    int upID = sc.nextInt();

                    System.out.println("Ingresa nuevo numero de puerta");
                    int upNu = sc.nextInt();

                    System.out.println("Ingresa el nuevo ID del aeropuerto al que pertenece la puerta: ");
                    String upNA = sc.next();

                    Gate upGate = new Gate(upID, upNu, upNA);
                    gateService.updateGate(upGate);

                    System.out.println("\n*********************************************");
                    System.out.println("*  Puerta de aerpuerto actualizada exitosamente *");
                    System.out.println("***********************************************\n");
                    break;
                case 3:
                    System.out.println("Ingresa el ID de la puerta a buscar: ");
                    int findId = sc.nextInt();

                    Optional<Gate> gates = gateService.getGateById(findId);
                    gates.ifPresentOrElse(
                            g -> System.out.println("ID: " + g.getId_puerta() + ", Numero puerta: "
                                    + g.getNumero_puerta() + ", ID del aeropuerto: " + g.getId_aeropuerto()),
                            () -> System.out.println("No hay puertas con este id" + findId));
                    break;
                case 4:
                    System.out.println("Ingresa el id de la puerta a eliminar: ");
                    int deleteID = sc.nextInt();
                    gateService.deleteGate(deleteID);
                    System.out.println("\n*********************************************");
                    System.out.println("*  Puerta de aerpuerto eliminada exitosamente *");
                    System.out.println("***********************************************\n");
                    break;
                case 5:
                    System.out.println("######   ##   ##  #######  ######    # #####   ###     #####   ");
                    System.out.println(" ##  ##  ##   ##   ##   #   ##  ##  ## ## ##  ## ##   ##   ##  ");
                    System.out.println(" ##  ##  ##   ##   ##       ##  ##     ##    ##   ##  ##       ");
                    System.out.println(" #####   ##   ##   ####     #####      ##    ##   ##   #####   ");
                    System.out.println(" ##      ##   ##   ##       ## ##      ##    #######       ##  ");
                    System.out.println(" ##      ##   ##   ##   #   ## ##      ##    ##   ##  ##   ##  ");
                    System.out.println("####      #####   #######  #### ##    ####   ##   ##   #####   ");

                    gateService.getAllGates().forEach(g -> {
                        System.out.println("ID: " + g.getId_puerta() + ", Numero de puerta: " + g.getNumero_puerta()
                                + ", ID del aeropuerto: " + g.getId_aeropuerto());
                    });
                    break;
                case 6:
                    System.out.println("Volviendo al menu principal... Byee");
                    MP.showMainMenu();
                    break;
                default:
                    System.out.println("Ingresa solo opciones validas");
                    break;
            }
        }
    }
}
