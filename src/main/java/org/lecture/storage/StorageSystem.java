package org.lecture.storage;

public class StorageSystem {

    private WarehouseManagement warehouseManagement;
    private StorageHistory storageHistory;

    public StorageSystem() {
        storageHistory = new StorageHistory();
        warehouseManagement = new WarehouseManagement(storageHistory);

    }

    public void startSystem() {

    }

}
