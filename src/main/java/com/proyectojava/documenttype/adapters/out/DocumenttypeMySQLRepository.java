package com.proyectojava.documenttype.adapters.out;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.proyectojava.documenttype.domain.models.Documenttype;
import com.proyectojava.documenttype.infrastructure.DocumenttypeRepository;

public class DocumenttypeMySQLRepository implements DocumenttypeRepository {
    private final String url;
    private final String user;
    private final String password;

    public DocumenttypeMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Documenttype documenttype) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO documenttype (id_documento,nombre_documento) VALUES(?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, documenttype.getId_documento());
                statement.setString(2, documenttype.getNombre_documento());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Documenttype documenttype) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE documenttype SET nombre_documento = ? WHERE id_documento = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, documenttype.getNombre_documento());
                statement.setInt(2, documenttype.getId_documento());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Documenttype> findById(int id_documento) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_documento,nombre_documento FROM documenttype WHERE id_documento = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_documento);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Documenttype doty = new Documenttype(
                                resultSet.getInt("id_documento"),
                                resultSet.getString("nombre_documento"));
                        return Optional.of(doty);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(int id_documento) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM documenttype WHERE id_documento = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_documento);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Documenttype> findAll() {
        List<Documenttype> documents = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_documento,nombre_documento FROM documenttype";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Documenttype doty = new Documenttype(
                            resultSet.getInt("id_documento"),
                            resultSet.getString("nombre_documento"));
                    documents.add(doty);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return documents;
    }
}
