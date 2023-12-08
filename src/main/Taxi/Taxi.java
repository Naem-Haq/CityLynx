package main.Taxi;
import java.util.HashMap;
import java.util.Map;

public class Taxi {
    private String taxiId;
    private int capacity;
    private double basePrice;
    private double latitude;
    private double longitude;

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

    public void setLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getTaxiId() {
        return taxiId;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public static void main(String[] args) {
        // Example usage with HashMap
        Map<String, Taxi> taxiMap = new HashMap<>();

        // Creating and adding taxis to the map
        Taxi taxi1 = new Taxi("123456", 4, 4);
        taxi1.setLocation(40.7128, -74.0060); // Example coordinates for New York
        taxiMap.put(taxi1.getTaxiId(), taxi1);

        Taxi taxi2 = new Taxi("654321", 6, 6);
        taxi2.setLocation(34.0522, -118.2437); // Example coordinates for Los Angeles
        taxiMap.put(taxi2.getTaxiId(), taxi2);

        // Retrieving and printing taxi information
        Taxi retrievedTaxi = taxiMap.get("123456");
        if (retrievedTaxi != null) {
            System.out.println("Taxi ID: " + retrievedTaxi.getTaxiId());
            System.out.println("Capacity: " + retrievedTaxi.getCapacity());
            System.out.println("Coordinates: (" + retrievedTaxi.getLatitude() + ", " + retrievedTaxi.getLongitude() + ")");
        } else {
            System.out.println("Taxi not found.");
        }
    }
}
