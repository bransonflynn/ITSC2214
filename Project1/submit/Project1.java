import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import itsc2214.ArrayInt;

/**
 * This is an int[] wrapper class for ITSC2214 Project1.
 * 
 * @author Branson Flynn
 * @version Jan 16, 2025
 */

public class Project1 implements ArrayInt {

    // instance variables
    private int[] arr;
    private final int capacity;
    private int size;

    /**
     * Class constructor.
     * 
     * @param capacity The maximum capacity of elements in the created instance.
     */
    public Project1(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * Getter method for arr.
     * 
     * @return The internal array of this instance.
     */
    public int[] getArr() {
        return this.arr;
    }

    /**
     * Getter method for capacity.
     * 
     * @return The capacity of this instance.
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Getter method for size.
     * 
     * @return The size of this instance.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Finds the smallest item in the internal array.
     * 
     * @return Populated internal array returns the smallest number in the internal
     *         array.
     *         Empty internal array returns Integer.MIN_VALUE.
     */
    public int getMinimum() {
        if (this.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < this.size(); i++) {
            if (arr[i] < result) {
                result = arr[i];
            }
        }
        return result;
    }

    /**
     * Finds the largest item in the internal array.
     * 
     * @return Populated internal array returns the largest number in the internal
     *         array.
     *         Empty internal array returns Integer.MAX_VALUE.
     */
    public int getMaximum() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < this.size(); i++) {
            if (arr[i] > result) {
                result = arr[i];
            }
        }
        return result;
    }

    /**
     * Computes the average of all values in the internal array. The last division
     * operation is how the average is found.
     * 
     * @return The average of all values in the internal array.
     * @throws IllegalStateException The array was empty.
     */
    public double getAverage() throws IllegalStateException {
        if (this.isEmpty()) {
            throw new IllegalStateException("The array was empty.");
        }

        double result = 0.0;
        for (int i = 0; i < this.size(); i++) {
            result += arr[i];
        }
        result /= (double) size();
        return result;
    }

    /**
     * Computes the arithmetic difference between the largest and smallest value in
     * the internal array.
     * 
     * @return The arithmetic difference between the smallest and largest value in
     *         the internal array.
     */
    public int getRange() {
        return this.getMaximum() - this.getMinimum();
    }

    /**
     * Finds and computes the middle number within a sorted version of the internal
     * array. Does not modify the existing internal array.
     * 
     * @return The number that was found (or averaged from) the middle values within
     *         a sorted copy of the internal array.
     */
    public double getMedian() {
        int[] arrSorted = Arrays.copyOf(arr, size);
        Arrays.sort(arrSorted);

        int len = arrSorted.length;
        if (len % 2 != 0) { // odd
            return (double) arrSorted[len / 2];
        } else { // even
            return (double) (arrSorted[(len - 1) / 2] + arrSorted[len / 2]) / 2.0;
        }
    }

    /**
     * Returns the size of (number of elements within) the internal array.
     * 
     * @return The number of elements stored in the internal array.
     */
    @Override
    public int size() {
        return this.getSize();
    }

    /**
     * Returns the capacity of the internal array. This is how big the array is, not
     * how many elements are stored in it.
     * 
     * @return The size of the array, that is how big the array is, not how many
     *         elements are stored in it.
     */
    public int capacity() {
        return this.getCapacity();
    }

    /**
     * Appends a value to the internal array. Does not grow the length of the
     * internal array.
     * 
     * @param value The new value to append to the internal array.
     * @throws IllegalStateException The array was full.
     */
    @Override
    public void addValue(int value) throws IllegalStateException {
        if (this.isFull()) {
            throw new IllegalStateException("The array was full.");
        }

        arr[this.size()] = value;
        size++;
    }

    /**
     * Returns the value at the provided index of the internal array.
     * 
     * @param index The position to return the value from.
     * @return The value at the provided index.
     * @throws IndexOutOfBoundsException The provided position at index was not
     *                                   valid.
     */
    @Override
    public int getValue(int index) throws IndexOutOfBoundsException {
        if (index >= this.size() || index < 0) {
            throw new IndexOutOfBoundsException(
                    "The provided position at the index was not valid.");
        }
        return arr[index];
    }

    /**
     * Sets the value at the position index of the array.
     * 
     * @param index The index to place the value at.
     * @param value The new value to assign to index.
     * @return The value that was previusly at index.
     * @throws IndexOutOfBoundsException The provided position at index was not
     *                                   valid.
     */
    @Override
    public int setValue(int index, int value) throws IndexOutOfBoundsException {
        if (index >= this.size() || index < 0) {
            throw new IndexOutOfBoundsException(
                    "The provided position at the index was not valid.");
        }

        int result = arr[index];
        arr[index] = value;
        return result;
    }

    /**
     * Adds a random set of n numbers to the end of the internal array.
     * 
     * @param n The amount of random numbers to add.
     * @throws IllegalStateException The array was full.
     */
    @Override
    public void addRandom(int n) throws IllegalStateException {
        if (this.isFull()) {
            throw new IllegalStateException("The array was full.");
        }

        // config options for random num generation
        int min = -1000;
        int max = 1000;
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            if (!this.isFull()) {
                int val = rand.nextInt(max - min + 1) + min;
                this.addValue(val);
            } else {
                throw new IllegalStateException("The array was full.");
            }
        }
    }

    /**
     * Deletes the value at the provided index.
     * 
     * @param index The position to return the value from.
     * @throws IndexOutOfBoundsException The provided position at index was not
     *                                   valid.
     */
    @Override
    public void removeValueAt(int index) throws IndexOutOfBoundsException {
        if (index >= this.size() || index < 0) {
            throw new IndexOutOfBoundsException(
                    "The provided position at the index was not valid.");
        }

        for (int i = index; i < this.capacity() - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    /**
     * Checks if the array is considered empty.
     * The method body is the same as the original overridden function, it's just
     * here for clarity.
     * 
     * @return True if the array is empty.
     *         False if the array is not empty.
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Returns true if the array is full. The array is considered full if size and
     * capacity are equal.
     * 
     * @return True if the internal array is considered full.
     *         False if the internal array is not considered full.
     */
    @Override
    public boolean isFull() {
        return this.size() == this.capacity();
    }

    /**
     * Checks if the array has any duplicate values by populating and iterating
     * through a HashMap, then checking keys within the map. This approach is a
     * faster alternative to a recursive for loop.
     * 
     * @return True if the internal array has duplicate values.
     *         False if the array has no duplicate values.
     */
    @Override
    public boolean hasDuplicates() {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < this.size(); i++) {
            if (map.containsKey(arr[i])) {
                return true;
            } else {
                map.put(arr[i], 1);
            }
        }
        return false;
    }

    /**
     * Debug-only method that returns the internal array as a formatted and readable
     * string so it can be printed to console for testing.
     * 
     * @return The formatted string representation of the internal array.
     */
    // @Ignore
    // public String arrToString(boolean sorted) {
    // int[] arrCopy = Arrays.copyOf(arr, size);
    // if (sorted == true)
    // Arrays.sort(arrCopy);
    // String result = "\n[";
    // for (int i = 0; i < arrCopy.length; i++) {
    // result += arrCopy[i];
    // if (i < arrCopy.length - 1) {
    // result += ", ";
    // }
    // }
    // return result += "]\n";
    // }
}
