/**
 * The LagerOperation interface defines the contract for operations related to stock management.
 * Implementing classes should provide functionality to update the stock of products based on quantity changes.
 *
 * @author Unger Daniel, Leicht Andreas, Alnahhas Khaled
 * @version 1.0
 */
package org.lecture.interfaces;

import org.lecture.product.Produkt;

public interface LagerOperation {
    /**
     * Updates the stock of a given product by the specified quantity.
     *
     * @param produkt The product to update.
     * @param menge   The quantity by which to update the stock (positive for addition, negative for subtraction).
     */
    void aktualisiereBestand(Produkt produkt, int menge);
}
