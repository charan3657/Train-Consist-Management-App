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

    public abstract String getType();

    @Override
    public String toString() {
        return "Bogie ID: " + bogieId +
                " | Type: " + getType() +
                " | Capacity: " + capacity;
    }
}

// Passenger Bogie class
class PassengerBogie extends Bogie {

    private String category; // Sleeper, AC Chair, First Class

    public PassengerBogie(String bogieId, String category, int capacity) {
        super(bogieId, capacity);
        this.category = category;
    }

    @Override
    public String getType() {
        return "Passenger - " + category;
    }
}

// Main Application
public class TRAINAPP {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Bogie> bogieList = new ArrayList<>();

        // Sample data (reuse from UC7 concept)
        bogieList.add(new PassengerBogie("B1", "Sleeper", 72));
        bogieList.add(new PassengerBogie("B2", "AC Chair", 60));
        bogieList.add(new PassengerBogie("B3", "First Class", 50));
        bogieList.add(new PassengerBogie("B4", "Sleeper", 80));
        bogieList.add(new PassengerBogie("B5", "AC Chair", 65));

        System.out.println("===== ALL BOGIES =====");
        bogieList.forEach(System.out::println);

        // UC8: Stream Filtering
        System.out.print("\nEnter capacity threshold: ");
        int threshold = scanner.nextInt();

        List<Bogie> filteredBogies = bogieList.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());

        System.out.println("\n===== FILTERED BOGIES (Capacity > " + threshold + ") =====");

        if (filteredBogies.isEmpty()) {
            System.out.println("No bogies match the given condition.");
        } else {
            filteredBogies.forEach(System.out::println);
        }

        // Verify original list unchanged
        System.out.println("\n===== ORIGINAL LIST (UNCHANGED) =====");
        bogieList.forEach(System.out::println);

        scanner.close();
    }
}