package com.ise.epic.Taxi;

public class Taxi {
    private String taxiId;
    private int capacity;
    private double basePrice;

    public Taxi(String taxiId, int capacity, double basePrice) {
        this.taxiId = taxiId;
        this.capacity = capacity;
        this.basePrice = basePrice;
    }

    public double calculateFare(double distance) {
        // Base fare + additional fare based on distance
        return basePrice + (distance / 750) * 1;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getTaxiId() {
        return taxiId;
    }

    public void setLocation(int randomRow, int randomCol) {
    }
}
