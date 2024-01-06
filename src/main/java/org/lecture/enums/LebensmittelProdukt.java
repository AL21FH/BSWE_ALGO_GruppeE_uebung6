package org.lecture.enums;

import java.util.Random;

/**
 * Enumeration representing food products.
 */
public enum LebensmittelProdukt {

    GRANATAPFEL ("Granatapfel"),
    AUBERGINENWALNUSSBROT ("Auberginenwalnussbrot"),
    BARISTAMANDELMILCH ("Baristamandelmilch"),
    NICARAGUAKAFFEE ("Nicaraguakaffee");

    private String name;

    LebensmittelProdukt(String name) {
        this.name = name;
    }

    public static String getRandomName() {
        LebensmittelProdukt[] values = LebensmittelProdukt.values();
        return values[new Random().nextInt(values.length)].name;
    }

    public String getName() {
        return name;
    }
}
