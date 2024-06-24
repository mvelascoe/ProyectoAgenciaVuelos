package com.proyectojava.flightfare.adapters.out;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.proyectojava.flightfare.domain.models.Flightfare;
import com.proyectojava.flightfare.infrastructure.FlightfareRepository;

public class FlightfareMySQLRepository implements FlightfareRepository {
    private final String url;
    private final String user;
    private final String password;

    public FlightfareMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Flightfare flightfare){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO flightfare (descripcion,detalles,valor) VALUES(?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1,flightfare.getDescripcion());
                statement.setString(2, flightfare.getDetalles());
                statement.setDouble(3, flightfare.getValor());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Flightfare flightfare){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE flightfare SET id_tarifa = ?,descripcion = ?,detalles = ?,valor = ? WHERE id_tarifa = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, flightfare.getId_tarifa());
                statement.setString(2,flightfare.getDescripcion());
                statement.setString(3, flightfare.getDetalles());
                statement.setDouble(4, flightfare.getValor());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Flightfare> findById(int id_tarifa){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_tarifa,descripcion,detalles,valor FROM flightfare WHERE id_tarifa = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_tarifa);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Flightfare fligthfare = new Flightfare(
                            resultSet.getInt("id_tarifa"),
                            resultSet.getString("descripcion"),
                            resultSet.getString("detalles"),
                            resultSet.getDouble("valor"));
                        return Optional.of(fligthfare);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(int id_tarifa){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM flightfare WHERE id_tarifa = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "id_tarifa");
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Flightfare> findAll(){
        List<Flightfare> fares = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_tarifa,descripcion,detalles,valor FROM flightfare";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Flightfare fare = new Flightfare(
                        resultSet.getInt("id_tarifa"),
                        resultSet.getString("descripcion"),
                        resultSet.getString("detalles"),
                        resultSet.getDouble("valor"));
                    fares.add(fare);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fares;
    }
    
}
