package org.lecture.interfaces;

import org.lecture.product.Produkt;

public interface LagerOperation {
    void aktualisiereBestand(Produkt produkt, int menge);
}
