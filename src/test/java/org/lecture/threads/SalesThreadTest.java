package org.lecture.threads;

import org.junit.Test;
import org.lecture.interfaces.LagerOperation;
import org.lecture.storage.WarehouseManagement;

/**
 * Unit tests for the SalesThread class.
 */
public class SalesThreadTest {

    /**
     * Tests the behavior of the SalesThread class by starting the thread,
     * letting it run for a specified duration, then interrupting and waiting for it to finish.
     *
     * <p>
     * This test checks the interruption mechanism and ensures the thread behaves as expected.
     * </p>
     */
    @Test
    public void testSalesThread() {
        // Arrange
        LagerOperation lagerOperation = new WarehouseManagement();
        SalesThread salesThread = new SalesThread(lagerOperation);

        // Act
        salesThread.start();

        try {
            Thread.sleep(10000); // Sleep for 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        salesThread.interrupt(); // Interrupt the thread
        try {
            salesThread.join(); // Wait for the thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
