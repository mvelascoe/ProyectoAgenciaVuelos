package com.proyectojava;

import com.proyectojava.cities.adapters.in.CitiesConsoleAdapter;
import com.proyectojava.cities.adapters.out.CitiesMySQLRepository;
import com.proyectojava.cities.application.CitiesService;
import com.proyectojava.country.adapters.in.CountryConsoleAdapter;
import com.proyectojava.country.adapters.out.CountryMySQLRepository;
import com.proyectojava.country.application.CountryService;
import com.proyectojava.documenttype.adapters.in.DocumenttypeConsoleAdapter;
import com.proyectojava.documenttype.adapters.out.DocumenttypeMySQLRepository;
import com.proyectojava.documenttype.application.DocumenttypeService;
import com.proyectojava.manufacturer.adapters.in.ManufacturerConsoleAdapter;
import com.proyectojava.manufacturer.adapters.out.ManufacturerMySQLRepository;
import com.proyectojava.manufacturer.application.ManufacturerService;

public class Main {
    public static void main(String[] args) {
        // Configuración de la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/Vuelos_globales";
        String user = "root";
        String password = "MVE11feb";

        /*CitiesMySQLRepository sqlCities = new CitiesMySQLRepository(url, user, password);
        CitiesService cs = new CitiesService(sqlCities);
        CitiesConsoleAdapter console = new CitiesConsoleAdapter(cs);*/

        /*DocumenttypeMySQLRepository sqlDocumenttype = new DocumenttypeMySQLRepository(url, user, password);
        DocumenttypeService cs = new DocumenttypeService(sqlDocumenttype);
        DocumenttypeConsoleAdapter console = new DocumenttypeConsoleAdapter(cs);*/

        /*CountryMySQLRepository sqlCountry = new CountryMySQLRepository(url, user, password);
        CountryService cs1 = new CountryService(sqlCountry);
        CountryConsoleAdapter console = new  CountryConsoleAdapter(cs1);
        */

        ManufacturerMySQLRepository sqlManufacturer = new ManufacturerMySQLRepository(url, user, password);
        ManufacturerService cs = new ManufacturerService(sqlManufacturer);
        ManufacturerConsoleAdapter console = new ManufacturerConsoleAdapter(cs);

        console.start();

    }
}
