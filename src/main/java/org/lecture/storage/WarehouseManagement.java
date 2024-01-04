package org.lecture.storage;

import org.lecture.interfaces.LagerOpration;
import org.lecture.product.Produkt;

import java.util.HashMap;
import java.util.Map;

public class WarehouseManagement implements LagerOpration {
    private Map<String, Produkt> bestand;
    private StorageHistory history;


    public WarehouseManagement(StorageHistory history) {
        this.bestand = new HashMap<>();
        this.history = history;
    }

    @Override
    public synchronized void aktualisiereBestand(Produkt produkt, int menge) {
        int aktuellerBestand = produkt.getBestand();
        produkt.setBestand(aktuellerBestand + menge);

        if (produkt.getBestand() < 0) {
            throw new IllegalArgumentException("Negativer Bestand nicht erlaubt");
        }

        if (produkt.getBestand() < 10) { // Angenommener Schwellenwert
            System.out.println("Alarm: Bestand für Produkt " + produkt.getName() + " unter Schwellenwert! (Bestand: " + produkt.getBestand() + ")");
        }

        bestand.put(produkt.getName(), produkt);
        history.addEntry("Bestandsänderung: Produkt " + produkt.getName() + ", Menge: " + menge);
    }
}
