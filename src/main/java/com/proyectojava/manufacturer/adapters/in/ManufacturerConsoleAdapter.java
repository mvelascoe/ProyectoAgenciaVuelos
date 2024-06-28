package com.proyectojava.manufacturer.adapters.in;

import com.proyectojava.manufacturer.application.ManufacturerService;
import com.proyectojava.manufacturer.domain.models.Manufacturer;
import com.proyectojava.utility.Validations;
import com.proyectojava.generalConsole.in.GeneralConsoleAdapter;

import java.text.ParseException;
import java.util.Optional;
import java.util.Scanner;

public class ManufacturerConsoleAdapter {
    private final ManufacturerService manufacturerService;
    private final Scanner scanner;
    private final Validations validations;

    public ManufacturerConsoleAdapter(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
        this.scanner = new Scanner(System.in);
        this.validations = new Validations();
    }

    public void start() throws ParseException {
        GeneralConsoleAdapter MP = new GeneralConsoleAdapter();
        while (true) {
            menuManufactura();
            int choice = validations.validarInt("Seleccione una opción: ");

            switch (choice) {
                case 1:
                    createManufacturer();
                    break;

                case 2:
                    updateManufacturer();
                    break;

                case 3:
                    findManufacturerById();
                    break;

                case 4:
                    deleteManufacturer();
                    break;

                case 5:
                    listAllManufacturers();
                    break;

                case 6:
                    exit();
                    MP.showMainMenu();
                    break;

                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }
    }

    private void menuManufactura() {
        System.out.println("1. Crear Manufactura");
        System.out.println("2. Actualizar Manufactura");
        System.out.println("3. Buscar Manufactura por ID");
        System.out.println("4. Eliminar Manufactura");
        System.out.println("5. Listar todas las Manufacturas");
        System.out.println("6. Salir");
    }

    private void createManufacturer() {
        String createName = validations.campObligatorio("Ingrese el nombre de la manufactura: ");
        Manufacturer newManufacturer = new Manufacturer(0, createName); // ID será autogenerado
        manufacturerService.createManufacturer(newManufacturer);
        System.out.println("\n*********************************");
        System.out.println("* Manufactura creada exitosamente. *");
        System.out.println("*********************************\n");
    }

    private void updateManufacturer() {
        int updateId = validations.validarInt("Ingrese el ID de la manufactura a actualizar: ");
        String updateName = validations.campObligatorio("Ingrese el nuevo nombre: ");
        Manufacturer updatedManufacturer = new Manufacturer(updateId, updateName);
        manufacturerService.updateManufacturer(updatedManufacturer);
        System.out.println("\n**************************************");
        System.out.println("* Manufactura actualizada exitosamente. *");
        System.out.println("****************************************\n");
    }

    private void findManufacturerById() {
        int findId = validations.validarInt("Ingrese el ID de la manufactura a buscar: ");

        Optional<Manufacturer> manufacturer = manufacturerService.getManufacturerById(findId);
        manufacturer.ifPresentOrElse(
                m -> System.out.println("ID: " + m.getId_manufactura() + ", Nombre: " + m.getNombre_manufactura()),
                () -> System.out.println("Manufactura con id " + findId + " no encontrada"));
    }

    private void deleteManufacturer() {
        int deleteId = validations.validarInt("Ingrese el ID de la manufactura a eliminar: ");
        manufacturerService.deleteManufacturer(deleteId);
        System.out.println("\n*********************************");
        System.out.println("Manufactura eliminada exitosamente.");
        System.out.println("*********************************\n");
    }

    private void listAllManufacturers() {
        System.out.println("##   ##    ###    ##   ##  ##   ##   #######   ###      ####    # ##### ##   ##  ######     ###     #####   ");
        System.out.println("### ###   ## ##   ###  ##  ##   ##    ##   #  ## ##    ##  ##  ## ## ## ##   ##   ##  ##   ## ##   ##   ##  ");
        System.out.println("#######  ##   ##  #### ##  ##   ##    ##     ##   ##  ##          ##    ##   ##   ##  ##  ##   ##  ##       ");
        System.out.println("## # ##  ##   ##  #######  ##   ##    ####   ##   ##  ##          ##    ##   ##   #####   ##   ##   #####   ");
        System.out.println("##   ##  #######  ## ####  ##   ##    ##     #######  ##          ##    ##   ##   ## ##   #######       ##  ");
        System.out.println("##   ##  ##   ##  ##  ###  ##   ##    ##     ##   ##   ##  ##     ##    ##   ##   ## ##   ##   ##  ##   ##  ");
        System.out.println("### ###  ##   ##  ##   ##   #####    ####    ##   ##    ####     ####    #####   #### ##  ##   ##   #####   ");

        manufacturerService.getAllManufacturers().forEach(m -> {
            System.out.println("ID: " + m.getId_manufactura() + ", Nombre: " + m.getNombre_manufactura());
        });
    }

    private void exit() {
        System.out.println("Volviendo al menu principal");
    }
}
