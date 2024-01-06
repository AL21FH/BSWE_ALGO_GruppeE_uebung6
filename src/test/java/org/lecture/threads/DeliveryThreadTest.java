package org.lecture.threads;

import org.junit.Test;
import org.lecture.interfaces.LagerOperation;
import org.lecture.storage.WarehouseManagement;

import static org.junit.Assert.*;

/**
 * Unit test for the DeliveryThread class.
 */
public class DeliveryThreadTest {

    @Test
    public void testDeliveryThread() {
        LagerOperation lagerOperation = new WarehouseManagement();
        DeliveryThread deliveryThread = new DeliveryThread(lagerOperation);

        deliveryThread.start();

        try {
            Thread.sleep(10000); // Sleep for 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        deliveryThread.interrupt();
        try {
            deliveryThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Assert
        // Check if the thread was interrupted
        assertTrue(deliveryThread.isInterrupted());

    }
}
