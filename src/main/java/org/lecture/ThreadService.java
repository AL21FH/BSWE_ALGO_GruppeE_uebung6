package org.lecture;

import org.lecture.helpers.ConsoleColor;
import org.lecture.menu.Menu;
import org.lecture.storage.StorageHistory;
import org.lecture.storage.WarehouseManagement;
import org.lecture.threads.DeliveryThread;
import org.lecture.threads.SalesThread;

/**
 * The ThreadService class is responsible for managing and coordinating threads in the warehouse simulation.
 * It initializes the necessary components, such as the warehouse management system, menu, and threads for
 * product delivery and sales. It provides a user interface to interact with the simulation.
 *
 * @author Unger Daniel, Leicht Andreas, Alnahhas Khaled
 * @version 1.0
 */
public class ThreadService {

    private final WarehouseManagement warehouseManagement = new WarehouseManagement();
    private final Menu menu = new Menu();
    private final StorageHistory history = new StorageHistory();
    private final Thread deliveryThread = new DeliveryThread(warehouseManagement);
    private final Thread salesThread = new SalesThread(warehouseManagement);

    /**
     * The main method to run the warehouse thread simulation.
     * <p>
     * It continuously displays a menu to the user, allowing them to start the simulation, view storage history,
     * or exit the program. The user's choice triggers different actions, such as initializing products, starting
     * threads, and displaying history.
     */
    public void run() {
        while (true) {
            int choice = menu.printMenu();
            switch (choice) {
                case 1 -> {
                    warehouseManagement.initializeDefaultProducts();
                    deliveryThread.start();
                    salesThread.start();
                    try {
                        deliveryThread.join();
                        salesThread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 2 -> System.out.println(history.getHistory());
                case 9 -> {
                    System.out.println(ConsoleColor.ANSI_YELLOW + "Now leaving..." + ConsoleColor.ANSI_RESET);
                    System.out.println(ConsoleColor.ANSI_YELLOW + "Program finished!" + ConsoleColor.ANSI_RESET);
                    return;
                }
                default -> {
                    System.err.println("Invalid menu choice! Please enter a valid option!");
                }
            }

        }



    }
}
