package com.pluralsight;

public class Vehicle {
        private int dealershipID;
    private int VIN;
        private String vehicleMake;
        private String vehicleModel;

        public Vehicle(int dealershipID, int VIN, String vehicleMake, String vehicleModel) {
            this.dealershipID = dealershipID;
            this.VIN = VIN;
            this.vehicleMake = vehicleMake;
            this.vehicleModel = vehicleModel;
        }

    public int getDealershipID() {
        return dealershipID;
    }

    public int getVIN() {
        return VIN;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    @Override
    public String toString() {
        return
                "Dealership ID: " + dealershipID +
                ", VIN: " + VIN +
                ", Make: " + vehicleMake +
                ", Model: " + vehicleModel;
    }
}
