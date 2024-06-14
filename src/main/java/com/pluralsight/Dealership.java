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
                System.out.print("ID: "); System.out.println(results.getString("DealershipID"));
                System.out.print("Name: "); System.out.println(results.getString("Name"));
                System.out.print("Address: "); System.out.print(results.getString("Address"));
                System.out.print("\nPhone: "); System.out.println(results.getString("Phone"));
                System.out.println("\n");



            }

            results.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }

        }
}



