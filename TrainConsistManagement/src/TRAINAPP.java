import java.util.*;
import java.util.stream.Collectors;

// Base class
class Bogie {
    private String bogieId;
    private int capacity;

    public Bogie(String bogieId, int capacity) {
        this.bogieId = bogieId;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Bogie ID: " + bogieId + " | Capacity: " + capacity;
    }
}

// Main Application
public class TRAINAPP {

    public static void main(String[] args) {

        List<Bogie> bogieList = new ArrayList<>();

        // 🔹 Create large dataset (for realistic benchmarking)
        for (int i = 1; i <= 100000; i++) {
            bogieList.add(new Bogie("B" + i, (i % 100) + 1));
        }

        System.out.println("Total Bogies: " + bogieList.size());

        // ============================
        // ✅ Loop-Based Filtering
        // ============================
        long startLoop = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogieList) {
            if (b.getCapacity() > 60) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // ============================
        // ✅ Stream-Based Filtering
        // ============================
        long startStream = System.nanoTime();

        List<Bogie> streamResult = bogieList.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // ============================
        // ✅ Output Results
        // ============================
        System.out.println("\n===== PERFORMANCE COMPARISON =====");

        System.out.println("Loop Filtering Time (ns): " + loopTime);
        System.out.println("Stream Filtering Time (ns): " + streamTime);

        System.out.println("\n===== RESULT VALIDATION =====");
        System.out.println("Loop Result Size: " + loopResult.size());
        System.out.println("Stream Result Size: " + streamResult.size());

        if (loopResult.size() == streamResult.size()) {
            System.out.println("✅ Both approaches produce SAME results");
        } else {
            System.out.println("❌ Results differ");
        }
    }
}