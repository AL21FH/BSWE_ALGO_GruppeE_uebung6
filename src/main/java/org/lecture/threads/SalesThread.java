package org.lecture.threads;

import org.lecture.interfaces.LagerOperation;
import org.lecture.product.Produkt;
import org.lecture.storage.WarehouseManagement;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;

public class SalesThread extends Thread {
    private final LagerOperation lagerOperation;
    private final Random random = new Random();

    public SalesThread(LagerOperation lagerOperation) {
        this.lagerOperation = lagerOperation;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (true) {
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
                e.printStackTrace();
            }
        }
    }

    private boolean validateSale(Produkt produkt, int menge) {
        int aktuellerBestand = produkt.getBestand();
        return aktuellerBestand + menge >= 0;
    }
}
