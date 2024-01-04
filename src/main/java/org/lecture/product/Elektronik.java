package org.lecture.product;

import org.lecture.enums.ProduktKlasse;

public class Elektronik extends Produkt {
    public Elektronik(String name, int bestand) {
        super(name, ProduktKlasse.ELEKTRONIK, bestand);
    }
}