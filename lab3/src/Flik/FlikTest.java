package Flik;
import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {
    @Test
    public void testisSame() {
        /* assertEquals for comparison of ints takes two arguments:
        assertEquals(expected, actual).
        if it is false, then the assertion will be false, and this test will fail.
        */

        assertTrue(Flik.isSameNumber(3, 3));
        assertTrue(Flik.isSameNumber(7, 7));
        assertTrue(Flik.isSameNumber(39, 39));
        assertTrue(Flik.isSameNumber(128, 128));
//        assertFalse(Flik.isSameNumber(3, 128));
//        assertFalse(Flik.isSameNumber(3, 35));
    }
}
