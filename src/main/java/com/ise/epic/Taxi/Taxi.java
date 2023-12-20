package com.ise.epic.Taxi;

public class Taxi {
    private String driverId;
    private String name;
    private String taxiType;
    private boolean available;
    private double basePrice;
    private int capacity;

    public Taxi(String driverId, String name, String taxiType, boolean available) {
        this.driverId = driverId;
        this.name = name;
        this.taxiType = taxiType;
        this.available = available;
    }

    public Taxi(String driverId, int driverName, int taxiType) {
    }

    public double calculateFare(double distance) {
        // Base fare + additional fare based on distance
        return basePrice + (distance / 750) * 1;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getTaxiId() {
        return driverId;
    }

    public Object getDriverId() {
        return null;
    }

    public Object getDriverName() {
        return null;
    }

    public Object getTaxiType() {
        return null;
    }

    public void setLocation(int randomRow, int randomCol) {
    }

    public Location getLocation() {
        return null;
    }

    public boolean isAvailable() {
        return false;
    }

    public void setAvailable(boolean available) {
    }
}
