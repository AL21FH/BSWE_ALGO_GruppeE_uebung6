package org.lecture.enums;

import lombok.Getter;

import java.util.Random;

/**
 * Enumeration representing electronic products.
 * This enumeration defines various electronic products along with methods
 * to retrieve random names from the available options.
 *
 * @author Unger Daniel, Leicht Andreas, Alnahhas Khaled
 * @version 1.0
 */
@Getter
public enum ElektronikProdukt {
    KOPFHOERER("Kopfhörer"), USBMAUS("USB-Maus"), LAPTOP("Laptop");

    private final String name;

    ElektronikProdukt(String name) {
        this.name = name;
    }

    /**
     * Returns a random name from the available electronic products.
     */
    public static String getRandomName() {
        ElektronikProdukt[] values = ElektronikProdukt.values();
        return values[new Random().nextInt(values.length)].name;
    }

    /**
     * Returns the name of the electronic product.
     */
    public String getName() {
        return name;
    }
}

