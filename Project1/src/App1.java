import org.junit.Ignore;

/**
 * Entry point for running Project1.
 * 
 * @author Branson Flynn
 * @version Jan 23, 2025
 */
@Ignore
public class App1 {
    public static void main(String[] args) {
        Project1 numCollection = new Project1(100);
        numCollection.addRandom(50);

        // System.out.println(numCollection.arrToString(true)); // temp

        System.out.println("Size        = " + numCollection.size());
        System.out.println("Minimum     = " + numCollection.getMinimum());
        System.out.println("Maximum     = " + numCollection.getMaximum());
        System.out.println("Range       = " + numCollection.getRange());
        System.out.println("Average     = " + numCollection.getAverage());
        System.out.println("Median      = " + numCollection.getMedian());
        System.out.println("Duplicates  = " + numCollection.hasDuplicates());

        int lastIndex = numCollection.getCapacity();
        try {
            numCollection.setValue(lastIndex + 1, 25);
        } catch (IndexOutOfBoundsException x) {
            System.out.println("\nShould throw Index out of bounds.\n");
        }
    }
}
