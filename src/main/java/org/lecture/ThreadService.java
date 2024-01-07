package org.lecture;

import org.lecture.menu.Menu;
import org.lecture.storage.WarehouseManagement;
import org.lecture.threads.DeliveryThread;
import org.lecture.threads.SalesThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * This class is responsible for managing the overall operation of the warehouse simulation.
 * It controls the execution of the delivery and sales threads and handles user interaction through a menu system.
 *
 * @author Unger Daniel, Leicht Andreas, Alnahhas Khaled
 * @version 1.0
 */
public class ThreadService {

    private final WarehouseManagement warehouseManagement;
    private final Menu menu;
    private final Thread deliveryThread;
    private final Thread salesThread;

    /**
     * Constructs a ThreadService instance.
     * Initializes the warehouse management system, the menu, and the delivery and sales threads.
     */
    public ThreadService() {
        warehouseManagement = new WarehouseManagement();
        menu = new Menu();
        deliveryThread = new DeliveryThread(warehouseManagement);
        salesThread = new SalesThread(warehouseManagement);
    }

    /**
     * Runs the main loop of the warehouse simulation.
     * Provides a menu to the user for starting the simulation, viewing storage history, or exiting the program.
     */
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
     * Starts the warehouse simulation by initializing default products and starting delivery and sales threads.
     * It schedules these threads to stop after a certain duration.
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
}
