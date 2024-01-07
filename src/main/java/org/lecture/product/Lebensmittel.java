package org.lecture.product;

import org.lecture.enums.ProduktKlasse;

/**
 * The Lebensmittel class represents food products.
 * It extends the base Produkt class and sets the ProduktKlasse (product class) to LEBENSMITTEL.
 *
 * @author Unger Daniel, Leicht Andreas, Alnahhas Khaled
 * @version 1.0
 */
public class Lebensmittel extends Produkt {
    public Lebensmittel(String name, int bestand) {
        super(name, ProduktKlasse.LEBENSMITTEL, bestand);
    }
}
