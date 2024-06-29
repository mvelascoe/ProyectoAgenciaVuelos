package com.proyectojava.flightdetails.adapters.out;

import com.proyectojava.flightdetails.domain.models.Pasajeros;
import com.proyectojava.flightdetails.infrastructure.PasajerosRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PasajerosMySQLRepository implements PasajerosRepository {
    private final String url;
    private final String user;
    private final String password;

    public PasajerosMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Pasajeros pasajero) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO flight_booking_details (id_trip, id_cliente, id_asiento) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, pasajero.getId_trip());
                statement.setString(2, pasajero.getId_cliente());
                statement.setInt(3, pasajero.getId_asiento());
                statement.executeUpdate();

                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    pasajero.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Pasajeros pasajero) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE flight_booking_details SET id_trip = ?, id_cliente = ?, id_asiento = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, pasajero.getId_trip());
                statement.setString(2, pasajero.getId_cliente());
                statement.setInt(3, pasajero.getId_asiento());
                statement.setInt(4, pasajero.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Pasajeros> findById(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_trip, id_cliente, id_asiento FROM flight_booking_details WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Pasajeros pasajero = new Pasajeros(
                                id,
                                resultSet.getInt("id_trip"),
                                resultSet.getString("id_cliente"),
                                resultSet.getInt("id_asiento"));
                        return Optional.of(pasajero);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM flight_booking_details WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Pasajeros> findAll() {
        List<Pasajeros> pasajerosList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id, id_trip, id_cliente, id_asiento FROM flight_booking_details";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Pasajeros pasajero = new Pasajeros(
                            resultSet.getInt("id"),
                            resultSet.getInt("id_trip"),
                            resultSet.getString("id_cliente"),
                            resultSet.getInt("id_asiento"));
                    pasajerosList.add(pasajero);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pasajerosList;
    }
}