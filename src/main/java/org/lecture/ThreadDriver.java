package org.lecture;

/**
 * The ThreadDriver class contains the main method to run the ThreadService for managing warehouse threads.
 *It creates an instance of the ThreadService class and invokes the run method to start the thread simulation.
 *
 * @author Unger Daniel, Leicht Andreas, Alnahhas Khaled
 * @version 1.0
 */
public class ThreadDriver {
    /**
     * The main method to run the warehouse thread simulation.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        ThreadService driver = new ThreadService();
        driver.run();
    }
}
