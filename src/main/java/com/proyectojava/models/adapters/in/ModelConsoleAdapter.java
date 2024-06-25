package com.proyectojava.models.adapters.in;

import com.proyectojava.models.application.ModelService;
import com.proyectojava.models.domain.models.Model;
import com.proyectojava.utility.Validations;

import java.util.Optional;
import java.util.Scanner;

public class ModelConsoleAdapter {
    private final ModelService modelService;
    private final Scanner scanner;
    private final Validations validations;

    public ModelConsoleAdapter(ModelService modelService) {
        this.modelService = modelService;
        this.scanner = new Scanner(System.in);
        this.validations = new Validations();
    }

    public void start() {
        while (true) {
            menuModelo();
            int choice = validations.validarInt("Seleccione una opción: ");

            switch (choice) {
                case 1:
                    createModel();
                    break;

                case 2:
                    updateModel();
                    break;

                case 3:
                    findModelById();
                    break;

                case 4:
                    deleteModel();
                    break;

                case 5:
                    listAllModels();
                    break;

                case 6:
                    exit();
                    break;

                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }
    }

    private void menuModelo() {
        System.out.println("1. Crear Modelo");
        System.out.println("2. Actualizar Modelo");
        System.out.println("3. Buscar Modelo por ID");
        System.out.println("4. Eliminar Modelo");
        System.out.println("5. Listar todos los Modelos");
        System.out.println("6. Salir");
    }

    private void createModel() {
        String createName = validations.campObligatorio("Ingrese el nombre del modelo: ");
        int createManufacturaId = validations.validarInt("Ingrese el ID de la manufactura: ");
        Model newModel = new Model(0, createName, createManufacturaId);
        modelService.createModel(newModel);
        System.out.println("Modelo creado exitosamente.");
    }

    private void updateModel() {
        int updateId = validations.validarInt("Ingrese el ID del modelo a actualizar: ");
        String updateName = validations.campObligatorio("Ingrese el nuevo nombre: ");
        int updateManufacturaId = validations.validarInt("Ingrese el nuevo ID de la manufactura: ");
        Model updatedModel = new Model(updateId, updateName, updateManufacturaId);
        modelService.updateModel(updatedModel);
        System.out.println("Modelo actualizado exitosamente.");
    }

    private void findModelById() {
        int findId = validations.validarInt("Ingrese el ID del modelo a buscar: ");

        Optional<Model> model = modelService.getModelById(findId);
        model.ifPresentOrElse(
                m -> System.out.println("ID: " + m.getId_modelo() + ", Nombre: " + m.getNombre_modelo() + ", ID Manufactura: " + m.getId_manufactura()),
                () -> System.out.println("Modelo no encontrado")
        );
    }

    private void deleteModel() {
        int deleteId = validations.validarInt("Ingrese el ID del modelo a eliminar: ");
        modelService.deleteModel(deleteId);
        System.out.println("Modelo eliminado exitosamente.");
    }

    private void listAllModels() {
        modelService.getAllModels().forEach(m -> {
            System.out.println("ID: " + m.getId_modelo() + ", Nombre: " + m.getNombre_modelo() + ", ID Manufactura: " + m.getId_manufactura());
        });
    }

    private void exit() {
        scanner.close();
        System.out.println("Saliendo del programa...");
        System.exit(0);
    }
}
