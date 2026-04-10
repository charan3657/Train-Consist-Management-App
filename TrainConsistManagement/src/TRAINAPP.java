import java.util.Arrays;

// Main Application
public class TRAINAPP {

    public static void main(String[] args) {

        // ✅ Array of bogie type names
        String[] bogieNames = {
                "Sleeper",
                "AC Chair",
                "First Class",
                "General",
                "Luxury"
        };

        System.out.println("===== BEFORE SORTING =====");
        System.out.println(Arrays.toString(bogieNames));

        // ✅ Built-in Sorting
        Arrays.sort(bogieNames);

        System.out.println("\n===== AFTER SORTING =====");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nSorting completed using Arrays.sort().");
    }
}