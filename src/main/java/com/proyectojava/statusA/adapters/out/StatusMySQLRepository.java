package com.proyectojava.statusA.adapters.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.proyectojava.statusA.domain.models.Status;
import com.proyectojava.statusA.infrastructure.StatusRepository;

public class StatusMySQLRepository implements StatusRepository {
    private final String url;
    private final String user;
    private final String password;

    public StatusMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Status status) {
         try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO statusA (nombre_estado) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, status.getNombre_estado());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Status status) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE statusA SET nombre_estado = ? WHERE id_estado = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, status.getNombre_estado());
                statement.setInt(2, status.getId_estado());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Optional<Status> findById(int id_estado) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_estado, nombre_estado FROM statusA WHERE id_estado = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_estado);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Status status = new Status(
                            resultSet.getInt("id_estado"),
                            resultSet.getString("nombre_estado")
                        );
                        return Optional.of(status);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }

    @Override
    public void delete(int id_estado) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM statusA WHERE id_estado = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_estado);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Status> findAll() {
       List<Status> statuses = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_estado, nombre_estado FROM statusA";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Status status = new Status(
                        resultSet.getInt("id_estado"),
                        resultSet.getString("nombre_estado")
                    );
                    statuses.add(status);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statuses;

    }

}
