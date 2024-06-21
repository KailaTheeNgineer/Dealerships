package com.pluralsight;

import java.sql.Connection;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Dealership {

    public static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean home = true;

        while (home) {

            System.out.println("Welcome to the Dealership\n Select An Option to Begin: \n(1) View Dealership \n(2) View Vehicles \n(3) Sales Contracts \n(4) Exit");
            String userInput = myScanner.nextLine();
            System.out.println("(1) View Dealership \n(2) View Vehicles \n(3) Sales Contracts (4) Lease Contracts (0) Exit");

            String password = args[0];
            String url = "jdbc:mysql://localhost:3306/CarDealership";
            String username = "root";

            if (userInput.equalsIgnoreCase("1")) {

                boolean dealership = true;

                while (dealership) {

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

                        System.out.println("(0) Home");
                        String dealershipInput = myScanner.nextLine();
                        if (dealershipInput.equalsIgnoreCase("0")) {

                            dealership = false;
                        } else {

                            System.out.println("Enter a Valid Option");
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();


                    }
                }
            } else if (userInput.equalsIgnoreCase("2")) {
                boolean viewVehicles = true;

                while (viewVehicles) {

                    try {
                        System.out.println("Vehicles Inventory: \n");
                        String InventoryQuery = "SELECT * FROM Inventory";


                        Connection connection;
                        connection = DriverManager.getConnection(url, username, password);
                        PreparedStatement statement = connection.prepareStatement(InventoryQuery);


                        ResultSet results = statement.executeQuery();

                        while (results.next()) {
                            System.out.print("Dealership ID: ");
                            System.out.println(results.getString("DealershipID"));
                            System.out.print("VIN: ");
                            System.out.println(results.getString("VIN"));
                            System.out.print("Make: ");
                            System.out.print(results.getString("VehicleMake"));
                            System.out.print("\nModel: ");
                            System.out.print(results.getString("VehicleModel"));
                            System.out.println("\n");


                        }

                        results.close();
                        statement.close();
                        connection.close();

                        System.out.println("(0) Home");
                        String inventoryInput = myScanner.nextLine();
                        if (inventoryInput.equalsIgnoreCase("0")) {

                            viewVehicles = false;
                        } else {

                            System.out.println("\n Enter a Valid Option\n ");
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();


                    }




                }


            } else if (userInput.equalsIgnoreCase("3")) {

               DealershipDataManager ddm = new DealershipDataManager();
                System.out.println("Search a Vehicle by Make: ");
                String userMakeSearch = myScanner.nextLine();
                List<Vehicle> foundVehicles = ddm.getVehicleByMake(userMakeSearch);

                System.out.println(foundVehicles);


            } else if (userInput.equalsIgnoreCase("4")) {


            } else if (userInput.equalsIgnoreCase("0")) {

                System.exit(0);
            }  else {

                System.out.println("\nEnter a Valid Option\n");
            }

        }
    }
}



