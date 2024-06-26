package org.jabref.logic.importer;

import org.jabref.logic.bibtex.FieldPreferences;
import org.jabref.logic.cleanup.ConvertToBibtexCleanup;
import org.jabref.model.entry.BibEntry;

public class ImportCleanupBibtex extends ImportCleanup {

    private final ConvertToBibtexCleanup convertToBibtexCleanup = new ConvertToBibtexCleanup();

    public ImportCleanupBibtex(FieldPreferences fieldPreferences) {
        super(fieldPreferences);
    }

    /**
     * Performs a format conversion of the given entry into the targeted format.
     * Modifies the given entry and also returns it to enable usage of doPostCleanup in streams.
     *
     * @return Cleaned up BibEntry
     */
    @Override
    public BibEntry doPostCleanup(BibEntry entry) {
        entry = super.doPostCleanup(entry);
        convertToBibtexCleanup.cleanup(entry);
        return entry;
    }
}
