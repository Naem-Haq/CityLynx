package com.ise.epic.Taxi;

public class RegTaxi extends Taxi {
    public RegTaxi(String taxiId) {
        super(taxiId, 4, 4);
    }

    // Override the toString method to provide a meaningful representation
    @Override
    public String toString() {
        return "RegTaxi{" +
                "taxiId='" + getTaxiId() + '\'' +
                ", capacity=" + getCapacity() +
                ", basePrice=" + calculateFare(0) + // Assuming you want to include base fare in the representation
                '}';
    }
}
