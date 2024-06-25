package com.proyectojava.documenttype.adapters.in;

import com.proyectojava.documenttype.application.DocumenttypeService;
import com.proyectojava.documenttype.domain.models.Documenttype;
import com.proyectojava.utility.Validations;

import java.util.Optional;
import java.util.Scanner;

public class DocumenttypeConsoleAdapter {
    private final DocumenttypeService documenttypeService;
    private final Scanner scanner;
    private final Validations validations;

    public DocumenttypeConsoleAdapter(DocumenttypeService documenttypeService) {
        this.documenttypeService = documenttypeService;
        this.scanner = new Scanner(System.in);
        this.validations = new Validations();
    }

    public void start() {
        while (true) {
            menuDocumenttype();
            int choice = validations.validarInt("Seleccione una opción: ");

            switch (choice) {
                case 1:
                    createDocument();
                    break;

                case 2:
                    updateDocument();
                    break;

                case 3:
                    findDocumentById();
                    break;

                case 4:
                    deleteDocument();
                    break;

                case 5:
                    listAllDocuments();
                    break;

                case 6:
                    exit();
                    break;

                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }
    }

    private void menuDocumenttype() {
        System.out.println("1. Crear Tipo de Documento");
        System.out.println("2. Actualizar Tipo de Documento");
        System.out.println("3. Buscar Tipo de Documento por ID");
        System.out.println("4. Eliminar Tipo de Documento");
        System.out.println("5. Listar todos los Tipos de Documento");
        System.out.println("6. Salir");
    }

    private void createDocument() {
        int createId = validations.validarInt("Ingrese el ID del tipo de documento: ");
        String createName = validations.campObligatorio("Ingrese el nombre del tipo de documento: ");
        Documenttype newDocumenttype = new Documenttype(createId, createName);
        documenttypeService.createDocument(newDocumenttype);
        System.out.println("Tipo de documento creado exitosamente.");
    }

    private void updateDocument() {
        int updateId = validations.validarInt("Ingrese el ID del tipo de documento a actualizar: ");
        String updateName = validations.campObligatorio("Ingrese el nuevo nombre: ");
        Documenttype updatedDocumenttype = new Documenttype(updateId, updateName);
        documenttypeService.updateDocument(updatedDocumenttype);
        System.out.println("Tipo de documento actualizado exitosamente.");
    }

    private void findDocumentById() {
        int findId = validations.validarInt("Ingrese el ID del tipo de documento a buscar: ");

        Optional<Documenttype> documenttype = documenttypeService.findDocumentById(findId);
        documenttype.ifPresentOrElse(
                d -> System.out.println("ID: " + d.getId_documento() + ", Nombre: " + d.getNombre_documento()),
                () -> System.out.println("Tipo de documento no encontrado")
        );
    }

    private void deleteDocument() {
        int deleteId = validations.validarInt("Ingrese el ID del tipo de documento a eliminar: ");
        documenttypeService.deleteDocument(deleteId);
        System.out.println("Tipo de documento eliminado exitosamente.");
    }

    private void listAllDocuments() {
        documenttypeService.findAllDocument().forEach(d -> {
            System.out.println("ID: " + d.getId_documento() + ", Nombre: " + d.getNombre_documento());
        });
    }

    private void exit() {
        scanner.close();
        System.out.println("Saliendo del programa...");
        System.exit(0);
    }
}

