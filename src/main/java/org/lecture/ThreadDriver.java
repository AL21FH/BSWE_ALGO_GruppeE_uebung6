package org.lecture;

import org.lecture.storage.WarehouseManagement;
import org.lecture.threads.DeliveryThread;
import org.lecture.threads.SalesThread;

public class ThreadServiceClass {
    public static void main(String[] args) {
        ThreadService driver = new ThreadService();
        driver.run();
    }
}
