package com.proyectojava.airline.adapters.in;

import java.util.Scanner;

import com.proyectojava.airline.application.AirlineService;

public class AirlineConsoleAdapter {
    private final AirlineService airlineService;

    public AirlineConsoleAdapter(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    public void startAirline(){
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("1. Crear aerolinea\2. \n2. Actualizar informacion de aerolinea\n3. Buscar aerolinea\n4. Eliminar aerolinea\n5. Listar todas las aerolineas\n6. Volver\n\n");
            System.out.println("Ingresa una opcion");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                System.out.println("Volviendo al menu principal... Adios");
                    break;
                default:
                    break;
            }


        }
    }
}
