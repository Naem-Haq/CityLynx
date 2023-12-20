package com.ise.epic.Taxi;

public class LuxuryTaxi extends Taxi {
    public LuxuryTaxi(String taxiId) {
        super(taxiId, 4, 10);
    }

    // Override the toString method to provide a meaningful representation
    @Override
    public String toString() {
        return "LuxuryTaxi{" +
                "taxiId='" + getTaxiId() + '\'' +
                ", capacity=" + getCapacity() +
                ", basePrice=" + calculateFare(0) + // Assuming you want to include base fare in the representation
                '}';
    }
}
