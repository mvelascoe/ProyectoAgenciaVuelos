package com.proyectojava.airport.adapters.out;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.proyectojava.airport.domain.models.Airport;
import com.proyectojava.airport.infrastructure.AirportRepository;

public class AirportMySQLRepository implements AirportRepository{
    private final String url;
    private final String user;
    private final String password;

    public AirportMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Airport airport) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO airport (id_aeropuerto,nombre_aeropuerto,id_ciudad) VALUES (?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1,airport.getId_aeropuerto());
                statement.setString(2,airport.getNombre_aeropuerto());
                statement.setString(3, airport.getId_ciudad());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Airport airport) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE airport SET id_aeropuerto = ?,nombre_aeropuerto = ?,id_ciudad = ? WHERE id_aeropuerto = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "id_aeropuerto");
                statement.setString(2, "nombre_aeropuerto");
                statement.setString(3, "id_ciudad");
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Airport> findById(String id_aeropuerto) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT  id_aeropuerto,nombre_aeropuerto,id_ciudad FROM airport WHERE id_aeropuerto = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id_aeropuerto);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Airport airport = new Airport(
                                resultSet.getString("id_aeropuerto"),
                                resultSet.getString("nombre_aeropuerto"),
                                resultSet.getString("id_ciudad"));
                        return Optional.of(airport);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(String id_aeropuerto) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM airport WHERE id_aeropuerto = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id_aeropuerto);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Airport> findAll() {
        List<Airport> airports = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_aeropuerto,nombre_aeropuerto,id_ciudad FROM airport";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Airport airport = new Airport(
                        resultSet.getString("id_aeropuerto"),
                        resultSet.getString("nombre_aeropuerto"),
                        resultSet.getString("id_ciudad"));
                    airports.add(airport);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airports;
    }

}
