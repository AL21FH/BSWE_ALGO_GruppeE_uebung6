package org.lecture.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produkt {
    private String name;
    private ProduktKlasse produktKlasse;
    private int bestand;

    // Konstruktor, Getter und Setter
}

