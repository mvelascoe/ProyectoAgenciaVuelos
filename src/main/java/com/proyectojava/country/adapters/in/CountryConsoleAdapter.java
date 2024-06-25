package com.proyectojava.country.adapters.in;

import com.proyectojava.country.application.CountryService;
import com.proyectojava.country.domain.models.Country;
import com.proyectojava.utility.Validations;

import java.util.Optional;
import java.util.Scanner;

public class CountryConsoleAdapter {
    private final CountryService countryService;
    private final Scanner scanner;
    private final Validations validations;

    public CountryConsoleAdapter(CountryService countryService) {
        this.countryService = countryService;
        this.scanner = new Scanner(System.in);
        this.validations = new Validations();
    }

    public void start() {
        while (true) {
            menuPais();
            int choice = validations.validarInt("Seleccione una opción: ");

            switch (choice) {
                case 1:
                    createCountry();
                    break;

                case 2:
                    updateCountry();
                    break;

                case 3:
                    findCountryById();
                    break;

                case 4:
                    deleteCountry();
                    break;

                case 5:
                    listAllCountries();
                    break;

                case 6:
                    exit();
                    break;

                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }
    }

    private void menuPais() {
        System.out.println("1. Crear País");
        System.out.println("2. Actualizar País");
        System.out.println("3. Buscar País por ID");
        System.out.println("4. Eliminar País");
        System.out.println("5. Listar todos los Países");
        System.out.println("6. Salir");
    }

    private void createCountry() {
        String createId = validations.caracteres("Ingrese el ID del país: ", 5);
        String createName = validations.campObligatorio("Ingrese el nombre del país: ");
        Country newCountry = new Country(createId, createName);
        countryService.createCountry(newCountry);
        System.out.println("País creado exitosamente.");
    }

    private void updateCountry() {
        String updateId = validations.caracteres("Ingrese el ID del país a actualizar: ", 5);
        String updateName = validations.campObligatorio("Ingrese el nuevo nombre: ");
        Country updatedCountry = new Country(updateId, updateName);
        countryService.updateCountry(updatedCountry);
        System.out.println("País actualizado exitosamente.");
    }

    private void findCountryById() {
        String findId = validations.caracteres("Ingrese el ID del país a buscar: ", 5);

        Optional<Country> country = countryService.findCityById(findId);
        country.ifPresentOrElse(
                c -> System.out.println("ID: " + c.getId_pais() + ", Nombre: " + c.getNombre_pais()),
                () -> System.out.println("País no encontrado")
        );
    }

    private void deleteCountry() {
        String deleteId = validations.caracteres("Ingrese el ID del país a eliminar: ", 5);
        countryService.deleteCity(deleteId);
        System.out.println("País eliminado exitosamente.");
    }

    private void listAllCountries() {
        countryService.findAllCountrys().forEach(c -> {
            System.out.println("ID: " + c.getId_pais() + ", Nombre: " + c.getNombre_pais());
        });
    }

    private void exit() {
        scanner.close();
        System.out.println("Saliendo del programa...");
        System.exit(0);
    }
}
