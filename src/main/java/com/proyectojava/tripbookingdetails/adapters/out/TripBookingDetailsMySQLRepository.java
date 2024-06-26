package com.proyectojava.tripbookingdetails.adapters.out;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.proyectojava.tripbookingdetails.domain.models.TripBokkingDetails;
import com.proyectojava.tripbookingdetails.infrastructure.TripBookkingDetailsRepository;

public class TripBookingDetailsMySQLRepository implements TripBookkingDetailsRepository {
    private final String url;
    private final String user;
    private final String password;

    public TripBookingDetailsMySQLRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void save(TripBokkingDetails tripBokkingDetails) {
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            String query = "INSERT INTO tripbookingdetails (id_trip_booking,id_cliente,id_tarifa) VALUES(?,?,?)";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, tripBokkingDetails.getId_trip_booking());
                statement.setString(2, tripBokkingDetails.getId_cliente());
                statement.setInt(3, tripBokkingDetails.getId_tarifa());
                statement.executeUpdate();
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TripBokkingDetails tripBokkingDetails) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE tripbookingdetails SET id_trip_booking = ?,id_cliente = ?,id_tarifa = ? WHERE id_trip_booking_details = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, tripBokkingDetails.getId_trip_booking());
                statement.setString(2, tripBokkingDetails.getId_cliente());
                statement.setInt(3, tripBokkingDetails.getId_tarifa());
                statement.setInt(4, tripBokkingDetails.getId_trip_booking_details());    
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<TripBokkingDetails> findById(int id_trip_booking_details) {
       try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT  id_trip_booking_details,id_trip_booking,id_cliente,id_tarifa FROM tripbookingdetails WHERE id_trip_booking_details = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_trip_booking_details);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        TripBokkingDetails airport = new TripBokkingDetails(
                                resultSet.getInt("id_trip_booking_details"),
                                resultSet.getInt("id_trip_booking"),
                                resultSet.getString("id_cliente"),
                                resultSet.getInt("id_tarifa"));
                        return Optional.of(airport);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(int id_trip_booking_details) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM tripbookingdetails WHERE id_trip_booking_details = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id_trip_booking_details);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TripBokkingDetails> findAll() {
        List<TripBokkingDetails> details = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT id_trip_booking_details,id_trip_booking,id_cliente,id_tarifa FROM tripbookingdetails";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    TripBokkingDetails detail = new TripBokkingDetails(
                            resultSet.getInt("id_trip_booking_details"),
                            resultSet.getInt("id_trip_booking"),
                            resultSet.getString("id_cliente"),
                            resultSet.getInt("id_tarifa"));
                    details.add(detail);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return details;
    }

}
