package com.proyectojava.tripbooking.adapters.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.proyectojava.tripbooking.domain.models.Tripbooking;
import com.proyectojava.tripbooking.infrastructure.TripbookingRepository;

public class TripbookingMySQLRepository implements TripbookingRepository{
    private final String url;
    private final String user;
    private final String password;

    
    public TripbookingMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(Tripbooking tripbooking) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "INSERT INTO tripboooking (fecha_ticket, id_trip) VALUES (?, ?)";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setDate(1, tripbooking.getFecha_ticket());
                statement.setInt(2, tripbooking.getId_trip());
                statement.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void update(Tripbooking tripbooking) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "UPDATE tripboooking SET fecha_ticket = ?, id_trip = ? WHERE id_trip_booking = ? ";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setDate(1, tripbooking.getFecha_ticket());
                statement.setInt(2, tripbooking.getId_trip());
                statement.setInt(3, tripbooking.getId_trip_booking());
                statement.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public Optional<Tripbooking> findById(int id_trip_booking) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id_trip_booking, fecha_ticket, id_trip FROM tripboooking WHERE id_trip_booking = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id_trip_booking);
                try (ResultSet resultSet = statement.executeQuery()){
                    if (resultSet.next()){
                        Tripbooking tripbooking = new Tripbooking(
                            resultSet.getInt("id_trip_booking"), 
                            resultSet.getDate("fecha_ticket"), 
                            resultSet.getInt("id_trip")
                        );
                        return Optional.of(tripbooking);
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }


    @Override
    public void delete(int id_trip_booking) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "DELETE FROM tripboooking WHERE id_trip_booking = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, id_trip_booking);
                statement.executeQuery();

            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Tripbooking> findAll() {
        List<Tripbooking> tripbookings = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "SELECT id_trip_booking, fecha_ticket, id_trip FROM tripboooking";
            try (PreparedStatement statement = connection.prepareStatement(query);
                    ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()){
                    Tripbooking tripbooking = new Tripbooking(
                        resultSet.getInt("id_trip_booking"),
                        resultSet.getDate("fecha_tecket"), 
                        resultSet.getInt("id_trip")
                    );
                    tripbookings.add(tripbooking);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return tripbookings;
    }

}


