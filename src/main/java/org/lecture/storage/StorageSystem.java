package org.lecture.storage;

import org.lecture.product.Elektronik;
import org.lecture.product.Kleidung;
import org.lecture.product.Lebensmittel;
import org.lecture.product.Produkt;

public class StorageSystem {

    private final WarehouseManagement warehouseManagement;
    private final StorageHistory storageHistory;

    public StorageSystem() {
        storageHistory = new StorageHistory();
        warehouseManagement = new WarehouseManagement(storageHistory);
        initializeProducts();
    }

    private void initializeProducts() {

        Produkt fernseher = new Elektronik("Fernseher", 40);
        Produkt kamera = new Elektronik("Kamera", 25);
        Produkt smartwatch = new Elektronik("Smartwatch", 60);
        Produkt kopfhoerer = new Elektronik("Kopfhörer", 75);
        Produkt spielekonsole = new Elektronik("Spielekonsole", 30);


        Produkt tShirt = new Kleidung("T-Shirt", 100);
        Produkt jacke = new Kleidung("Jacke", 50);
        Produkt schuhe = new Kleidung("Schuhe", 70);
        Produkt hose = new Kleidung("Hose", 80);
        Produkt pullover = new Kleidung("Pullover", 60);


        Produkt bananen = new Lebensmittel("Bananen", 150);
        Produkt milch = new Lebensmittel("Milch", 200);
        Produkt brot = new Lebensmittel("Brot", 100);
        Produkt tomaten = new Lebensmittel("Tomaten", 120);
        Produkt käse = new Lebensmittel("Käse", 80);
        Produkt äpfel = new Lebensmittel("Äpfel", 130);
        Produkt kartoffeln = new Lebensmittel("Kartoffeln", 90);
        Produkt eier = new Lebensmittel("Eier", 200);
        Produkt reis = new Lebensmittel("Reis", 110);
        Produkt nudeln = new Lebensmittel("Nudeln", 150);


    }
}