package com.proyectojava.cities.adapters.in;

import com.proyectojava.cities.application.CitiesService;
import com.proyectojava.cities.domain.models.Cities;
import com.proyectojava.country.domain.models.Country;
import com.proyectojava.utility.Validations;

import java.util.Optional;
import java.util.Scanner;

public class CitiesConsoleAdapter {
    private final CitiesService citiesService;
    private final Scanner scanner;
    private final Validations validations;

    public CitiesConsoleAdapter(CitiesService citiesService) {
        this.citiesService = citiesService;
        this.scanner = new Scanner(System.in);
        this.validations = new Validations();
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = validations.validarInt("Seleccione una opción: ");

            switch (choice) {
                case 1:
                    createCity();
                    break;

                case 2:
                    updateCity();
                    break;

                case 3:
                    findCityById();
                    break;

                case 4:
                    deleteCity();
                    break;

                case 5:
                    listAllCities();
                    break;

                case 6:
                    exit();
                    break;

                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("1. Crear Ciudad");
        System.out.println("2. Actualizar Ciudad");
        System.out.println("3. Buscar Ciudad por ID");
        System.out.println("4. Eliminar Ciudad");
        System.out.println("5. Listar todas las ciudades");
        System.out.println("6. Salir");
    }

    private void createCity() {
        String createId = validations.caracteres("Ingrese el ID de la ciudad: ", 5);
        String createName = validations.campObligatorio("Ingrese el nombre de la ciudad: ");

        // Obtener y validar el ID del país
        String createCountryId = validations.caracteres("Ingrese el ID del país: ", 5);

        // Buscar el país por su ID
        Optional<Country> optionalCountry = citiesService.findCountryById(createCountryId);

        if (optionalCountry.isPresent()) {
            // Si el país existe, crear la nueva ciudad
            Cities newCity = new Cities(createId, createName, createCountryId);
            citiesService.createCity(newCity);
            System.out.println("Ciudad creada exitosamente.");
        } else {
            // Si el país no existe, mostrar un mensaje de error
            System.out.println("Error: El país con ID " + createCountryId + " no existe.");
        }
    }

    private void updateCity() {
        String updateId = validations.caracteres("Ingrese el ID de la ciudad a actualizar: ", 5);
        String updateName = validations.campObligatorio("Ingrese el nuevo nombre: ");
        String updateCountryId = validations.caracteres("Ingrese el ID del país: ", 5);

        Cities updatedCity = new Cities(updateId, updateName, updateCountryId);
        citiesService.updateCity(updatedCity);
        System.out.println("Ciudad actualizada exitosamente.");
    }

    private void findCityById() {
        String findId = validations.caracteres("Ingrese el ID de la ciudad a buscar: ", 5);

        Optional<Cities> city = citiesService.getCityById(findId);
        city.ifPresentOrElse(
                c -> System.out.println("ID: " + c.getId_ciudad() + ", Nombre: " + c.getNombre_ciudad() + ", ID País: "
                        + c.getId_pais()),
                () -> System.out.println("Ciudad no encontrada"));
    }

    private void deleteCity() {
        String deleteId = validations.caracteres("Ingrese el ID de la ciudad a eliminar: ", 5);
        citiesService.deleteCity(deleteId);
        System.out.println("Ciudad eliminada exitosamente.");
    }

    private void listAllCities() {
        citiesService.getAllCities().forEach(c -> {
            System.out.println(
                    "ID: " + c.getId_ciudad() + ", Nombre: " + c.getNombre_ciudad() + ", ID País: " + c.getId_pais());
        });
    }

    private void exit() {
        
        System.out.println("Saliendo del programa...");
        System.exit(0);
    }
}
