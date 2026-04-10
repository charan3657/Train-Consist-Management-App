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

    // Used for grouping
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

    private String category; // Sleeper, AC Chair, First Class

    public PassengerBogie(String bogieId, String category, int capacity) {
        super(bogieId, capacity);
        this.category = category;
    }

    @Override
    public String getCategory() {
        return category;
    }
}

// Goods Bogie (optional but included for realism)
class GoodsBogie extends Bogie {

    private String cargoType; // Rectangular / Cylindrical

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
public class TRAINAPP {

    public static void main(String[] args) {

        List<Bogie> bogieList = new ArrayList<>();

        // Sample Data (reuse from UC7/UC8)
        bogieList.add(new PassengerBogie("B1", "Sleeper", 72));
        bogieList.add(new PassengerBogie("B2", "AC Chair", 60));
        bogieList.add(new PassengerBogie("B3", "First Class", 50));
        bogieList.add(new PassengerBogie("B4", "Sleeper", 80));
        bogieList.add(new PassengerBogie("B5", "AC Chair", 65));

        // Goods Bogies
        bogieList.add(new GoodsBogie("G1", "Cylindrical", 100));
        bogieList.add(new GoodsBogie("G2", "Rectangular", 120));
        bogieList.add(new GoodsBogie("G3", "Cylindrical", 90));

        System.out.println("===== ALL BOGIES =====");
        bogieList.forEach(System.out::println);

        // ✅ UC9: Grouping using Stream API
        Map<String, List<Bogie>> groupedBogies = bogieList.stream()
                .collect(Collectors.groupingBy(b -> b.getCategory()));

        // Display grouped result
        System.out.println("\n===== GROUPED BOGIES BY TYPE =====");

        if (groupedBogies.isEmpty()) {
            System.out.println("No bogies available.");
        } else {
            for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
                System.out.println("\nCategory: " + entry.getKey());
                entry.getValue().forEach(System.out::println);
            }
        }

        // Verify original list unchanged
        System.out.println("\n===== ORIGINAL LIST (UNCHANGED) =====");
        bogieList.forEach(System.out::println);
    }
}