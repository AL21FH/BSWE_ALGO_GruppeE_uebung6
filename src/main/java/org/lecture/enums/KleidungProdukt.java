package org.lecture.enums;

import java.util.Random;

/**
 * Enumeration representing clothing products.
 * <p>
 * This enumeration defines various clothing products along with methods
 * to retrieve random names from the available options.
 *
 * @author Unger Daniel, Leicht Andreas, Alnahhas Khaled
 * @version 1.0
 */
public enum KleidungProdukt {

    BALENCIAGABAUCHTASCHE("Balenciaga Bauchtasche"), GUCCICAP("Gucci Cap"), NIKETRAININGSANZUG("Nike Trainingsanzug"), ADILETTEN("Adiletten");

    private final String name;

    KleidungProdukt(String name) {
        this.name = name;
    }

    /**
     * Returns a random name from the available clothing products.
     */

    public static String getRandomName() {
        KleidungProdukt[] values = KleidungProdukt.values();
        return values[new Random().nextInt(values.length)].name;
    }

    /**
     * Returns the name of the clothing product.
     */

    public String getName() {
        return name;
    }
}
