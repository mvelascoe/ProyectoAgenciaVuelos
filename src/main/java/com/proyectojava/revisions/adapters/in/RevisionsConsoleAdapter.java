package com.proyectojava.revisions.adapters.in;

import com.proyectojava.revisions.application.RevisionsService;
import com.proyectojava.revisions.domain.models.Revisions;
import com.proyectojava.utility.Validations;

import java.sql.Date;
import java.util.Optional;
import java.util.Scanner;

public class RevisionsConsoleAdapter {
    private final RevisionsService revisionsService;
    private final Scanner scanner;
    private final Validations validations;

    public RevisionsConsoleAdapter(RevisionsService revisionsService) {
        this.revisionsService = revisionsService;
        this.scanner = new Scanner(System.in);
        this.validations = new Validations();
    }

    public void start() {
        while (true) {
            menuRevisions();
            int choice = validations.validarInt("Seleccione una opción: ");

            switch (choice) {
                case 1:
                    createRevision();
                    break;

                case 2:
                    updateRevision();
                    break;

                case 3:
                    findRevisionById();
                    break;

                case 4:
                    deleteRevision();
                    break;

                case 5:
                    listAllRevisions();
                    break;

                case 6:
                    exit();
                    break;

                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }
    }

    private void menuRevisions() {
        System.out.println("1. Crear Revisión");
        System.out.println("2. Actualizar Revisión");
        System.out.println("3. Buscar Revisión por ID");
        System.out.println("4. Eliminar Revisión");
        System.out.println("5. Listar todas las Revisiones");
        System.out.println("6. Salir");
    }

    private void createRevision() {
        Date fechaRevision = validations.validarFecha("Ingrese la fecha de revisión (YYYY-MM-DD): ");
        int idAvion = validations.validarInt("Ingrese el ID del avión: ");
        Revisions newRevision = new Revisions(0, fechaRevision, idAvion);
        revisionsService.createRevision(newRevision);
        System.out.println("Revisión creada exitosamente.");
    }

    private void updateRevision() {
        int idRevision = validations.validarInt("Ingrese el ID de la revisión a actualizar: ");
        Date fechaRevision = validations.validarFecha("Ingrese la nueva fecha de revisión (YYYY-MM-DD): ");
        int idAvion = validations.validarInt("Ingrese el nuevo ID del avión: ");
        Revisions updatedRevision = new Revisions(idRevision, fechaRevision, idAvion);
        revisionsService.updateRevision(updatedRevision);
        System.out.println("Revisión actualizada exitosamente.");
    }

    private void findRevisionById() {
        int idRevision = validations.validarInt("Ingrese el ID de la revisión a buscar: ");
        Optional<Revisions> revision = revisionsService.getRevisionById(idRevision);
        revision.ifPresentOrElse(
                r -> System.out.println("ID: " + r.getId_revision() + ", Fecha: " + r.getFecha_revision() + ", ID Avión: " + r.getId_avion()),
                () -> System.out.println("Revisión no encontrada")
        );
    }

    private void deleteRevision() {
        int idRevision = validations.validarInt("Ingrese el ID de la revisión a eliminar: ");
        revisionsService.deleteRevision(idRevision);
        System.out.println("Revisión eliminada exitosamente.");
    }

    private void listAllRevisions() {
        revisionsService.getAllRevisions().forEach(r -> {
            System.out.println("ID: " + r.getId_revision() + ", Fecha: " + r.getFecha_revision() + ", ID Avión: " + r.getId_avion());
        });
    }

    private void exit() {
        scanner.close();
        System.out.println("Saliendo del programa...");
        System.exit(0);
    }
}

