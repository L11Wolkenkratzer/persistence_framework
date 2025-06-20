package ch.axa.punchclock.Repositories;

import org.springframework.data.repository.CrudRepository;

import ch.axa.punchclock.models.Entry;

public interface EntryRepository extends CrudRepository<Entry, Long>{
    
}
