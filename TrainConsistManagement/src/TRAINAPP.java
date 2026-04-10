import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ✅ Core Logic Class
    static class TrainConsistManager {

        public boolean binarySearchBogie(String[] bogies, String key) {

            // ✅ Handle empty array
            if (bogies == null || bogies.length == 0) {
                return false;
            }

            // ✅ Ensure sorted input (important precondition)
            Arrays.sort(bogies);

            int low = 0;
            int high = bogies.length - 1;

            // ✅ Binary Search Logic
            while (low <= high) {
                int mid = (low + high) / 2;

                int comparison = bogies[mid].compareTo(key);

                if (comparison == 0) {
                    return true; // Found
                } else if (comparison < 0) {
                    low = mid + 1; // Search right
                } else {
                    high = mid - 1; // Search left
                }
            }

            return false; // Not found
        }
    }

    // ✅ Test Cases

    @Test
    void testBinarySearch_BogieFound() {
        TrainConsistManager manager = new TrainConsistManager();

        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(manager.binarySearchBogie(bogies, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        TrainConsistManager manager = new TrainConsistManager();

        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        assertFalse(manager.binarySearchBogie(bogies, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        TrainConsistManager manager = new TrainConsistManager();

        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(manager.binarySearchBogie(bogies, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        TrainConsistManager manager = new TrainConsistManager();

        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(manager.binarySearchBogie(bogies, "BG550"));
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        TrainConsistManager manager = new TrainConsistManager();

        String[] bogies = {"BG101"};

        assertTrue(manager.binarySearchBogie(bogies, "BG101"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        TrainConsistManager manager = new TrainConsistManager();

        String[] bogies = {};

        assertFalse(manager.binarySearchBogie(bogies, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        TrainConsistManager manager = new TrainConsistManager();

        String[] bogies = {"BG309","BG101","BG550","BG205","BG412"};

        assertTrue(manager.binarySearchBogie(bogies, "BG205"));
    }
}
