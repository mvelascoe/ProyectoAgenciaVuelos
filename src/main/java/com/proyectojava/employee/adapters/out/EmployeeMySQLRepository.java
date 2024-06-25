package com.proyectojava.employee.adapters.out;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.proyectojava.employee.domain.models.Employee;
import com.proyectojava.employee.infrastructure.EmployeeRepository;

public class EmployeeMySQLRepository implements EmployeeRepository{

    private final String url;
    private final String user;
    private final String password;

    public EmployeeMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Employee employee){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO employee (id_empleado,nombre_empleado,id_rol,fecha_ingreso,id_aerolinea,id_aeropuerto) VALUES(?,?,?,?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1,employee.getId_empleado());
                statement.setString(2,employee.getNombre_empleado());
                statement.setInt(3,employee.getId_rol());
                statement.setDate(4, new java.sql.Date(employee.getFecha_ingreso().getTime())); // Aquí se convierte a java.sql.Date
                statement.setInt(5,employee.getId_aerolinea());
                statement.setString(6,employee.getId_aeropuerto());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employee employee){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE employee SET id_empleado = ?,nombre_empleado = ?,id_rol = ?,fecha_ingreso = ?,id_aerolinea = ?,id_aeropuerto = ? WHERE id_empleado = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1,employee.getId_empleado());
                statement.setString(2,employee.getNombre_empleado());
                statement.setInt(3,employee.getId_rol());
                statement.setDate(4, new java.sql.Date(employee.getFecha_ingreso().getTime())); // Aquí se convierte a java.sql.Date
                statement.setInt(5,employee.getId_aerolinea());
                statement.setString(6,employee.getId_aeropuerto());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Employee> findById(String id_empleado){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_empleado,nombre_empleado,id_rol,fecha_ingreso,id_aerolinea,id_aeropuerto FROM employee WHERE id_empleado = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id_empleado);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        Employee employee = new Employee(
                                resultSet.getString("id_empleado"),
                                resultSet.getString("nombre_empleado"),
                                resultSet.getInt("id_rol"),
                                resultSet.getDate("fecha_ingreso"),
                                resultSet.getInt("id_aerolinea"),
                                resultSet.getString("id_aeropuerto"));
                        return Optional.of(employee);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void delete(String id_empleado){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM employee WHERE id_empleado = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "id_empleado");
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> findAll(){
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_empleado,nombre_empleado,id_rol,fecha_ingreso,id_aerolinea,id_aeropuerto FROM employee";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Employee employee = new Employee(
                            resultSet.getString("id_empleado"),
                            resultSet.getString("nombre_empleado"),
                            resultSet.getInt("id_rol"),
                            resultSet.getDate("fecha_ingreso"),
                            resultSet.getInt("id_aerolinea"),
                            resultSet.getString("id_aeropuerto"));
                            employees.add(employee);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
