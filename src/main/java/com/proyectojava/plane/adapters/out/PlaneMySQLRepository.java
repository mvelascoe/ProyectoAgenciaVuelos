package com.proyectojava.plane.adapters.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.proyectojava.plane.domain.models.Plane;
import com.proyectojava.plane.infrastructure.PlaneRepository;

public class PlaneMySQLRepository implements PlaneRepository{
    private final String url;
    private final String user;
    private final String password;

    public PlaneMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Plane plane) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO planes (matricula, capacidad, fecha_fabricacion, id_estado, id_modelo) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, plane.getMatricula());
                statement.setInt(2, plane.getCapacidad());
                statement.setDate(3, plane.getFecha_fabricacion());
                statement.setInt(4, plane.getId_estado());
                statement.setInt(5, plane.getId_modelo());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Plane plane) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE planes SET matricula = ?, capacidad = ?, fecha_fabricacion = ?, id_estado = ?, id_modelo = ? WHERE id_avion = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, plane.getMatricula());
                statement.setInt(2, plane.getCapacidad());
                statement.setDate(3, plane.getFecha_fabricacion());
                statement.setInt(4, plane.getId_estado());
                statement.setInt(5, plane.getId_modelo());
                statement.setInt(6, plane.getId_avion());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Plane> findById(int id_avion) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_avion, matricula, capacidad, fecha_fabricacion, id_estado, id_modelo FROM planes WHERE id_avion = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_avion);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Plane plane = new Plane(
                            resultSet.getInt("id_avion"),
                            resultSet.getString("matricula"),
                            resultSet.getInt("capacidad"),
                            resultSet.getDate("fecha_fabricacion"),
                            resultSet.getInt("id_estado"),
                            resultSet.getInt("id_modelo")
                        );
                        return Optional.of(plane);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }

    @Override
    public void delete(int id_avion) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM planes WHERE id_avion = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_avion);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Plane> findAll() {
         List<Plane> planes = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_avion, matricula, capacidad, fecha_fabricacion, id_estado, id_modelo FROM planes";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Plane plane = new Plane(
                        resultSet.getInt("id_avion"),
                        resultSet.getString("matricula"),
                        resultSet.getInt("capacidad"),
                        resultSet.getDate("fecha_fabricacion"),
                        resultSet.getInt("id_estado"),
                        resultSet.getInt("id_modelo")
                    );
                    planes.add(plane);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return planes;
    }

}
