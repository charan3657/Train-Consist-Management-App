// Passenger Bogie Class
class PassengerBogie {

    private String bogieId;
    private int capacity;

    public PassengerBogie(String bogieId, int capacity) {
        this.bogieId = bogieId;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getBogieId() {
        return bogieId;
    }

    @Override
    public String toString() {
        return "Bogie ID: " + bogieId + " | Capacity: " + capacity;
    }
}

// Main Application
public class TRAINAPP {

    // ✅ Bubble Sort Method
    public static void bubbleSort(int[] capacities) {

        int n = capacities.length;

        for (int i = 0; i < n - 1; i++) {

            // Optimization: track if swap happens
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                // 🔴 Compare adjacent elements
                if (capacities[j] > capacities[j + 1]) {

                    // 🔁 Swap
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no swaps → already sorted
            if (!swapped) {
                break;
            }
        }
    }

    // Utility method to print array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Sample passenger bogie capacities
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("===== BEFORE SORTING =====");
        printArray(capacities);

        // Perform Bubble Sort
        bubbleSort(capacities);

        System.out.println("\n===== AFTER SORTING =====");
        printArray(capacities);

        System.out.println("\nSorting completed using Bubble Sort algorithm.");
    }
}