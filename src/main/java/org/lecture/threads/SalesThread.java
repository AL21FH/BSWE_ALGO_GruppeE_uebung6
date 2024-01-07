package org.lecture.threads;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.lecture.helpers.ConsoleColor;
import org.lecture.interfaces.LagerOperation;
import org.lecture.storage.WarehouseManagement;
import org.lecture.product.Produkt;
import java.util.Map;
import java.util.Random;

/**
 * The SalesThread class represents a thread responsible for simulating product sales.
 * It continuously selects random products and attempts to perform sales transactions,
 * updating the inventory through the specified LagerOperation.
 *
 * @author Unger Daniel, Leicht Andreas, Alnahhas Khaled
 * @version 1.0
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Map.Entry<String, Produkt> productEntry = ((WarehouseManagement) lagerOperation).getRandomProductEntry();
                if (productEntry != null) {
                    Produkt produkt = productEntry.getValue();
                    int menge = -1 * random.nextInt(20) + 1;

                    String currentTime = LocalDateTime.now().format(formatter);
                    String message = currentTime + " ▪ Verkauf: " + Math.abs(menge) + " Einheiten von Produkt " + produkt.getProduktKlasse() + "-" + produkt.getName() + " abgezogen";

                    if (((WarehouseManagement) lagerOperation).validateSale(produkt, menge)) {
                        lagerOperation.aktualisiereBestand(produkt, menge);
                        ((WarehouseManagement) lagerOperation).getHistory().addEntry(message);
                        System.out.println(message);
                    } else {
                        System.out.println(
                                ConsoleColor.ANSI_YELLOW +
                                        "Es wurde versucht, " + Math.abs(menge) + " Einheiten von Produkt " + produkt.getProduktKlasse() + "-" + produkt.getName() + " mit Lagerstand " + produkt.getBestand() + " zu verkaufen. " +
                                        ConsoleColor.ANSI_RED +
                                        "Verkauf von " + Math.abs(menge) + " Einheiten von Produkt " + produkt.getName() + " nicht möglich, der Lagerstand ist zu gering!" +
                                        ConsoleColor.ANSI_RESET
                        );
                    }
                }
                Thread.sleep(3000);  // Pause between sales attempts
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
