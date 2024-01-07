package org.lecture.enums;

import java.util.Random;

/**
 * Enumeration representing food products.
 * This enumeration defines various food products along with methods
 * to retrieve random names from the available options.
 *
 * @author Unger Daniel, Leicht Andreas, Alnahhas Khaled
 * @version 1.0
 */
public enum LebensmittelProdukt {

    GRANATAPFEL("Granatapfel"), AUBERGINENWALNUSSBROT("Auberginenwalnussbrot"), BARISTAMANDELMILCH("Baristamandelmilch"), NICARAGUAKAFFEE("Nicaraguakaffee");

    private final String name;

    LebensmittelProdukt(String name) {
        this.name = name;
    }

    /**
     * Returns a random name from the available food products.
     */
    public static String getRandomName() {
        LebensmittelProdukt[] values = LebensmittelProdukt.values();
        return values[new Random().nextInt(values.length)].name;
    }

    /**
     * Returns the name of the food product.
     */
    public String getName() {
        return name;
    }
}
