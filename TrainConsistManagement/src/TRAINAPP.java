import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ✅ Core Logic Class
    static class TrainConsistManager {

        public boolean linearSearchBogie(String[] bogies, String key) {

            // ✅ Traverse array sequentially
            for (String bogie : bogies) {
                if (bogie.equals(key)) {
                    return true; // Found → early termination
                }
            }

            return false; // Not found after full traversal
        }
    }

    // ✅ Test Cases

    @Test
    void testSearch_BogieFound() {
        TrainConsistManager manager = new TrainConsistManager();

        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(manager.linearSearchBogie(bogies, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        TrainConsistManager manager = new TrainConsistManager();

        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        assertFalse(manager.linearSearchBogie(bogies, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        TrainConsistManager manager = new TrainConsistManager();

        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(manager.linearSearchBogie(bogies, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        TrainConsistManager manager = new TrainConsistManager();

        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(manager.linearSearchBogie(bogies, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        TrainConsistManager manager = new TrainConsistManager();

        String[] bogies = {"BG101"};

        assertTrue(manager.linearSearchBogie(bogies, "BG101"));
    }
}
