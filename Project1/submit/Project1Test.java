import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Project1 testcases for debugging.
 * 
 * @author Branson Flynn
 * @version Jan 16, 2025
 */
public class Project1Test {

    private Project1 runnerEven;
    private Project1 runnerOdd;
    private Project1 runnerEmpty;

    @Before
    public void setup() {
        runnerEven = new Project1(4);
        runnerEven.addValue(2);
        runnerEven.addValue(20);
        runnerEven.addValue(6);
        runnerEven.addValue(13);

        runnerOdd = new Project1(3);
        runnerOdd.addValue(3);
        runnerOdd.addValue(10);
        runnerOdd.addValue(12);

        runnerEmpty = new Project1(5);
    }

    @Test
    public void testOne() {
        assertNotNull(runnerEven);
        // assertFalse(runnerEven.isEmpty()); // better be empty
        // assertFalse(runnerEven.isFull()); // better NOT be full

        assertFalse(runnerEven.isEmpty());
        assertEquals(4, runnerEven.size());
    }

    @Test
    public void testTwo() {
        Project1 runnerLocal = new Project1(4);
        assertNotNull(runnerLocal);
        runnerLocal.addValue(1);
        runnerLocal.addValue(2);
        runnerLocal.addValue(3);
        runnerLocal.addValue(3);

        assertEquals(runnerLocal.getMinimum(), 1);
        assertEquals(runnerLocal.getMaximum(), 3);
        assertEquals(runnerLocal.getAverage(), 2.25, 0.0);
        assertEquals(runnerLocal.getRange(), 2);
        assertEquals(runnerLocal.getMedian(), 2.5, 0.0);
        assertEquals(runnerLocal.getSize(), 4);
        assertEquals(runnerLocal.getCapacity(), 4);
        assertEquals(runnerLocal.getValue(1), 2);
        assertEquals(runnerLocal.setValue(0, 1), 1);
        assertNotNull(runnerLocal);
        assertFalse(runnerLocal.isEmpty());
        assertTrue(runnerLocal.isFull());
        assertTrue(runnerLocal.hasDuplicates());
    }

    @Test
    public void testGetters() {
        assertNotNull(runnerEven.getArr());
        assertNotNull(runnerEven.getCapacity());
        assertNotNull(runnerEven.getSize());
    }

    @Test
    public void testGetMinimum() {
        assertEquals(runnerEmpty.getMinimum(), Integer.MIN_VALUE);
        runnerEmpty.addValue(1);
        runnerEmpty.addValue(5);
        runnerEmpty.addValue(10);
        assertEquals(runnerEmpty.getMinimum(), 1);
    }

    @Test
    public void testGetMaximum() {
        assertEquals(runnerEmpty.getMaximum(), Integer.MAX_VALUE);
        runnerEmpty.addValue(1);
        runnerEmpty.addValue(5);
        runnerEmpty.addValue(10);
        assertEquals(runnerEmpty.getMaximum(), 10);
    }

    @Test
    public void testGetAverage() {
        assertEquals(runnerEven.getAverage(), 10.25, 0.0);
    }

    @Test(expected = IllegalStateException.class)
    public void testGetAverageThrows() {
        runnerEmpty.getAverage(); // throws IllegalStateException
    }

    @Test
    public void testGetRange() {
        assertEquals(runnerEven.getRange(), 18);
    }

    @Test
    public void testGetMedian() {
        Project1 runnerEvenEven = new Project1(2);
        runnerEvenEven.addValue(2);
        runnerEvenEven.addValue(4);

        Project1 runnerEvenOdd = new Project1(3);
        runnerEvenOdd.addValue(1);
        runnerEvenOdd.addValue(3);
        runnerEvenOdd.addValue(5);

        assertEquals(runnerEvenEven.getMedian(), 3.0, 0.0);
        assertEquals(runnerEvenOdd.getMedian(), 3.0, 0.0);
    }

    @Test
    public void testSize() {
        assertEquals(runnerEven.size(), runnerEven.getSize());
    }

    @Test
    public void testCapacity() {
        assertEquals(runnerEven.capacity(), runnerEven.getCapacity());
    }

    @Test(expected = IllegalStateException.class)
    public void testAddValueThrows() {
        runnerEven.addValue(5); // throws IllegalStateException
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetValueThrows1() {
        runnerEmpty.getValue(6); // throws IndexOutOfBoundsException
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetValueThrows2() {
        runnerEmpty.getValue(-1); // throws IndexOutOfBoundsException
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetValueThrows1() {
        runnerEven.setValue(6, 2); // throws IndexOutOfBoundsException
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetValueThrows2() {
        runnerEven.setValue(-1, 2); // throws IndexOutOfBoundsException
    }

    @Test(expected = IllegalStateException.class)
    public void testAddRandomThrows() {
        runnerEven.addRandom(6); // throws IllegalStateException
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveValueAtThrows1() {
        runnerEven.removeValueAt(6); // throws IndexOutOfBoundsException
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveValueAtThrows2() {
        runnerEven.removeValueAt(-1); // throws IndexOutOfBoundsException
    }

    @Test
    public void testIsEmpty() {
        Project1 runnerEven = new Project1(5);
        assertTrue(runnerEven.isEmpty());
        runnerEven.addValue(1);
        assertFalse(runnerEven.isEmpty());
    }

    @Test
    public void testIsFull() {
        Project1 runnerEven = new Project1(1);
        assertFalse(runnerEven.isFull());
        runnerEven.addValue(1);
        assertTrue(runnerEven.isFull());
    }

    @Test
    public void testHasDuplicates() {
        Project1 runnerEven = new Project1(5);
        runnerEven.addValue(1);
        runnerEven.addValue(2);
        runnerEven.addValue(3);
        runnerEven.addValue(4);
        assertFalse(runnerEven.hasDuplicates());
        runnerEven.addValue(4);
        assertTrue(runnerEven.hasDuplicates());
    }
}
