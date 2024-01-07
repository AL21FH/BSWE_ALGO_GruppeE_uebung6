package org.lecture.product;

import org.lecture.enums.ProduktKlasse;

/**
 * The Kleidung class represents clothing products.
 * It extends the base Produkt class and sets the ProduktKlasse (product class) to KLEIDUNG.
 *
 * @author Unger Daniel, Leicht Andreas, Alnahhas Khaled
 * @version 1.0
 */
public class Kleidung extends Produkt {
    public Kleidung(String name, int bestand) {
        super(name, ProduktKlasse.KLEIDUNG, bestand);
    }

}
