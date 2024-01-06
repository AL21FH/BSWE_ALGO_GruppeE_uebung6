package org.lecture.storage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test class for the StorageHistory class.
 */
public class StorageHistoryTest {

    /**
     * Test to verify that the addEntry method correctly adds entries to the history list.
     */
    @Test
    void testAddEntry() {
        // Arrange
        StorageHistory storageHistory = new StorageHistory();
        String entry = "Test Entry";

        // Act
        storageHistory.addEntry(entry);

        // Assert
        assertTrue(storageHistory.getHistory().contains(entry), "Entry not found in history");
        assertEquals(1, storageHistory.getHistory().size(), "Unexpected history size");
    }
}
