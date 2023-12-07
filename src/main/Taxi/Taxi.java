package main.Taxi;

public class Taxi {
    private int capacity;
    private double basePrice;

    public Taxi(int capacity, double basePrice) {
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
}
