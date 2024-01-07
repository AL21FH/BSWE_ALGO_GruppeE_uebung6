package org.lecture.product;

import lombok.Getter;
import lombok.Setter;
import org.lecture.enums.ProduktKlasse;

/**
 * The Produkt class represents a generic product.
 * It contains information about the product, such as its name, product class, and stock quantity.
 *
 * @author Unger Daniel, Leicht Andreas, Alnahhas Khaled
 * @version 1.0
 */
@Getter
@Setter
public class Produkt {
    private String name;
    private ProduktKlasse produktKlasse;
    private int bestand;

    /**
     * Constructs a new Produkt with the specified name, product class, and initial stock quantity.
     *
     * @param name          The name of the product.
     * @param produktKlasse The product class of the product.
     * @param bestand       The initial stock quantity of the product.
     */

    public Produkt(String name, ProduktKlasse produktKlasse, int bestand) {
        this.name = name;
        this.produktKlasse = produktKlasse;
        this.bestand = bestand;
    }

}

