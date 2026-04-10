import java.util.*;

// Base class
abstract class Bogie {
    protected String bogieId;
    protected int capacity;

    public Bogie(String bogieId, int capacity) {
        this.bogieId = bogieId;
        this.capacity = capacity;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return "Bogie ID: " + bogieId +
                " | Type: " + getType() +
                " | Capacity: " + capacity;
    }
}

// Goods Bogie
class GoodsBogie extends Bogie {

    private String type;   // Cylindrical / Rectangular / Open / Box
    private String cargo;  // Petroleum / Coal / Grain etc.

    public GoodsBogie(String bogieId, String type, String cargo, int capacity) {
        super(bogieId, capacity);
        this.type = type;
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString() + " | Cargo: " + cargo;
    }
}

// Main Application
public class TRAINAPP {

    public static void main(String[] args) {

        List<GoodsBogie> goodsBogies = new ArrayList<>();

        // Sample Data
        goodsBogies.add(new GoodsBogie("G1", "Cylindrical", "Petroleum", 100));
        goodsBogies.add(new GoodsBogie("G2", "Rectangular", "Coal", 120));
        goodsBogies.add(new GoodsBogie("G3", "Cylindrical", "Petroleum", 90));

        // Try invalid case:
        // goodsBogies.add(new GoodsBogie("G4", "Cylindrical", "Coal", 80));

        System.out.println("===== GOODS BOGIES =====");
        goodsBogies.forEach(System.out::println);

        // ✅ UC12: Safety Compliance Check
        boolean isSafe = goodsBogies.stream()
                .allMatch(b ->
                        // Rule: Cylindrical → only Petroleum
                        !b.getType().equalsIgnoreCase("Cylindrical") ||
                                b.getCargo().equalsIgnoreCase("Petroleum")
                );

        System.out.println("\n===== SAFETY VALIDATION RESULT =====");

        if (isSafe) {
            System.out.println("Train is SAFE for operation ✅");
        } else {
            System.out.println("Train is NOT SAFE ❌ (Invalid cargo in cylindrical bogie)");
        }
    }
}