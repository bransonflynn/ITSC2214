import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Project1 testcases for debugging.
 * 
 * @author Branson Flynn
 * @version Jan 16, 2025
 */
public class Project1Test {

    private Project1 runner;

    /**
     * Initializes common references for tests.
     */
    @Before
    public void setup() {
        runner = new Project1(4);
        runner.addValue(1);
        runner.addValue(2);
        runner.addValue(3);
        runner.addValue(4);
    }

    /**
     * General test case.
     */
    @Test
    public void testOne() {
        // assertNotNull(runner);
        assertFalse(runner.isEmpty());
        assertEquals(4, runner.size());
    }

    /**
     * General test case.
     */
    @Test
    public void testTwo() {
        assertEquals(runner.getMinimum(), 1);
        assertEquals(runner.getMaximum(), 4);
        assertEquals(runner.getAverage(), 2.5, 0.0);
        assertEquals(runner.getRange(), 3);
        assertEquals(runner.getMedian(), 2.5, 0.0);
        assertEquals(runner.getSize(), 4);
        assertEquals(runner.getCapacity(), 4);
        assertEquals(runner.getValue(1), 2);
        assertEquals(runner.setValue(0, 1), 1);
        assertNotNull(runner);
        assertFalse(runner.isEmpty());
        assertTrue(runner.isFull());
        assertFalse(runner.hasDuplicates());
    }

    /**
     * Test cases for getter methods.
     */
    @Test
    public void testGetters() {
        assertNotNull(runner.getArr());
        assertNotNull(runner.getCapacity());
        assertNotNull(runner.getSize());
    }

    /**
     * Test cases for getMinimum.
     */
    @Test
    public void testGetMinimum() {
        assertEquals(runner.getMinimum(), 1);

        runner = new Project1(3);
        assertEquals(runner.getMinimum(), Integer.MIN_VALUE);

        runner = new Project1(3);
        runner.addValue(3);
        runner.addValue(2);
        runner.addValue(1);
        assertEquals(runner.getMinimum(), 1);
    }

    /**
     * Test cases for getMaximum.
     */
    @Test
    public void testGetMaximum() {
        assertEquals(runner.getMaximum(), 4);

        runner = new Project1(3);
        assertEquals(runner.getMaximum(), Integer.MAX_VALUE);

        runner = new Project1(3);
        runner.addValue(3);
        runner.addValue(2);
        runner.addValue(1);
        assertEquals(runner.getMaximum(), 3);
    }

    /**
     * Test cases for getAverage.
     */
    @Test
    public void testGetAverage() {
        assertEquals(runner.getAverage(), 2.5, 0.0);
    }

    /**
     * Test cases for getAverage where an exception would be thrown.
     */
    @Test(expected = IllegalStateException.class)
    public void testGetAverageThrows() {
        Project1 runner = new Project1(1);
        runner.getAverage(); // throws IllegalStateException
    }

    /**
     * Test cases for range calculation.
     */
    @Test
    public void testGetRange() {
        assertEquals(runner.getRange(), 3);
    }

    /**
     * Test cases for getMedian calculation.
     */
    @Test
    public void testGetMedian() {
        assertEquals(runner.getMedian(), 2.5, 0.0);

        runner = new Project1(3);
        runner.addValue(1);
        runner.addValue(2);
        runner.addValue(3);
        assertEquals(runner.getMedian(), 2, 0.0);
    }

    /**
     * Test cases for size equality.
     */
    @Test
    public void testSize() {
        assertEquals(runner.size(), runner.getSize());
    }

    /**
     * Test cases for Capacity.
     */
    @Test
    public void testCapacity() {
        assertEquals(runner.capacity(), runner.getCapacity());
    }

    /**
     * Test cases for addValue where an exception would be thrown.
     */
    @Test(expected = IllegalStateException.class)
    public void testAddValueThrows() {
        Project1 runner = new Project1(0);
        runner.addValue(5); // throws IllegalStateException
    }

    /**
     * Test cases for getValue where an exception would be thrown.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetValueThrows1() {
        Project1 runner = new Project1(4);
        runner.getValue(6); // throws IndexOutOfBoundsException
    }

    /**
     * Test cases for getValue where an exception would be thrown.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetValueThrows2() {
        Project1 runner = new Project1(4);
        runner.getValue(-1); // throws IndexOutOfBoundsException
    }

    /**
     * Test cases for setValue where an exception would be thrown.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetValueThrows1() {
        Project1 runner = new Project1(4);
        runner.setValue(6, 2); // throws IndexOutOfBoundsException
    }

    /**
     * Test cases for setValue where an exception would be thrown.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetValueThrows2() {
        Project1 runner = new Project1(4);
        runner.setValue(-1, 2); // throws IndexOutOfBoundsException
    }

    /**
     * Test cases for addRandom.
     */
    @Test
    public void testAddRandom() {
        runner = new Project1(1);
        runner.addRandom(1);
    }

    /**
     * Test cases for addRandom where an exception would be thrown.
     */
    @Test(expected = IllegalStateException.class)
    public void testAddRandomThrows1() {
        Project1 runner = new Project1(3);
        runner.addRandom(6); // throws IllegalStateException
    }

    /**
     * Test cases for addRandom where an exception would be thrown.
     */
    @Test(expected = IllegalStateException.class)
    public void testAddRandomThrow2() {
        Project1 runner = new Project1(1);
        runner.addRandom(1);
        runner.addRandom(1); // throws IllegalStateException
    }

    /**
     * Test cases for removeValueAt.
     */
    @Test
    public void testRemoveValueAt() {
        assertEquals(runner.size(), 4);
        runner.removeValueAt(1);
        assertEquals(runner.size(), 3);
    }

    /**
     * Test cases for removeValueAt where an exception would be thrown.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveValueAtThrows1() {
        Project1 runner = new Project1(5);
        runner.removeValueAt(6); // throws IndexOutOfBoundsException

    }

    /**
     * Test cases for removeValueAt where an exception would be thrown.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveValueAtThrows2() {
        Project1 runner = new Project1(5);
        runner.removeValueAt(-1); // throws IndexOutOfBoundsException

    }

    /**
     * Test cases for isEmpty.
     */
    @Test
    public void testIsEmpty() {
        assertFalse(runner.isEmpty());
        Project1 runner = new Project1(1);
        assertTrue(runner.isEmpty());
    }

    /**
     * Test cases for isFull.
     */
    @Test
    public void testIsFull() {
        // assertTrue(runner.isFull());
        runner = new Project1(2);
        assertFalse(runner.isFull());
    }

    /**
     * Test cases for hasDuplicates.
     */
    @Test
    public void testHasDuplicates() {
        Project1 runner = new Project1(5);
        runner.addValue(1);
        runner.addValue(2);
        runner.addValue(3);
        runner.addValue(4);
        assertFalse(runner.hasDuplicates());
        runner.addValue(4);
        assertTrue(runner.hasDuplicates());
    }
}
