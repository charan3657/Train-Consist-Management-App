import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TRAINAPP {

    public static void main(String[] args) {
        // ==========================
        // UC1: Initialize Train Consist
        // ==========================
        System.out.println("=== Train Consist Management App ===\n");

        // Initialize empty list for bogies
        List<String> passengerBogies = new ArrayList<>();
        System.out.println("Initial bogie count: " + passengerBogies.size());

        // ==========================
        // UC2: Add Passenger Bogies
        // ==========================
        System.out.println("\n--- Adding Passenger Bogies ---");

        // Add bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Display after insertion
        System.out.println("Passenger bogies after addition: " + passengerBogies);

        // Remove one bogie
        passengerBogies.remove("AC Chair");
        System.out.println("Passenger bogies after removing AC Chair: " + passengerBogies);

        // Check existence
        if (passengerBogies.contains("Sleeper")) {
            System.out.println("Sleeper bogie exists in the consist.");
        } else {
            System.out.println("Sleeper bogie does not exist.");
        }

        // ==========================
        // UC3: Track Unique Bogie IDs
        // ==========================
        System.out.println("\n--- Tracking Unique Bogie IDs ---");

        Set<String> bogieIDs = new HashSet<>();

        // Add IDs (some duplicates intentionally)
        bogieIDs.add("BG101");
        bogieIDs.add("BG102");
        bogieIDs.add("BG103");
        bogieIDs.add("BG101"); // duplicate
        bogieIDs.add("BG102"); // duplicate

        // Display unique bogie IDs
        System.out.println("Unique bogie IDs in the consist: " + bogieIDs);
    }
}