package org.lecture.threads;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.lecture.interfaces.LagerOperation;
import org.lecture.storage.WarehouseManagement;
import org.lecture.product.Produkt;
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Map.Entry<String, Produkt> productEntry = ((WarehouseManagement) lagerOperation).getRandomProductEntry();
                if (productEntry != null) {
                    Produkt produkt = productEntry.getValue();
                    int menge = random.nextInt(20) +1;

                    String currentTime = LocalDateTime.now().format(formatter);
                    String message = currentTime + " ▪ Lieferung: " + menge + " Einheiten von Produkt " + produkt.getProduktKlasse() + "-" + produkt.getName() + " hinzugefügt";

                    lagerOperation.aktualisiereBestand(produkt, menge);
                    ((WarehouseManagement) lagerOperation).getHistory().addEntry(message);
                    System.out.println(message);
                }
                Thread.sleep(3000);  // Pause between deliveries
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
