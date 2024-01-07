package org.lecture.storage;

import lombok.Getter;
import lombok.Setter;
import org.lecture.enums.ElektronikProdukt;
import org.lecture.enums.KleidungProdukt;
import org.lecture.enums.LebensmittelProdukt;
import org.lecture.helpers.ConsoleColor;
import org.lecture.interfaces.LagerOperation;
import org.lecture.product.Elektronik;
import org.lecture.product.Kleidung;
import org.lecture.product.Lebensmittel;
import org.lecture.product.Produkt;

import java.util.*;

/**
 * Manages the warehouse inventory and provides operations for updating stock.
 * The WarehouseManagement class includes methods for initializing default products,
 * obtaining random product entries, getting random products, and updating the stock.
 *
 * @author Unger Daniel, Leicht Andreas, Alnahhas Khaled
 * @version 1.0
 */
@Getter
@Setter
public class WarehouseManagement implements LagerOperation {
    private Map<String, Produkt> bestand;
    private StorageHistory history;

    /**
     * Constructs a new WarehouseManagement with an empty inventory and a storage history.
     */
    public WarehouseManagement() {
        this.bestand = new HashMap<>();
        this.history = new StorageHistory();

    }



    /**
     * Initializes the warehouse with default products.
     * For each category (electronic, clothing, and food), one product is added to the inventory.
     * The initial quantity is set to 1 for each product.
     */
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

    /**
     * Retrieves a random product entry from the inventory.
     *
     * @return A random product entry as a Map.Entry (name, product).
     *         Returns null if the inventory is empty.
     */
    public synchronized Map.Entry<String, Produkt> getRandomProductEntry() {
        if (bestand.isEmpty()) {
            //initializeDefaultProducts();
        }

        List<Map.Entry<String, Produkt>> productList = new ArrayList<>(bestand.entrySet());

        if (!productList.isEmpty()) {
            Map.Entry<String, Produkt> randomProductEntry = productList.get(new Random().nextInt(productList.size()));

            return randomProductEntry;
        }

        return null;
    }


    /**
     * Retrieves a random product from the inventory.
     *
     * @return A random product. Throws IllegalStateException if the inventory is empty.
     */
    public Produkt getRandomProduct() {
        if (bestand.isEmpty()) {
            throw new IllegalStateException("Das Lager ist leer.");
        }

        List<String> keys = new ArrayList<>(bestand.keySet());
        String randomKey = keys.get(new Random().nextInt(keys.size()));
        return bestand.get(randomKey);
    }

    /**
     * Updates the stock quantity of a given product.
     * If the new quantity is less than 0, the update is rejected.
     * If the updated quantity is less than 10, an alarm entry is added to the storage history.
     *
     * @param produkt The product to be updated.
     * @param menge   The quantity to update (positive for addition, negative for subtraction).
     */
    @Override
    public synchronized void aktualisiereBestand(Produkt produkt, int menge) {
        int aktuellerBestand = produkt.getBestand();
        if (aktuellerBestand + menge < 0) {
            // Reject update if it would result in negative stock
            return;
        }

        produkt.setBestand(aktuellerBestand + menge);

        // Add a general update message for every stock change
        String updateMessage = ConsoleColor.ANSI_YELLOW + "▪ Produkt " + produkt.getProduktKlasse() + "-" + produkt.getName() + " hat einen Bestand von " + produkt.getBestand() + ConsoleColor.ANSI_RESET;
        history.addEntry(updateMessage);

        // Check for low stock and add an alarm entry if necessary
        if (produkt.getBestand() < 10) {
            String alarmEntry = "▪ Alarm: Bestand für Produkt " + produkt.getProduktKlasse() + "-" + produkt.getName() + " unter Schwellenwert! (Bestand: " + produkt.getBestand() + ")";
            history.addEntry(alarmEntry);
        }
    }

    public synchronized boolean validateSale(Produkt produkt, int menge) {
        return produkt.getBestand() + menge >= 0;
    }

}
