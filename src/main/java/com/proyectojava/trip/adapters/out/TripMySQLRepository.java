package com.proyectojava.trip.adapters.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.proyectojava.trip.domain.models.Trip;
import com.proyectojava.trip.infrastructure.TripRepository;

public class TripMySQLRepository implements TripRepository{
    private final String url;
    private final String user;
    private final String password;

    public TripMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Trip trip) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO trip (precio, lugar_ida, lugar_llegada) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setDouble(1, trip.getPrecio());
                statement.setString(2, trip.getLugar_ida());
                statement.setString(3, trip.getLugar_llegada());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Trip trip) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE trip SET precio = ?, lugar_ida = ?, lugar_llegada = ? WHERE id_trip = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setDouble(1, trip.getPrecio());
                statement.setString(2, trip.getLugar_ida());
                statement.setString(3, trip.getLugar_llegada());
                statement.setInt(4, trip.getId_trip());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Trip> findById(int id_trip) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id_trip,precio,lugar_ida,lugar_llegada FROM trip WHERE id_trip = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id_trip);
                try (ResultSet resultSet = statement.executeQuery()){
                    if (resultSet.next()){
                        Trip trip = new Trip(
                            resultSet.getInt("id_trip"),
                            resultSet.getDouble("precio"),
                            resultSet.getString("lugar_ida"),
                            resultSet.getString("lugar_llegada")
                        );
                        return Optional.of(trip);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    

    @Override
    public void delete(int id_trip) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "DELETE FROM trip WHERE id_trip = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id_trip);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Trip> findAll() {
        List<Trip> trips = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id_trip, precio, lugar_ida, lugar_llegada FROM trip";
            try (PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()){
                    Trip trip = new Trip(
                        resultSet.getInt("id_trip"),
                        resultSet.getDouble("precio"),
                        resultSet.getString("lugar_ida"),
                        resultSet.getString("lugar_llegada")
                    );
                    trips.add(trip);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return trips;
    }
}