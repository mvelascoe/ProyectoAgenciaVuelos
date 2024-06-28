package com.proyectojava.plane.adapters.in;

import com.proyectojava.plane.application.PlaneService;
import com.proyectojava.plane.domain.models.Plane;
import com.proyectojava.statusA.domain.models.Status;
import com.proyectojava.utility.Validations;
import com.proyectojava.generalConsole.in.GeneralConsoleAdapter;
import com.proyectojava.models.domain.models.Model;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PlaneConsoleAdapter {
    private final PlaneService planeService;
    private final Scanner scanner;
    private final Validations validations;

    public PlaneConsoleAdapter(PlaneService planeService) {
        this.planeService = planeService;
        this.scanner = new Scanner(System.in);
        this.validations = new Validations();
    }

    public void start() throws ParseException {
        GeneralConsoleAdapter MP = new GeneralConsoleAdapter();
        while (true) {
            menuPlane();
            int choice = validations.validarInt("Seleccione una opción: ");

            switch (choice) {
                case 1:
                    createPlane();
                    break;

                case 2:
                    updatePlane();
                    break;

                case 3:
                    findPlaneById();
                    break;

                case 4:
                    deletePlane();
                    break;

                case 5:
                    listAllPlanes();
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

    private void menuPlane() {
        System.out.println("1. Crear Avión");
        System.out.println("2. Actualizar Avión");
        System.out.println("3. Buscar Avión por ID");
        System.out.println("4. Eliminar Avión");
        System.out.println("5. Listar todos los Aviones");
        System.out.println("6. Salir");
    }

    private void createPlane() {
        String matricula = validations.campObligatorio("Ingrese la matrícula del avión: ");
        int capacidad = validations.validarInt("Ingrese la capacidad del avión: ");
        java.sql.Date fechaFabricacion = java.sql.Date
                .valueOf(validations.campObligatorio("Ingrese la fecha de fabricación (YYYY-MM-DD): "));

        List<Status> estados = planeService.getAllStatuses();
        System.out.println("-------------------------------");
        System.out.printf("%-10s", "ID_Estados");
        System.out.println("-------------------------------");

        for (Status estado : estados) {
            System.out.printf("%-10s", estado.getId_estado());
        }
        int idEstado = validations.validarInt("Ingrese el ID del estado del avión: ");

        Optional<Status> optionalStatus = planeService.getStatusById(idEstado);
        if (optionalStatus.isPresent()) {

            List<Model> modelos = planeService.getAllModels();
            System.out.println("-------------------------------");
            System.out.printf("%-10s", "ID_Modelos");
            System.out.println("-------------------------------");

            for (Model model : modelos) {
                System.out.printf("%-10s", model.getId_modelo());
            }

            int idModelo = validations.validarInt("Ingrese el ID del modelo del avión: ");

            Optional<Model> optionalModel = planeService.getModelById(idModelo);
            if (optionalModel.isPresent()) {
                Plane newPlane = new Plane(0, matricula, capacidad, fechaFabricacion, idEstado, idModelo);
                planeService.createPlane(newPlane);

                System.out.println("\n*******************************");
                System.out.println("*  Avion creado exitosamente.  *");
                System.out.println("*******************************\n");
            }

        } else {
            System.out.println("Error: Hay datos no existentes");
        }
    }

    private void updatePlane() {
        int idAvion = validations.validarInt("Ingrese el ID del avión a actualizar: ");
        String matricula = validations.campObligatorio("Ingrese la nueva matrícula: ");
        int capacidad = validations.validarInt("Ingrese la nueva capacidad: ");
        java.sql.Date fechaFabricacion = java.sql.Date
                .valueOf(validations.campObligatorio("Ingrese la nueva fecha de fabricación (YYYY-MM-DD): "));
        int idEstado = validations.validarInt("Ingrese el nuevo ID del estado: ");
        int idModelo = validations.validarInt("Ingrese el nuevo ID del modelo: ");

        Plane updatedPlane = new Plane(idAvion, matricula, capacidad, fechaFabricacion, idEstado, idModelo);
        planeService.updatePlane(updatedPlane);

        System.out.println("\n************************************");
        System.out.println("*   Avion actualizado exitosamente. *");
        System.out.println("************************************\n");

    }

    private void findPlaneById() {
        int idAvion = validations.validarInt("Ingrese el ID del avión a buscar: ");

        Optional<Plane> plane = planeService.getPlaneById(idAvion);
        plane.ifPresentOrElse(
                p -> System.out.println("ID: " + p.getId_avion() + ", Matrícula: " + p.getMatricula() + ", Capacidad: "
                        + p.getCapacidad() + ", Fecha de Fabricación: " + p.getFecha_fabricacion() + ", ID Estado: "
                        + p.getId_estado() + ", ID Modelo: " + p.getId_modelo()),
                () -> System.out.println("Avión no encontrado"));
    }

    private void deletePlane() {
        int idAvion = validations.validarInt("Ingrese el ID del avión a eliminar: ");
        planeService.deletePlane(idAvion);

        System.out.println("\n**********************************");
        System.out.println("*  Avion eliminado exitosamente.  *");
        System.out.println("**********************************\n");
    }

    private void listAllPlanes() {
        System.out.println("  ###    ##   ##   ######   #####   ##   ##  #######   #####   ");
        System.out.println(" ## ##   ##   ##     ##    ### ###  ###  ##   ##   #  ##   ##  ");
        System.out.println("##   ##  ##   ##     ##    ##   ##  #### ##   ##      ##       ");
        System.out.println("##   ##   ## ##      ##    ##   ##  #######   ####     #####   ");
        System.out.println("#######   ## ##      ##    ##   ##  ## ####   ##           ##  ");
        System.out.println("##   ##    ###       ##    ### ###  ##  ###   ##   #  ##   ##  ");
        System.out.println("##   ##    ###     ######   #####   ##   ##  #######   #####   ");

        planeService.getAllPlanes().forEach(p -> {
            System.out.println("ID: " + p.getId_avion() + ", Matrícula: " + p.getMatricula() + ", Capacidad: "
                    + p.getCapacidad() + ", Fecha de Fabricación: " + p.getFecha_fabricacion() + ", ID Estado: "
                    + p.getId_estado() + ", ID Modelo: " + p.getId_modelo());
        });
    }

    private void exit() {
        System.out.println("Volviendo al menu principal...");
    }

    
}
