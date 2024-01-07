package org.lecture.threads;


import org.lecture.interfaces.LagerOperation;
import org.lecture.product.Produkt;
import org.lecture.storage.WarehouseManagement;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;

/**
 * The DeliveryThread class represents a thread responsible for simulating product deliveries to the warehouse.
 * The thread continuously selects a random product from the inventory, generates a random quantity,
 * and updates the stock accordingly. The information about the delivery is logged to the storage history.
 *
 * @author Unger Daniel, Leicht Andreas, Alnahhas Khaled
 * @version 1.0
 */
public class DeliveryThread extends Thread {
    private final LagerOperation lagerOperation;
    private final Random random = new Random();

    /**
     * Constructs a new DeliveryThread with the given LagerOperation instance.
     *
     * @param lagerOperation The LagerOperation instance for updating the warehouse stock.
     */
    public DeliveryThread(LagerOperation lagerOperation) {
        this.lagerOperation = lagerOperation;
    }

    /**
     * Runs the delivery simulation thread.
     * Continuously selects a random product, generates a random quantity, and updates the stock.
     * Logs information about the delivery to the storage history.
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Map.Entry<String, Produkt> productEntry = ((WarehouseManagement) lagerOperation).getRandomProductEntry();
                if (productEntry != null) {
                    Produkt produkt = productEntry.getValue();
                    int menge = random.nextInt(50) + 1;
                    lagerOperation.aktualisiereBestand(produkt, menge);
                    String message = LocalDateTime.now() + " Produkt " + produkt.getProduktKlasse() + " "
                            + produkt.getName() + " hat einen Bestand von " + produkt.getBestand();
                    ((WarehouseManagement) lagerOperation).getHistory().addEntry(message);
                    System.out.println(message);
                    System.out.println("Lieferung: " + menge +
                            " Einheiten von Produkt " + produkt.getName() + " hinzugefügt");
                }
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // Restore interrupted status
                Thread.currentThread().interrupt();
            }
        }
    }
}

