package com.proyectojava.country.adapters.out;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.proyectojava.country.domain.models.Country;
import com.proyectojava.country.infrastructure.CountryRepository;;

public class CountryMySQLRepository implements CountryRepository{
    private final String url;
    private final String user;
    private final String password;

    public CountryMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Country country){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO country (id_pais,nombre_pais) VALUES(?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1,country.getId_pais());
                statement.setString(2, country.getNombre_pais());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Country country){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE country SET id_pais = ?,nombre_pais = ?WHERE id_pais = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, country.getId_pais());
                statement.setString(2,country.getNombre_pais());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Country>findById(String id_pais){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_pais,nombre_pais FROM country WHERE id_pais = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id_pais);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Country pais = new Country(
                                resultSet.getString("id_pais"),
                                resultSet.getString("nombre_pais"));
                        return Optional.of(pais);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(String id_pais){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM country WHERE id_pais = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "id_pais");
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Country> findAll(){
        List<Country> paises = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_ciudad,nombre_ciudad,id_pais FROM country";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Country pais = new Country(
                            resultSet.getString("id_pais"),
                            resultSet.getString("nombre_ciudad"));
                            paises.add(pais);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paises;
    }
}
