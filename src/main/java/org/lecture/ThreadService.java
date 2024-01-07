package org.lecture;

import org.lecture.menu.Menu;
import org.lecture.storage.StorageHistory;
import org.lecture.storage.WarehouseManagement;
import org.lecture.threads.DeliveryThread;
import org.lecture.threads.SalesThread;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadService {

    private final WarehouseManagement warehouseManagement = new WarehouseManagement();
    private final Menu menu = new Menu();
    private final StorageHistory history = new StorageHistory();
    private final Thread deliveryThread = new DeliveryThread(warehouseManagement);
    private final Thread salesThread = new SalesThread(warehouseManagement);

    public void run() {
        while (true) {
            int choice = menu.printMenu();
            switch (choice) {
                case 1 -> startSimulation();
                case 2 -> warehouseManagement.getHistory().printFormattedHistory();
                case 9 -> {
                    System.out.println("Now leaving...");
                    System.out.println("Program finished!");
                    return;
                }
                default -> System.err.println("Invalid menu choice! Please enter a valid option!");
            }
        }
    }

    /**
     * Starts the warehouse simulation.
     */
    private void startSimulation() {
        warehouseManagement.initializeDefaultProducts();
        deliveryThread.start();
        salesThread.start();

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(() -> {
            deliveryThread.interrupt();
            salesThread.interrupt();
        }, 60, TimeUnit.SECONDS);

        try {
            deliveryThread.join();
            salesThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }

    /**
     * Prints the storage history in a formatted manner.
     */

}
