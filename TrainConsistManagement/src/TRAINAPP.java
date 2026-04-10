import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ✅ Core Logic Class
    static class TrainConsistManager {

        public int[] sortCapacities(int[] capacities) {

            int n = capacities.length;

            // ✅ Bubble Sort Logic
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {

                    if (capacities[j] > capacities[j + 1]) {
                        // ✅ Swap
                        int temp = capacities[j];
                        capacities[j] = capacities[j + 1];
                        capacities[j + 1] = temp;
                    }
                }
            }

            return capacities;
        }
    }

    // ✅ Test Cases

    @Test
    void testSort_BasicSorting() {
        TrainConsistManager manager = new TrainConsistManager();

        int[] input = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};

        assertArrayEquals(expected, manager.sortCapacities(input));
    }

    @Test
    void testSort_AlreadySortedArray() {
        TrainConsistManager manager = new TrainConsistManager();

        int[] input = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};

        assertArrayEquals(expected, manager.sortCapacities(input));
    }

    @Test
    void testSort_DuplicateValues() {
        TrainConsistManager manager = new TrainConsistManager();

        int[] input = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};

        assertArrayEquals(expected, manager.sortCapacities(input));
    }

    @Test
    void testSort_SingleElementArray() {
        TrainConsistManager manager = new TrainConsistManager();

        int[] input = {50};
        int[] expected = {50};

        assertArrayEquals(expected, manager.sortCapacities(input));
    }

    @Test
    void testSort_AllEqualValues() {
        TrainConsistManager manager = new TrainConsistManager();

        int[] input = {40, 40, 40};
        int[] expected = {40, 40, 40};

        assertArrayEquals(expected, manager.sortCapacities(input));
    }
}
