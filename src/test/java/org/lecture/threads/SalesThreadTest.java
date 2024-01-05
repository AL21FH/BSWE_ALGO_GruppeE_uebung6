package org.lecture.threads;

import org.lecture.interfaces.LagerOperation;
import org.lecture.storage.WarehouseManagement;


public class SalesThreadTest {

    public static void main(String[] args) {
        LagerOperation lagerOperation = new WarehouseManagement();
        SalesThread salesThread = new SalesThread(lagerOperation);
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
