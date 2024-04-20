/**
 * To test with JUnit, add JUnit to your project. To do this, go to
 * Project->Properties. Select "Java Build Path". Select the "Libraries"
 * tab and "Add Library". Select JUnit, then JUnit 4.
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    @Test
    public void test() {
        judgeDemoTest();
    }

    @Test
    public void judgeDemoTest() {
        Judge judge = new Judge();
        assertEquals(judge.score("AAA", "AAA"), 6);
        assertEquals(judge.score("GA_TCGGCA_T_", "CAAT_GTGAATC"), 0);
        assertEquals(judge.score("__", "___"), -2);

    }

}
