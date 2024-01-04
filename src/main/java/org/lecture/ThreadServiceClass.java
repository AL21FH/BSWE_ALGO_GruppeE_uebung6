package org.lecture;

import org.lecture.storage.StorageHistory;
import org.lecture.storage.WarehouseManagement;
import org.lecture.threads.DeliveryThread;
import org.lecture.threads.SalesThread;

public class ThreadServiceClass {
    public static void main(String[] args) {
        StorageHistory history = new StorageHistory();
        WarehouseManagement warehouseManagement = new WarehouseManagement(history);

        Thread deliveryThread = new DeliveryThread(warehouseManagement);
        Thread salesThread = new SalesThread(warehouseManagement);

        deliveryThread.start();
        salesThread.start();
    }
}
