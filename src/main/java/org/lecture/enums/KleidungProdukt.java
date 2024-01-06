package org.lecture.enums;

import java.util.Random;

/**
 * Enumeration representing clothing products.
 */
public enum KleidungProdukt {

    BALENCIAGABAUCHTASCHE ("Balenciaga Bauchtasche"),
    GUCCICAP ("Gucci Cap"),
    NIKETRAININGSANZUG ("Nike Trainingsanzug"),
    ADILETTEN ("Adiletten");

    private String name;

    KleidungProdukt(String name) {
        this.name = name;
    }

    public static String getRandomName() {
        KleidungProdukt[] values = KleidungProdukt.values();
        return values[new Random().nextInt(values.length)].name;
    }

    public String getName() {
        return name;
    }
}
