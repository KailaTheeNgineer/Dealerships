package com.pluralsight;

import java.sql.Connection;
import java.sql.*;

public class Dealership {

    public static void main(String[] args) {

        String password = args[0];
        String url = "jdbc:mysql://localhost:3306/CarDealership";
        String username = "root";

        try {
            System.out.println("Dealership Data: \n");
            String allDealershipsQuery = "SELECT * FROM Dealerships";


            Connection connection;
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(allDealershipsQuery);


            ResultSet results = statement.executeQuery();

            while (results.next()) {
                System.out.print("ID: ");
                System.out.println(results.getString("DealershipID"));
                System.out.print("Name: ");
                System.out.println(results.getString("Name"));
                System.out.print("Address: ");
                System.out.print(results.getString("Address"));
                System.out.print("\nPhone: ");
                System.out.println(results.getString("Phone"));
                System.out.println("\n");


            }

            results.close();
            statement.close();
            connection.close();


            System.out.println("Inventory Data: \n");
            String allInventoryQuery = "SELECT * FROM Inventory";


            Connection connection2;
            connection2 = DriverManager.getConnection(url, username, password);
            PreparedStatement statement2 = connection2.prepareStatement(allInventoryQuery);


            ResultSet results2 = statement2.executeQuery();

            while (results2.next()) {
                System.out.print("VIN: ");
                System.out.println(results2.getString("VIN"));
                System.out.print("Make: ");
                System.out.println(results2.getString("VehicleMake"));
                System.out.print("Model: ");
                System.out.print(results2.getString("VehicleModel"));
                System.out.print("\nSold: ");
                System.out.println(results2.getString("Sold"));
                System.out.println("\n");


            }


            results2.close();
            statement2.close();
            connection2.close();

        } catch (SQLException e) {
            e.printStackTrace();


        }
    }
}



