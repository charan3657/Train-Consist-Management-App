import java.util.*;

// Main Application
public class TRAINAPP {

    // ✅ Linear Search Method
    public static boolean linearSearch(String[] bogieIds, String key) {

        for (int i = 0; i < bogieIds.length; i++) {

            // 🔍 Compare using equals()
            if (bogieIds[i].equals(key)) {
                return true; // ✅ Found → stop early
            }
        }

        return false; // ❌ Not found after full traversal
    }

    public static void main(String[] args) {

        // ✅ Array of Bogie IDs (unsorted)
        String[] bogieIds = {
                "BG101", "BG205", "BG309", "BG412", "BG550"
        };

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== BOGIE SEARCH SYSTEM =====");
        System.out.println("Available Bogies: " + Arrays.toString(bogieIds));

        // 🔎 User input
        System.out.print("Enter Bogie ID to search: ");
        String searchKey = scanner.nextLine();

        // Perform Linear Search
        boolean found = linearSearch(bogieIds, searchKey);

        // Display Result
        if (found) {
            System.out.println("✅ Bogie ID " + searchKey + " FOUND in the train consist.");
        } else {
            System.out.println("❌ Bogie ID " + searchKey + " NOT FOUND.");
        }

        System.out.println("\nSearch operation completed.");
    }
}