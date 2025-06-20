package ch.axa.punchclock.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ch.axa.punchclock.models.Entry;
import jakarta.inject.Inject;

@SpringBootTest
public class EntryServiceTest {

    @Inject
    private EntryService entryService;

    @Test
    public void testIfEntryCanBeSaved() {
        Entry entry = new Entry();
        entry.setDescripiton("Awesome");
        entry.setCheck_in(LocalDateTime.now());
        entry.setDuration(60 * 60 * 2);

        entryService.create(entry);

        assertEquals(entry.getDescripiton(), entryService.read(entry.getId()).getDescripiton());
    }

    @Test
    public void testIfEntryCanBeUpdated() {
        Entry entry = new Entry();
        entry.setDescripiton("Initial");
        entry.setCheck_in(LocalDateTime.now());
        entry.setDuration(3600);
        entryService.create(entry);

        entry.setDescripiton("Updated");
        entryService.update(entry);

        Entry updated = entryService.read(entry.getId());
        assertEquals("Updated", updated.getDescripiton());
    }

    @Test
    public void testIfEntryCanBeListed() {
        Entry entry1 = new Entry();
        entry1.setDescripiton("First");
        entry1.setCheck_in(LocalDateTime.now());
        entry1.setDuration(3600);

        Entry entry2 = new Entry();
        entry2.setDescripiton("Second");
        entry2.setCheck_in(LocalDateTime.now());
        entry2.setDuration(7200);

        entryService.create(entry1);
        entryService.create(entry2);

        List<Entry> entries = entryService.index();
        assertTrue(entries.size() >= 2);
    }

    @Test
    public void testIfEntryCanBeDeleted() {
        Entry entry = new Entry();
        entry.setDescripiton("To be deleted");
        entry.setCheck_in(LocalDateTime.now());
        entry.setDuration(1800);

        entryService.create(entry);
        Long id = entry.getId();

        entryService.delete(entry);

        assertNull(entryService.read(id));
    }

}