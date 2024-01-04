package org.lecture;

import org.lecture.storage.WarehouseManagement;
import org.lecture.threads.DeliveryThread;
import org.lecture.threads.SalesThread;

public class ThreadServiceClass {
    public static void main(String[] args) {
        WarehouseManagement warehouseManagement = new WarehouseManagement();
        warehouseManagement.initializeDefaultProducts(); // Initialisiere Produkte
        //warehouseManagement.printInventory();
        System.out.println("Start");

        Thread deliveryThread = new DeliveryThread(warehouseManagement);
       Thread salesThread = new SalesThread(warehouseManagement);

        deliveryThread.start();
        salesThread.start();

    }
}
