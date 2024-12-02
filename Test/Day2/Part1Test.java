package Day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Part1Test {

    Part1 p = new Part1();

    @Test
    public void isIncreasingTest() {
        assertTrue(p.isIncreasing(1, 10));
        assertFalse(p.isIncreasing(5, 1));
        assertFalse(p.isIncreasing(5, 5));
    }

    @Test
    public void differByOneToThreeTest() {
        assertTrue(p.differByOneToThree(2,5));
        assertFalse(p.differByOneToThree(2,6));
        assertTrue(p.differByOneToThree(6, 3));
    }

}
