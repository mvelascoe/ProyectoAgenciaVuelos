package com.proyectojava.flightconnection.adapters.out;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.proyectojava.flightconnection.domain.models.FlightConnection;
import com.proyectojava.flightconnection.infrastructure.FlightConnectionRepository;

public class FlightConnectionMySQLRepository implements FlightConnectionRepository {
    private final String url;
    private final String user;
    private final String password;


    public FlightConnectionMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(FlightConnection flightConnection){
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "INSERT INTO flightconnection (trayectoria_numero,id_trip,id_avion,id_aeropuerto) VALUES (?,?,?,?,?)";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, flightConnection.getTrayectoria_numero());
                statement.setInt(2, flightConnection.getId_trip());
                statement.setInt(3, flightConnection.getId_avion());
                statement.setString(4, flightConnection.getId_aeropuerto());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(FlightConnection flightConnection){
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE flightconnection SET trayectoria_numero = ?,id_trip = ?,id_avion = ?,id_aeropuerto = ? WHERE id_trayectoria = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, flightConnection.getTrayectoria_numero());
                statement.setInt(2, flightConnection.getId_trip());
                statement.setInt(3, flightConnection.getId_avion());
                statement.setString(4, flightConnection.getId_aeropuerto());
                statement.setInt(5, flightConnection.getId_trayectoria());
                statement.executeUpdate();
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<FlightConnection> findById(int id_trayectoria){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_trayectoria,trayectoria_numero,id_trip,id_avion,id_aeropuerto FROM flightconnection WHERE id_trayectoria = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_trayectoria);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        FlightConnection connection1 = new FlightConnection(
                            resultSet.getInt("id_trayectoria"),
                            resultSet.getString("trayectoria_numero"),
                            resultSet.getInt("id_trip"),
                            resultSet.getInt("id_avion"),
                            resultSet.getString("id_aeropuerto")
                        );
                        return Optional.of(connection1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(int id_trayectoria){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM flightconnection WHERE id_trayectoria = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_trayectoria);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FlightConnection> findAll(){
        List<FlightConnection> connections = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_trayectoria,trayectoria_numero,id_trip,id_avion,id_aeropuerto FROM flightconnection";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    FlightConnection connect = new FlightConnection(
                        resultSet.getInt("id_trayectoria"),
                        resultSet.getString("trayectoria_numero"),
                        resultSet.getInt("id_trip"),
                        resultSet.getInt("id_avion"),
                        resultSet.getString("id_aeropuerto")
                        );
                    connections.add(connect);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connections;
    }
}
