package com.proyectojava.gate.adapters.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.proyectojava.gate.domain.models.Gate;
import com.proyectojava.gate.infrastructure.GateRepository;

public class GateMySQLRepository implements GateRepository {
    private final String url;
    private final String user;
    private final String password;

    public GateMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Gate gate) {
         try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO gates (numero_puerta, id_aeropuerto) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, gate.getNumero_puerta());
                statement.setString(2, gate.getId_aeropuerto());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void uptade(Gate gate) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE gates SET numero_puerta = ?, id_aeropuerto = ? WHERE id_puerta = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, gate.getNumero_puerta());
                statement.setString(2, gate.getId_aeropuerto());
                statement.setInt(3, gate.getId_puerta());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Gate> findById(int id_puerta) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_puerta, numero_puerta, id_aeropuerto FROM gates WHERE id_puerta = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_puerta);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Gate gate = new Gate(
                            resultSet.getInt("id_puerta"),
                            resultSet.getInt("numero_puerta"),
                            resultSet.getString("id_aeropuerto")
                        );
                        return Optional.of(gate);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }

    @Override
    public void delete(int id_puerta) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM gates WHERE id_puerta = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_puerta);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Gate> findAll() {
        List<Gate> gates = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_puerta, numero_puerta, id_aeropuerto FROM gates";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Gate gate = new Gate(
                        resultSet.getInt("id_puerta"),
                        resultSet.getInt("numero_puerta"),
                        resultSet.getString("id_aeropuerto")
                    );
                    gates.add(gate);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gates;

    }

}
