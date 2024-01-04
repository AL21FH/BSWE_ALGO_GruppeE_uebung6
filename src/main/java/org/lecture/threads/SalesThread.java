package org.lecture.threads;

import org.lecture.interfaces.LagerOperation;
import org.lecture.product.Produkt;
import org.lecture.storage.WarehouseManagement;

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
        while (true) {
            try {
                Map.Entry<String, Produkt> productEntry = ((WarehouseManagement) lagerOperation).getRandomProductEntry();
                if (productEntry != null) {
                    Produkt produkt = productEntry.getValue();
                    int menge = -1 * random.nextInt(40) + 1;
                    lagerOperation.aktualisiereBestand(produkt, menge);
                    ((WarehouseManagement) lagerOperation).printInventory();
                }
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
