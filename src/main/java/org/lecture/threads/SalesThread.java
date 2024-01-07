package org.lecture.threads;

import org.lecture.interfaces.LagerOperation;
import org.lecture.product.Produkt;
import org.lecture.storage.WarehouseManagement;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;

/**
 * The SalesThread class represents a thread responsible for simulating product sales.
 * It continuously selects random products and attempts to perform sales transactions,
 * updating the inventory through the specified LagerOperation.
 *
 *@author Unger Daniel, Leicht Andreas, Alnahhas Khaled
 *@version 1.0
 */
public class SalesThread extends Thread {
    private final LagerOperation lagerOperation;
    private final Random random = new Random();

    /**
     * Constructs a new SalesThread with the given LagerOperation instance.
     *
     * @param lagerOperation The LagerOperation instance for updating the warehouse stock.
     */
    public SalesThread(LagerOperation lagerOperation) {
        this.lagerOperation = lagerOperation;
    }

    /**
     * Runs the sales simulation thread.
     * Continuously selects random products, attempts sales transactions, and updates the stock.
     * Logs information about the sales to the storage history.
     */
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        while (!Thread.currentThread().isInterrupted()) {
            try {
                Map.Entry<String, Produkt> productEntry = ((WarehouseManagement) lagerOperation).getRandomProductEntry();
                if (productEntry != null) {
                    Produkt produkt = productEntry.getValue();
                    int menge = -1 * random.nextInt(40) + 1;

                    // Check if the sale is valid
                    if (validateSale(produkt, menge)) {
                        lagerOperation.aktualisiereBestand(produkt, menge);
                        String message = LocalDateTime.now() + " Produkt " + produkt.getProduktKlasse() + " "
                                + produkt.getName() + " hat einen Bestand von " + produkt.getBestand();
                        System.out.println("Verkauf: " + menge + " Einheiten von Produkt " + produkt.getName() + " abgezogen");
                        System.out.println(message);
                        ((WarehouseManagement) lagerOperation).getHistory().addEntry(message);
                    } else {
                        System.err.println("Verkauf von " + menge + " Einheiten von Produkt " + produkt.getName() + " nicht möglich!");
                        System.err.println("Verkauf abgelehnt: Nicht genug Bestand von " + produkt.getName());
                    }
                }
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
        }
    }

    /**
     * Validates whether a sale is possible based on the current stock.
     *
     * @param produkt The product for which the sale is being validated.
     * @param menge   The quantity of the product for the sale.
     * @return True if the sale is valid, false otherwise.
     */
    private boolean validateSale(Produkt produkt, int menge) {
        int aktuellerBestand = produkt.getBestand();
        return aktuellerBestand + menge >= 0;
    }
}
