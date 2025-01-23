/**
 * TODO Write a one-sentence summary of your here.
 * TODO Follow it with additional details about its purpose, what abstraction
 * it represents, and how to use it.
 * 
 * @author Branson Flynn
 * @version Jan 23, 2025
 */
public class App {
    // note todo - create instance of project1 and test methods here
    public static void main(String[] args) {
        Project1 numCollection = new Project1(100);
        numCollection.addRandom(50);

        System.out.println("Size = " + numCollection.size());
        System.out.println("Smallest = " + numCollection.getMinimum());
        System.out.println("Largest = " + numCollection.getMaximum());
        System.out.println("Range = " + numCollection.getRange());
        System.out.println("Average = " + numCollection.getAverage());
        System.out.println("Has duplicates = " + numCollection.hasDuplicates());

        int lastIndex = numCollection.getCapacity();
        try {
            numCollection.setValue(lastIndex + 1, 25);
        } catch (IndexOutOfBoundsException x) {
            System.out.println("Should throw Index out of bounds");
        }
    }
}
