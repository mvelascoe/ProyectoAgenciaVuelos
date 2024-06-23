package com.proyectojava.cities.adapters.out;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.proyectojava.cities.domain.models.Cities;
import com.proyectojava.cities.infrastructure.CitiesRepository;

public class CitiesMySQLRepository implements CitiesRepository {
    private final String url;
    private final String user;
    private final String password;

    public CitiesMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Cities cities) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO cities (id_ciudad,nombre_ciudad,id_pais) VALUES(?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, cities.getId_ciudad());
                statement.setString(2, cities.getNombre_ciudad());
                statement.setString(3, cities.getId_pais());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Cities cities) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE cities SET id_ciudad = ?,nombre_ciudad = ?,id_pais = ? WHERE id_ciudad = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1,cities.getId_ciudad());
                statement.setString(2,cities.getNombre_ciudad());
                statement.setString(3,cities.getId_pais());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Cities> findById(String id_ciudad) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_ciudad,nombre_ciudad,id_pais FROM cities WHERE id_ciudad = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id_ciudad);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Cities city = new Cities(
                                resultSet.getString("id_ciudad"),
                                resultSet.getString("nombre_ciudad"),
                                resultSet.getString("id_pais"));
                        return Optional.of(city);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(String id_ciudad) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM cities WHERE id_ciudad = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "id_ciudad");
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cities> findAll() {
        List<Cities> cities = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_ciudad,nombre_ciudad,id_pais FROM cities";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Cities city = new Cities(
                            resultSet.getString("id_ciudad"),
                            resultSet.getString("nombre_ciudad"),
                            resultSet.getString("id_pais"));
                    cities.add(city);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }
}
