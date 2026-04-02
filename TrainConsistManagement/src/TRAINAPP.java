import java.util.HashMap;
import java.util.Map;

public class TRAINAPP {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: Bogie Capacity Mapping ===\n");

        // ==========================
        // Initialize HashMap for bogie-capacity mapping
        // ==========================
        HashMap<String, Integer> bogieCapacityMap = new HashMap<>();

        // Add passenger bogies and their seating capacities
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 60);
        bogieCapacityMap.put("First Class", 40);

        // Add goods bogies and their load capacities (in tons)
        bogieCapacityMap.put("Rectangular Goods", 50);
        bogieCapacityMap.put("Cylindrical Goods", 40);

        // Iterate over the map and display bogie details
        System.out.println("Bogie Capacities:");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() + " | Capacity: " + entry.getValue());
        }

        // Example: Lookup a specific bogie's capacity
        String bogieToCheck = "AC Chair";
        if (bogieCapacityMap.containsKey(bogieToCheck)) {
            System.out.println("\nLookup: " + bogieToCheck + " has capacity " + bogieCapacityMap.get(bogieToCheck));
        }
    }
}