package com.proyectojava.models.adapters.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.proyectojava.models.domain.models.Model;
import com.proyectojava.models.infrastructure.ModelRepository;

public class ModelMySQLRepository implements ModelRepository {
    private final String url;
    private final String user;
    private final String password;

    public ModelMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Model model) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO models (nombre_modelo, id_manufactura) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, model.getNombre_modelo());
                statement.setInt(2, model.getId_manufactura());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Model model) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE models SET nombre_modelo = ?, id_manufactura = ? WHERE id_modelo = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, model.getNombre_modelo());
                statement.setInt(2, model.getId_manufactura());
                statement.setInt(3, model.getId_modelo());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Model> findById(int id_modelo) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_modelo, nombre_modelo, id_manufactura FROM models WHERE id_modelo = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_modelo);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Model model = new Model(
                            resultSet.getInt("id_modelo"),
                            resultSet.getString("nombre_modelo"),
                            resultSet.getInt("id_manufactura")
                        );
                        return Optional.of(model);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }

    @Override
    public void delete(int id_modelo) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM models WHERE id_modelo = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_modelo);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Model> findAll() {
         List<Model> models = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_modelo, nombre_modelo, id_manufactura FROM models";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Model model = new Model(
                        resultSet.getInt("id_modelo"),
                        resultSet.getString("nombre_modelo"),
                        resultSet.getInt("id_manufactura")
                    );
                    models.add(model);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return models;

    }

}
