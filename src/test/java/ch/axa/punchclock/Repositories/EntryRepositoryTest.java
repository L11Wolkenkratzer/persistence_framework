
package ch.axa.punchclock.Repositories;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
 
import java.time.LocalDateTime;
 
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
 
import ch.axa.punchclock.models.Entry;
import jakarta.inject.Inject;
 
@SpringBootTest
public class EntryRepositoryTest {
   
    @Inject
    private EntryRepository entryRepository;
 
    @Test
    public void testIfEntryCanBeSaved() {
        Entry entry = new Entry();
        entry.setDescripiton("Awesome");
        entry.setCheck_in(LocalDateTime.now());
        entry.setDuration(60 * 60 * 2);
 
        entryRepository.save(entry);
 
        assertEquals(entry.getDescripiton(), entryRepository.findById(entry.getId()).get().getDescripiton());
    }
 
}