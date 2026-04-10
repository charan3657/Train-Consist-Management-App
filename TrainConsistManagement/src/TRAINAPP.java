import java.util.*;

public class TRAINAPP {

    // ✅ Binary Search Method
    public static boolean binarySearch(String[] bogieIds, String key) {

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {

            // Calculate mid index
            int mid = (low + high) / 2;

            // 🔍 Compare using compareTo()
            int result = bogieIds[mid].compareTo(key);

            if (result == 0) {
                return true; // ✅ Found
            } else if (result < 0) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }

        return false; // ❌ Not found
    }

    public static void main(String[] args) {

        // ✅ Unsorted input (will be sorted first)
        String[] bogieIds = {
                "BG309", "BG101", "BG550", "BG205", "BG412"
        };

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== BINARY SEARCH SYSTEM =====");

        // ✅ Ensure sorted order (Precondition)
        Arrays.sort(bogieIds);

        System.out.println("Sorted Bogies: " + Arrays.toString(bogieIds));

        // 🔎 User input
        System.out.print("Enter Bogie ID to search: ");
        String searchKey = scanner.nextLine();

        // Perform Binary Search
        boolean found = binarySearch(bogieIds, searchKey);

        // Display result
        if (found) {
            System.out.println("✅ Bogie ID " + searchKey + " FOUND.");
        } else {
            System.out.println("❌ Bogie ID " + searchKey + " NOT FOUND.");
        }

        System.out.println("\nSearch completed using Binary Search.");
    }
}