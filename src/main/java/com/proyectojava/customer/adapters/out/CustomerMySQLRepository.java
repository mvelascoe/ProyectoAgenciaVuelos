package com.proyectojava.customer.adapters.out;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.*;

import com.proyectojava.customer.domain.models.Customer;
import com.proyectojava.customer.infrastructure.CustomerRepository;

public class CustomerMySQLRepository implements CustomerRepository {
    private final String url;
    private final String user;
    private final String password;

    public CustomerMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Customer costumer){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO costumer (id_cliente,nombre_cliente,edad_cliente,id_documento) VALUES(?,?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, costumer.getId_cliente());
                statement.setString(2, costumer.getNombre_cliente());
                statement.setInt(3, costumer.getEdad_cliente());
                statement.setInt(4, costumer.getId_documento());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Customer costumer){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE costumer SET id_cliente = ?,nombre_cliente = ?,edad_cliente = ?,id_documento = ? WHERE id_cliente = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1,costumer.getId_cliente());
                statement.setString(2,costumer.getNombre_cliente());
                statement.setInt(3,costumer.getEdad_cliente());
                statement.setInt(4, costumer.getId_documento());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Customer> findById(String id_cliente){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_cliente,nombre_cliente,edad_cliente,id_documento FROM costumer WHERE id_cliente = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id_cliente);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Customer custom = new Customer(
                                resultSet.getString("id_cliente"),
                                resultSet.getString("nombre_cliente"),
                                resultSet.getInt("edad_cliente"),
                                resultSet.getInt("id_documento"));
                        return Optional.of(custom);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(String id_cliente){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM costumer WHERE id_cliente = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "id_cliente");
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Customer> findAll(){
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_cliente,nombre_ciudad,id_pais FROM costumer";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Customer custom = new Customer(
                            resultSet.getString("id_cliente"),
                            resultSet.getString("nombre_cliente"),
                            resultSet.getInt("edad_cliente"),
                            resultSet.getInt("id_documento"));
                            customers.add(custom);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
