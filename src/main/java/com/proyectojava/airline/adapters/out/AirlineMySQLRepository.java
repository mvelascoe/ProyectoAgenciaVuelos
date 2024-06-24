package com.proyectojava.airline.adapters.out;

import com.proyectojava.airline.domain.models.Airline;
import com.proyectojava.airline.infrastructure.AirlineRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AirlineMySQLRepository implements AirlineRepository {
    private final String url;
    private final String user;
    private final String password;

    public AirlineMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Airline airline) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO airline (nombre_aerolinea) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, airline.getNombre_aerolinea());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Airline airline) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE airline SET nombre_aerolinea = ? WHERE id_aerolinea = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, airline.getNombre_aerolinea());
                statement.setInt(2, airline.getId_aerolinea());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Airline> findById(int id_aerolinea) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_aerolinea,nombre_aerolinea FROM airline WHERE id_aerolinea = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_aerolinea);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Airline airline = new Airline(
                                resultSet.getInt("id_aerolinea"),
                                resultSet.getString("nombre_aerolinea"));
                        return Optional.of(airline);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(int id_aerolinea) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM airline WHERE id_aerolinea = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_aerolinea);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Airline> findAll() {
        List<Airline> airlines = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_aerolinea,nombre_aerolinea FROM airline";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Airline airline = new Airline(
                            resultSet.getInt("id_aerolinea"),
                            resultSet.getString("nombre_aerolinea"));
                    airlines.add(airline);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airlines;
    }
}
