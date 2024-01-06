package org.lecture.storage;

import org.junit.jupiter.api.Test;
import org.lecture.enums.ElektronikProdukt;
import org.lecture.enums.LebensmittelProdukt;
import org.lecture.product.Elektronik;
import org.lecture.product.Lebensmittel;
import org.lecture.product.Produkt;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The WarehouseManagementTest class contains JUnit tests for the WarehouseManagement class.
 * It ensures that the functionality of the WarehouseManagement class, such as obtaining
 * random product entries, getting random products, and updating the stock, works as expected.
 */


class WarehouseManagementTest {

    @Test
    void getRandomProductEntry() {
        WarehouseManagement warehouse = new WarehouseManagement();
        warehouse.initializeDefaultProducts();

        Map.Entry<String, Produkt> randomProductEntry = warehouse.getRandomProductEntry();

        assertNotNull(randomProductEntry);
        assertNotNull(randomProductEntry.getKey());
        assertNotNull(randomProductEntry.getValue());
    }

    @Test
    void getRandomProduct() {
        WarehouseManagement warehouse = new WarehouseManagement();
        warehouse.initializeDefaultProducts();

        Produkt randomProduct = warehouse.getRandomProduct();

        assertNotNull(randomProduct);
        assertNotNull(randomProduct.getName());
    }

    @Test
    void aktualisiereBestand_ValidUpdate() {
        WarehouseManagement warehouse = new WarehouseManagement();
        Elektronik elektronik = new Elektronik(ElektronikProdukt.LAPTOP.getName(), 5);
        warehouse.getBestand().put(elektronik.getName(), elektronik);

        warehouse.aktualisiereBestand(elektronik, 3);

        assertEquals(8, elektronik.getBestand());
    }

    @Test
    void aktualisiereBestand_InvalidUpdate() {
        WarehouseManagement warehouse = new WarehouseManagement();
        Lebensmittel lebensmittel = new Lebensmittel(LebensmittelProdukt.BARISTAMANDELMILCH.getName(), 10);
        warehouse.getBestand().put(lebensmittel.getName(), lebensmittel);

        warehouse.aktualisiereBestand(lebensmittel, -15);

        assertEquals(10, lebensmittel.getBestand());
    }
}
