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
}
