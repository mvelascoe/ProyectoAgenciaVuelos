package com.proyectojava.manufacturer.adapters.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.proyectojava.manufacturer.domain.models.Manufacturer;
import com.proyectojava.manufacturer.infrastructure.ManufacturerRepository;

public class ManufacturerMySQLRepository implements ManufacturerRepository{
    private final String url;
    private final String user;
    private final String password;

    public ManufacturerMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Manufacturer manufacturer) {
         try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO manufacturer (nombre_manufactura) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, manufacturer.getNombre_manufactura());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Manufacturer manufacturer) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE manufacturer SET nombre_manufactura = ? WHERE id_manufactura = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, manufacturer.getNombre_manufactura());
                statement.setInt(2, manufacturer.getId_manufactura());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Manufacturer> findById(int id_manufactura) {
         try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_manufactura, nombre_manufactura FROM manufacturer WHERE id_manufactura = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_manufactura);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Manufacturer manufacturer = new Manufacturer(
                            resultSet.getInt("id_manufactura"),
                            resultSet.getString("nombre_manufactura")
                        );
                        return Optional.of(manufacturer);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }

    @Override
    public void delete(int id_manufactura) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM manufacturer WHERE id_manufactura = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_manufactura);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Manufacturer> findAll() {
        List<Manufacturer> manufacturers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_manufactura, nombre_manufactura FROM manufacturer";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Manufacturer manufacturer = new Manufacturer(
                        resultSet.getInt("id_manufactura"),
                        resultSet.getString("nombre_manufactura")
                    );
                    manufacturers.add(manufacturer);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manufacturers;
    }

}
