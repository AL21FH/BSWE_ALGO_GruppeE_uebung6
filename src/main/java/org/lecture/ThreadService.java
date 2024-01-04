package org.lecture;

import org.lecture.helpers.ConsoleColor;
import org.lecture.menu.Menu;
import org.lecture.storage.StorageHistory;
import org.lecture.storage.WarehouseManagement;
import org.lecture.threads.DeliveryThread;
import org.lecture.threads.SalesThread;

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
