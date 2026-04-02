import java.util.ArrayList;
import java.util.List;

public class TRAINAPP {

    public static void main(String[] args) {
        // Welcome message
        System.out.println("=== Train Consist Management App: UC2 ===\n");

        // Step 1: Initialize passenger bogies list
        List<String> passengerBogies = new ArrayList<>();

        // Step 2: Add bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Display bogies after insertion
        System.out.println("Passenger bogies after addition: " + passengerBogies);

        // Step 3: Remove one bogie (AC Chair)
        passengerBogies.remove("AC Chair");
        System.out.println("Passenger bogies after removing AC Chair: " + passengerBogies);

        // Step 4: Check existence of Sleeper bogie
        if (passengerBogies.contains("Sleeper")) {
            System.out.println("Sleeper bogie exists in the consist.");
        } else {
            System.out.println("Sleeper bogie does not exist in the consist.");
        }

        // Step 5: Display final bogie list
        System.out.println("Final passenger bogie list: " + passengerBogies);
    }
}