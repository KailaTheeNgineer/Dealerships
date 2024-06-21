package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipDataManager {
        private BasicDataSource dataSource;
        public void SakilaDataManager(String username, String password){
            // Create the datasource
            this.dataSource = new BasicDataSource();

            // Configure the datasource
            dataSource.setUrl("jdbc:mysql://localhost:3306/CarDealership");
            dataSource.setUsername(username);
            dataSource.setPassword(password);
        }
        public List<Vehicle> getAllVehicles() {
            List<Vehicle> vehicles = new ArrayList<>();
            String sql = "SELECT * FROM inventory";
            return vehicles;
        }
        public List<Vehicle> getVehicleByMake(String vehicleMake) {
            List<Vehicle> vehicles = new ArrayList<>();
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement preparedStatement =
                         connection.prepareStatement(
                                 "SELECT * FROM inventory WHERE vehicleMake LIKE ?");
            ) {
                preparedStatement.setString(1, vehicleMake + "%");

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        vehicles.add(new Vehicle(resultSet.getInt("DealershipID"), resultSet.getInt("VIN"), resultSet.getString("vehicleMake"), resultSet.getString("vehicleModel")));
                    }


                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return vehicles;
        }
    }
