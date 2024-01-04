package org.lecture.product;

import org.lecture.enums.ProduktKlasse;

public class Kleidung extends Produkt {
    public Kleidung(String name, int bestand) {
        super(name, ProduktKlasse.KLEIDUNG, bestand);
    }

}
