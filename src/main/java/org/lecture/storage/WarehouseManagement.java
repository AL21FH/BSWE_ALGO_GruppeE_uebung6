package org.lecture.storage;

import lombok.Getter;
import lombok.Setter;
import org.lecture.enums.ElektronikProdukt;
import org.lecture.enums.KleidungProdukt;
import org.lecture.enums.LebensmittelProdukt;
import org.lecture.interfaces.LagerOperation;
import org.lecture.product.Elektronik;
import org.lecture.product.Kleidung;
import org.lecture.product.Lebensmittel;
import org.lecture.product.Produkt;

import java.util.*;

@Getter
@Setter
public class WarehouseManagement implements LagerOperation {
    private Map<String, Produkt> bestand;
    private StorageHistory history;

    public WarehouseManagement() {
        this.bestand = new HashMap<>();
        this.history = new StorageHistory();

    }

    public synchronized void printInventory() {
        System.out.println("Current Inventory State:");
        for (Map.Entry<String, Produkt> entry : bestand.entrySet()) {
            Produkt produkt = entry.getValue();
            System.out.println("Produkt "+ produkt.getProduktKlasse() + " " + produkt.getName() + " hat einen Bestand von " + produkt.getBestand());
        }
    }
    public void initializeDefaultProducts() {
        for (ElektronikProdukt eProdukt : ElektronikProdukt.values()) {
            Elektronik elektronik = new Elektronik(eProdukt.getName(), 1);
            bestand.put(elektronik.getName(), elektronik);
        }

        for (KleidungProdukt kProdukt : KleidungProdukt.values()) {
            Kleidung kleidung = new Kleidung(kProdukt.getName(), 1); // Assuming quantity 5 for example
            bestand.put(kleidung.getName(), kleidung);
        }

        for (LebensmittelProdukt lProdukt : LebensmittelProdukt.values()) {
            Lebensmittel lebensmittel = new Lebensmittel(lProdukt.getName(), 1); // Assuming quantity 30 for example
            bestand.put(lebensmittel.getName(), lebensmittel);
        }
    }

    public Map.Entry<String, Produkt> getRandomProductEntry() {
        if (bestand.isEmpty()) {
            //initializeDefaultProducts();
        }

        List<Map.Entry<String, Produkt>> productList = new ArrayList<>(bestand.entrySet());

        if (!productList.isEmpty()) {
            Map.Entry<String, Produkt> randomProductEntry = productList.get(new Random().nextInt(productList.size()));

            // Hier haben Sie jetzt das Entry-Objekt, das den Produktname und das Produktobjekt enthält
            return randomProductEntry;
        }

        // Handle the case when the map is empty
        return null;
    }


    public Produkt getRandomProduct() {
        if (bestand.isEmpty()) {
            throw new IllegalStateException("Das Lager ist leer.");
        }

        List<String> keys = new ArrayList<>(bestand.keySet());
        String randomKey = keys.get(new Random().nextInt(keys.size()));
        return bestand.get(randomKey);
    }


    @Override
    public synchronized void aktualisiereBestand(Produkt produkt, int menge) {
        int aktuellerBestand = produkt.getBestand();

        if (aktuellerBestand + menge < 0) {
            System.out.println("Verkauf abgelehnt: Nicht genug Bestand von " + produkt.getName());
            return; // Verhindert, dass der Bestand negativ wird
        }

        produkt.setBestand(aktuellerBestand + menge);

        if (produkt.getBestand() < 10) {
            String alarmEntry = "Alarm: Bestand für Produkt " + produkt.getName() + " unter Schwellenwert! (Bestand: " + produkt.getBestand() + ")";
            System.out.println(alarmEntry);
            history.addEntry(alarmEntry);
        }

        String stockChangeEntry = "Bestandsänderung: Produkt " + produkt.getName() + ", Menge: " + menge;
        System.out.println(stockChangeEntry);
        bestand.put(produkt.getName(), produkt);
        history.addEntry(stockChangeEntry);
    }



}
