package com.proyectojava.tripulation.adapters.out;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.proyectojava.tripulation.domain.models.Tripulation;
import com.proyectojava.tripulation.infrastructure.TripulationRepository;

public class TripulationMySQLRepository implements TripulationRepository{
    private final String url;
    private final String user;
    private final String password;
    public TripulationMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Tripulation tripulation){
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "INSERT INTO tripulation (id_empleado, id_trayectoria) VALUES (?, ?)";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, tripulation.getId_empleado());
                statement.setInt(2, tripulation.getId_trayectoria());
                statement.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Tripulation tripulation){
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE tripulation SET id_empleado = ?, id_trayectoria = ? WHERE id_tripulacion = ? ";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setString(1, tripulation.getId_empleado());
                statement.setInt(2, tripulation.getId_trayectoria());
                statement.setInt(3, tripulation.getId_tripulacion());
                statement.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Tripulation>findById(int id_tripulacion){
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id_tripulacion, id_empleado, id_trayectoria FROM tripulation WHERE id_tripulacion = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id_tripulacion);
                try (ResultSet resultSet = statement.executeQuery()){
                    if (resultSet.next()){
                        Tripulation team1 = new Tripulation(
                            resultSet.getInt("id_tripulacion"), 
                            resultSet.getString("id_empleado"), 
                            resultSet.getInt("id_trayectoria")
                        );
                        return Optional.of(team1);
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete (int id_tripulacion){
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "DELETE FROM tripulation WHERE id_tripulacion = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id_tripulacion);
                statement.executeUpdate();

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Tripulation>findAll(){
        List<Tripulation> tripulations = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id_tripulacion, id_empleado, id_trayectoria FROM tripulation";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()){
                    Tripulation team = new Tripulation(
                        resultSet.getInt("id_tripulacion"),
                        resultSet.getString("id_empleado"),
                        resultSet.getInt("id_trayectoria")
                    );
                    tripulations.add(team);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return tripulations;
    }

}
