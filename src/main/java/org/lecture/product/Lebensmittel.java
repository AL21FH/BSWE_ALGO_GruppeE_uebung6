package org.lecture.product;

import org.lecture.enums.ProduktKlasse;

public class Lebensmittel extends Produkt {
    public Lebensmittel(String name, int bestand) {
        super(name, ProduktKlasse.LEBENSMITTEL, bestand);
    }
}
