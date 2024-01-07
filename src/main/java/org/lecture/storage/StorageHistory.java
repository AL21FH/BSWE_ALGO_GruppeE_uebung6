package org.lecture.storage;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code StorageHistory} class represents the history of storage operations.
 * It maintains a list of entries to track the historical changes in the storage.
 */
@Getter
@Setter
public class StorageHistory {

    /**
     * The list to store historical entries.
     */
    private List<String> history = new ArrayList<>();


    /**
     * Adds a new entry to the storage history.
     */
    public void addEntry(String entry) {
        history.add(entry);
    }

    /**
     * Prints the storage history in a formatted manner.
     * This method formats each entry in the storage history for better readability.
     * If an entry contains a specific pattern (" hat einen aktuellen Bestand von "),
     * it splits the entry and formats it before printing. Otherwise, it prints the entry as is.
     */
    public void printFormattedHistory() {
        if (history.isEmpty()) {
            System.out.println("Keine Einträge vorhanden");
            return;
        }

        for (String entry : history) {
            String[] parts = entry.split(" hat einen aktuellen Bestand von ");
            if (parts.length == 2) {
                System.out.println(parts[0] + " ▪ " + parts[1]);
            } else {
                System.out.println(entry);
            }
        }
    }

}
