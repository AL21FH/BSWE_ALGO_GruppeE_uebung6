package org.lecture.product;

public class Lebensmittel extends Produkt {
    public Lebensmittel(String name, int bestand) {
        super(name, ProduktKlasse.LEBENSMITTEL, bestand);
    }
}
