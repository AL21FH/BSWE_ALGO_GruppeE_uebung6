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
        Produkt laptop = new Elektronik("Laptop", 50);
        Produkt jeans = new Kleidung("Jeans", 30);
        Produkt apfel = new Lebensmittel("Apfel", 30);

    }
}