import java.util.LinkedHashSet;

public class TRAINAPP {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: Preserve Insertion Order ===\n");

        // ==========================
        // Initialize LinkedHashSet for train formation
        // ==========================
        LinkedHashSet<String> trainFormation = new LinkedHashSet<>();

        // Attach bogies in sequence
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        System.out.println("Initial train formation: " + trainFormation);

        // Attempt to attach a duplicate bogie
        boolean added = trainFormation.add("Sleeper"); // This will be ignored
        if (!added) {
            System.out.println("Duplicate bogie 'Sleeper' not added.");
        }

        // Display final formation
        System.out.println("Final train formation (insertion order preserved, no duplicates): " + trainFormation);
    }
}