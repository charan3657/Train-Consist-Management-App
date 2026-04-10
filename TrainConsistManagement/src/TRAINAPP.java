import java.util.*;

// ✅ Custom Exception Class
class InvalidCapacityException extends Exception {

    public InvalidCapacityException(String message) {
        super(message);
    }
}

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

    public abstract String getType();

    @Override
    public String toString() {
        return "Bogie ID: " + bogieId +
                " | Type: " + getType() +
                " | Capacity: " + capacity;
    }
}

// ✅ Passenger Bogie with Validation
class PassengerBogie extends Bogie {

    private String category;

    public PassengerBogie(String bogieId, String category, int capacity)
            throws InvalidCapacityException {

        super(bogieId, capacity);

        // 🔴 Validation (Fail-Fast)
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }

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

        List<Bogie> bogieList = new ArrayList<>();

        System.out.println("===== CREATING BOGIES =====");

        try {
            // ✅ Valid Bogies
            bogieList.add(new PassengerBogie("B1", "Sleeper", 72));
            bogieList.add(new PassengerBogie("B2", "AC Chair", 60));

            // ❌ Invalid Bogie (will throw exception)
            bogieList.add(new PassengerBogie("B3", "First Class", -10));

        } catch (InvalidCapacityException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        // Continue program execution
        System.out.println("\n===== VALID BOGIES IN TRAIN =====");
        bogieList.forEach(System.out::println);
    }
}