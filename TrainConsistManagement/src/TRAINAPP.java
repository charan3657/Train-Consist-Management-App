import java.util.*;

public class TRAINAPP {

    // ✅ Binary Search with Validation
    public static boolean searchBogie(String[] bogieIds, String key) {

        // 🔴 Fail-Fast Validation
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in the train to search.");
        }

        // Ensure sorted data (for Binary Search)
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;
            int result = bogieIds[mid].compareTo(key);

            if (result == 0) {
                return true; // ✅ Found
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false; // ❌ Not found
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 🔁 Change this array to test scenarios
        String[] bogieIds = {
                "BG101", "BG205", "BG309"
        };

        System.out.println("===== SAFE SEARCH SYSTEM =====");

        System.out.print("Enter Bogie ID to search: ");
        String searchKey = scanner.nextLine();

        try {
            boolean found = searchBogie(bogieIds, searchKey);

            if (found) {
                System.out.println("✅ Bogie ID " + searchKey + " FOUND.");
            } else {
                System.out.println("❌ Bogie ID " + searchKey + " NOT FOUND.");
            }

        } catch (IllegalStateException e) {

            // ✅ Graceful handling of fail-fast exception
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nProgram continues safely...");
    }
}