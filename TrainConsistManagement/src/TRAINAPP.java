import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ✅ Core Logic Class
    static class TrainConsistManager {

        private List<String> bogies;

        public TrainConsistManager(List<String> bogies) {
            this.bogies = bogies;
        }

        public boolean searchBogie(String bogieId) {
            // ✅ Fail-Fast Validation
            if (bogies == null || bogies.isEmpty()) {
                throw new IllegalStateException(
                        "Search operation failed: No bogies available in the train."
                );
            }

            // ✅ Search Logic
            for (String bogie : bogies) {
                if (bogie.equals(bogieId)) {
                    return true;
                }
            }
            return false;
        }
    }

    // ✅ Test Cases

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        TrainConsistManager manager = new TrainConsistManager(Collections.emptyList());

        assertThrows(IllegalStateException.class, () -> {
            manager.searchBogie("BG101");
        });
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        TrainConsistManager manager = new TrainConsistManager(
                Arrays.asList("BG101", "BG205")
        );

        assertDoesNotThrow(() -> {
            manager.searchBogie("BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        TrainConsistManager manager = new TrainConsistManager(
                Arrays.asList("BG101", "BG205", "BG309")
        );

        assertTrue(manager.searchBogie("BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        TrainConsistManager manager = new TrainConsistManager(
                Arrays.asList("BG101", "BG205", "BG309")
        );

        assertFalse(manager.searchBogie("BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        TrainConsistManager manager = new TrainConsistManager(
                Arrays.asList("BG101")
        );

        assertTrue(manager.searchBogie("BG101"));
    }
}
