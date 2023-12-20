package com.ise.epic.Taxi;

public class XLTaxi extends Taxi {
    public XLTaxi(String taxiId) {
        super(taxiId, 6, 5);
    }

    // Override the toString method to provide a meaningful representation
    @Override
    public String toString() {
        return "XLTaxi{" +
                "taxiId='" + getTaxiId() + '\'' +
                ", capacity=" + getCapacity() +
                ", basePrice=" + calculateFare(0) + // Assuming you want to include base fare in the representation
                '}';
    }
}
