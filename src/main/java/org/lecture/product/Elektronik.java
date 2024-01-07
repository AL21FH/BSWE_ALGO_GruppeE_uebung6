package org.lecture.product;

import org.lecture.enums.ProduktKlasse;

/**
 * The Elektronik class represents electronic products.
 * It extends the base Produkt class and sets the ProduktKlasse (product class) to ELEKTRONIK.
 *
 * @author Unger Daniel, Leicht Andreas, Alnahhas Khaled
 * @version 1.0
 */
public class Elektronik extends Produkt {
    public Elektronik(String name, int bestand) {
        super(name, ProduktKlasse.ELEKTRONIK, bestand);
    }
}