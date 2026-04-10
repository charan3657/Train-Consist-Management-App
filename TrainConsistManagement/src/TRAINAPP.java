import java.util.*;

// ✅ Custom Runtime Exception
class CargoSafetyException extends RuntimeException {

    public CargoSafetyException(String message) {
        super(message);
    }
}

// Base Bogie class
abstract class Bogie {
    protected String bogieId;

    public Bogie(String bogieId) {
        this.bogieId = bogieId;
    }

    public String getBogieId() {
        return bogieId;
    }

    public abstract String getType();
}

// ✅ Goods Bogie Class
class GoodsBogie extends Bogie {

    private String shape;   // Rectangular / Cylindrical
    private String cargo;   // Coal / Grain / Petroleum

    public GoodsBogie(String bogieId, String shape) {
        super(bogieId);
        this.shape = shape;
    }

    public void assignCargo(String cargo) {

        try {
            // 🔴 Validation Rule
            if (shape.equalsIgnoreCase("Rectangular") &&
                    cargo.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "Unsafe Assignment: Petroleum cannot be loaded in Rectangular bogie"
                );
            }

            // ✅ Safe assignment
            this.cargo = cargo;
            System.out.println("Cargo assigned successfully to Bogie " + bogieId);

        } catch (CargoSafetyException e) {

            // ✅ Handle exception gracefully
            System.out.println("Error: " + e.getMessage());

        } finally {

            // ✅ Always executes
            System.out.println("Cargo assignment attempt completed for Bogie " + bogieId);
        }
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String getType() {
        return "Goods - " + shape;
    }

    @Override
    public String toString() {
        return "Bogie ID: " + bogieId +
                " | Type: " + getType() +
                " | Cargo: " + (cargo != null ? cargo : "Not Assigned");
    }
}

// ✅ Main Application
public class TRAINAPP {

    public static void main(String[] args) {

        List<GoodsBogie> bogies = new ArrayList<>();

        // Create bogies
        GoodsBogie b1 = new GoodsBogie("G1", "Cylindrical");
        GoodsBogie b2 = new GoodsBogie("G2", "Rectangular");

        bogies.add(b1);
        bogies.add(b2);

        System.out.println("===== CARGO ASSIGNMENT =====");

        // ✅ Safe assignment
        b1.assignCargo("Petroleum");

        // ❌ Unsafe assignment (handled safely)
        b2.assignCargo("Petroleum");

        // Program continues
        System.out.println("\n===== FINAL BOGIE STATUS =====");
        bogies.forEach(System.out::println);

        System.out.println("\nProgram continues without crashing...");
    }
}