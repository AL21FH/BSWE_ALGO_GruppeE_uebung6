package org.lecture.enums;

import lombok.Getter;

import java.util.Random;

public enum ElektronikProdukt {
    KOPFHOERER("Kopfhörer"),
    USBMAUS("USB-Maus"),
    LAPTOP("Laptop");


    private String name;

    ElektronikProdukt(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String getRandomName() {
        ElektronikProdukt[] values = ElektronikProdukt.values();
        return values[new Random().nextInt(values.length)].name;
    }
}

