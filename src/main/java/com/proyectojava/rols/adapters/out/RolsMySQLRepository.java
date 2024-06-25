package com.proyectojava.rols.adapters.out;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.proyectojava.rols.domain.models.Rols;
import com.proyectojava.rols.infrastructure.RolsRepository;

public class RolsMySQLRepository  implements RolsRepository{
    private final String url;
    private final String user;
    private final String password;

    public RolsMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Rols rols){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO rols (nombre_rol) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1,rols.getNombre_rol());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void update(Rols rols){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE rols SET nombre_rol = ? WHERE id_rol = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1,rols.getNombre_rol());
                statement.setInt(2, rols.getId_rol());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Rols> findById(int id_rol){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_rol, nombre_rol FROM rols WHERE id_rol = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_rol);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Rols rol = new Rols(
                            resultSet.getInt("id_rol"),
                            resultSet.getString("nombre_rol")
                        );
                        return Optional.of(rol);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(int id_rol){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM rols WHERE id_rol = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_rol);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Rols> findAll(){
        List<Rols> roles = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_rol, nombre_rol FROM rols";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Rols rol = new Rols(
                        resultSet.getInt("id_rol"),
                        resultSet.getString("nombre_rol")
                    );
                    roles.add(rol);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }
}
