package org.lecture.threads;

import org.lecture.interfaces.LagerOperation;
import org.lecture.product.Produkt;
import org.lecture.storage.WarehouseManagement;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;

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
