package org.lecture.threads;

import org.lecture.interfaces.LagerOpration;
import org.lecture.product.Produkt;

public class DeliveryThread extends Thread {
    private final LagerOpration lagerOpration;

    public DeliveryThread(LagerOpration lagerOpration) {
        this.lagerOpration = lagerOpration;
    }

    @Override
    public void run() {

    }
}
