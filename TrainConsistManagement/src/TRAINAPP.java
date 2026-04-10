import java.util.*;
import java.util.stream.Collectors;

// Base class
abstract class Bogie {
    protected String bogieId;
    protected int capacity;

    public Bogie(String bogieId, int capacity) {
        this.bogieId = bogieId;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getBogieId() {
        return bogieId;
    }

    public abstract String getCategory();

    @Override
    public String toString() {
        return "Bogie ID: " + bogieId +
                " | Category: " + getCategory() +
                " | Capacity: " + capacity;
    }
}

// Passenger Bogie
class PassengerBogie extends Bogie {
    private String category;

    public PassengerBogie(String bogieId, String category, int capacity) {
        super(bogieId, capacity);
        this.category = category;
    }

    @Override
    public String getCategory() {
        return category;
    }
}

// Goods Bogie
class GoodsBogie extends Bogie {
    private String cargoType;

    public GoodsBogie(String bogieId, String cargoType, int capacity) {
        super(bogieId, capacity);
        this.cargoType = cargoType;
    }

    @Override
    public String getCategory() {
        return cargoType;
    }
}

// Main Application
class TrainConsistManagementApp {

    public static void main(String[] args) {

        List<Bogie> bogieList = new ArrayList<>();

        // Sample Data
        bogieList.add(new PassengerBogie("B1", "Sleeper", 72));
        bogieList.add(new PassengerBogie("B2", "AC Chair", 60));
        bogieList.add(new PassengerBogie("B3", "First Class", 50));
        bogieList.add(new PassengerBogie("B4", "Sleeper", 80));
        bogieList.add(new PassengerBogie("B5", "AC Chair", 65));

        bogieList.add(new GoodsBogie("G1", "Cylindrical", 100));
        bogieList.add(new GoodsBogie("G2", "Rectangular", 120));

        System.out.println("===== ALL BOGIES =====");
        bogieList.forEach(System.out::println);

        // ✅ UC10: Aggregation using map() and reduce()
        int totalCapacity = bogieList.stream()
                .map(b -> b.getCapacity())   // Extract capacity
                .reduce(0, Integer::sum);    // Sum all values

        System.out.println("\n===== TOTAL SEATING CAPACITY =====");
        System.out.println("Total Capacity of Train: " + totalCapacity);

        // Verify original list unchanged
        System.out.println("\n===== ORIGINAL LIST (UNCHANGED) =====");
        bogieList.forEach(System.out::println);
    }
}