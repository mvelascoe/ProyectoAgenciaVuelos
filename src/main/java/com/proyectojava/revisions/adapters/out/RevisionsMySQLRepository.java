package com.proyectojava.revisions.adapters.out;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.proyectojava.revisions.domain.models.Revisions;
import com.proyectojava.revisions.infrastructure.RevisionsRepository;

public class RevisionsMySQLRepository implements RevisionsRepository{
    private final String url;
    private final String user;
    private final String password;

    public RevisionsMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Revisions revisions) {
         try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO revisions (fecha_revision, id_avion) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setDate(1, revisions.getFecha_revision());
                statement.setInt(2, revisions.getId_avion());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Revisions revisions) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE revisions SET fecha_revision = ?, id_avion = ? WHERE id_revision = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setDate(1, revisions.getFecha_revision());
                statement.setInt(2, revisions.getId_avion());
                statement.setInt(3, revisions.getId_revision());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Revisions> findById(int id_revision) {
       try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_revision, fecha_revision, id_avion FROM revisions WHERE id_revision = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_revision);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Revisions revisions = new Revisions(
                            resultSet.getInt("id_revision"),
                            resultSet.getDate("fecha_revision"),
                            resultSet.getInt("id_avion")
                        );
                        return Optional.of(revisions);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }

    @Override
    public void delete(int id_revision) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM revisions WHERE id_revision = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_revision);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Revisions> findAll() {
        List<Revisions> revisionsList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_revision, fecha_revision, id_avion FROM revisions";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Revisions revisions = new Revisions(
                        resultSet.getInt("id_revision"),
                        resultSet.getDate("fecha_revision"),
                        resultSet.getInt("id_avion")
                    );
                    revisionsList.add(revisions);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return revisionsList;

    }

    

}
