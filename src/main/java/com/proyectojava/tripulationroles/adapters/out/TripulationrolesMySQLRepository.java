package com.proyectojava.tripulationroles.adapters.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.proyectojava.tripulationroles.domain.models.Tripulationroles;
import com.proyectojava.tripulationroles.infrastructure.TripulationrolesRepository;

public class TripulationrolesMySQLRepository implements TripulationrolesRepository{
    private final String url;
    private final String user;
    private final String password;

    public TripulationrolesMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Tripulationroles tripulationroles) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "INSERT INTO rols (nombre_rol) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, tripulationroles.getNombre_rol());
                statement.executeUpdate();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void update(Tripulationroles tripulationroles) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE rols SET nombre_rol = ? WHERE id_rol = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, tripulationroles.getNombre_rol());
                statement.setInt(2, tripulationroles.getId_rol());
                statement.executeUpdate();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Tripulationroles> findById(int id_rol) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id_rol, nombre_rol FROM rols WHERE id_rol = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id_rol);
                try (ResultSet resultSet = statement.executeQuery()){
                    if(resultSet.next()){
                        Tripulationroles tripulationroles = new Tripulationroles(
                            resultSet.getInt("id_rol"),
                            resultSet.getString("nombre_rol")
                        );
                        return Optional.of(tripulationroles);
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }



    @Override
    public void delete(int id_rol) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "DELETE FROM rols WHERE id_rol = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id_rol);
                statement.executeQuery();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }


    @Override
    public List<Tripulationroles> findAll() {
        List <Tripulationroles> tripulationsroles = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id_rol, nombre_rol FROM rols";
            try(PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()){
                    Tripulationroles tripulationroles = new Tripulationroles(
                        resultSet.getInt("id_rol"), 
                        resultSet.getString("nombre_rol")
                    );
                    tripulationsroles.add(tripulationroles);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return tripulationsroles;
    }
}
