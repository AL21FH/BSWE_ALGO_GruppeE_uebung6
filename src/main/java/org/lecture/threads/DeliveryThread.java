package org.lecture.threads;


import org.lecture.interfaces.LagerOperation;
import org.lecture.product.Produkt;
import org.lecture.storage.WarehouseManagement;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;

public class DeliveryThread extends Thread {
    private final LagerOperation lagerOperation;
    private final Random random = new Random();

    public DeliveryThread(LagerOperation lagerOperation) {
        this.lagerOperation = lagerOperation;
    }

    @Override
    public void run() {
        while (true) {
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
                e.printStackTrace();
            }
        }
    }
}

