import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

public class TRAINAPP {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App: Sort Bogies by Capacity ===\n");

        // ==========================
        // Create passenger bogies
        // ==========================
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 60));
        passengerBogies.add(new Bogie("First Class", 40));

        System.out.println("Passenger Bogies before sorting:");
        passengerBogies.forEach(System.out::println);

        // ==========================
        // Sort bogies by capacity (ascending)
        // ==========================
        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("\nPassenger Bogies after sorting by capacity:");
        passengerBogies.forEach(System.out::println);

        // ==========================
        // Sort bogies by capacity (descending)
        // ==========================
        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity).reversed());

        System.out.println("\nPassenger Bogies after sorting by capacity (descending):");
        passengerBogies.forEach(System.out::println);
    }
}