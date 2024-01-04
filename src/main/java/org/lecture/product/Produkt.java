package org.lecture.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produkt {
    private String name;
    private ProduktKlasse produktKlasse;
    private int bestand;

    public Produkt(String name, ProduktKlasse produktKlasse, int bestand) {
        this.name = name;
        this.produktKlasse = produktKlasse;
        this.bestand = bestand;
    }

}

