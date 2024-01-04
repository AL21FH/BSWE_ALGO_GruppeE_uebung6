package org.lecture.interfaces;

import org.lecture.product.Produkt;

public interface Lager {
    void aktualisiereBestand(Produkt produkt, int menge);
}
