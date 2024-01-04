package org.lecture.storage;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StorageHistory {
    private List<String> history = new ArrayList<>();

    public void addEntry(String entry) {
        history.add(entry);
    }
}
