import java.util.*;
import java.util.regex.*;

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

    public abstract String getCategory();

    @Override
    public String toString() {
        return "Bogie ID: " + bogieId +
                " | Category: " + getCategory() +
                " | Capacity: " + capacity;
    }
}

// Passenger Bogie
class PassengerBogie extends Bogie {
    private String category;

    public PassengerBogie(String bogieId, String category, int capacity) {
        super(bogieId, capacity);
        this.category = category;
    }

    @Override
    public String getCategory() {
        return category;
    }
}

// Goods Bogie
class GoodsBogie extends Bogie {
    private String cargoType;

    public GoodsBogie(String bogieId, String cargoType, int capacity) {
        super(bogieId, capacity);
        this.cargoType = cargoType;
    }

    @Override
    public String getCategory() {
        return cargoType;
    }
}

// Main Application
public class TRAINAPP {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ✅ Regex Patterns
        Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

        // User Input
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // Validation using Matcher
        Matcher trainMatcher = trainPattern.matcher(trainId);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        boolean isTrainValid = trainMatcher.matches();
        boolean isCargoValid = cargoMatcher.matches();

        // Output Results
        System.out.println("\n===== VALIDATION RESULT =====");

        if (isTrainValid) {
            System.out.println("Train ID is VALID");
        } else {
            System.out.println("Train ID is INVALID");
        }

        if (isCargoValid) {
            System.out.println("Cargo Code is VALID");
        } else {
            System.out.println("Cargo Code is INVALID");
        }

        // Continue Program (Sample Bogie List)
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new PassengerBogie("B1", "Sleeper", 72));
        bogieList.add(new PassengerBogie("B2", "AC Chair", 60));
        bogieList.add(new GoodsBogie("G1", "Cylindrical", 100));

        System.out.println("\n===== SAMPLE BOGIES =====");
        bogieList.forEach(System.out::println);

        scanner.close();
    }
}