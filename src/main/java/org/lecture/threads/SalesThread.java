package org.lecture.threads;

import org.lecture.interfaces.LagerOpration;
import org.lecture.product.Produkt;

public class SalesThread extends Thread {
    private final LagerOpration lagerOpration;

    public SalesThread(LagerOpration lagerOpration) {
        this.lagerOpration = lagerOpration;
    }

    @Override
    public void run() {

    }
}
