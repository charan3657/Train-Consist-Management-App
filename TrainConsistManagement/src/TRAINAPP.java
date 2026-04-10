import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ✅ Core Logic Class
    static class TrainConsistManager {

        public String[] sortBogies(String[] bogies) {

            // ✅ Use built-in sorting
            Arrays.sort(bogies);

            return bogies;
        }
    }

    // ✅ Test Cases

    @Test
    void testSort_BasicAlphabeticalSorting() {
        TrainConsistManager manager = new TrainConsistManager();

        String[] input = {"Sleeper","AC Chair","First Class","General","Luxury"};
        String[] expected = {"AC Chair","First Class","General","Luxury","Sleeper"};

        assertArrayEquals(expected, manager.sortBogies(input));
    }

    @Test
    void testSort_UnsortedInput() {
        TrainConsistManager manager = new TrainConsistManager();

        String[] input = {"Luxury","General","Sleeper","AC Chair"};
        String[] expected = {"AC Chair","General","Luxury","Sleeper"};

        assertArrayEquals(expected, manager.sortBogies(input));
    }

    @Test
    void testSort_AlreadySortedArray() {
        TrainConsistManager manager = new TrainConsistManager();

        String[] input = {"AC Chair","First Class","General"};
        String[] expected = {"AC Chair","First Class","General"};

        assertArrayEquals(expected, manager.sortBogies(input));
    }

    @Test
    void testSort_DuplicateBogieNames() {
        TrainConsistManager manager = new TrainConsistManager();

        String[] input = {"Sleeper","AC Chair","Sleeper","General"};
        String[] expected = {"AC Chair","General","Sleeper","Sleeper"};

        assertArrayEquals(expected, manager.sortBogies(input));
    }

    @Test
    void testSort_SingleElementArray() {
        TrainConsistManager manager = new TrainConsistManager();

        String[] input = {"Sleeper"};
        String[] expected = {"Sleeper"};

        assertArrayEquals(expected, manager.sortBogies(input));
    }
}
