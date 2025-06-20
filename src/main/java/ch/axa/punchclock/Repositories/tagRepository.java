package ch.axa.punchclock.Repositories;

import org.springframework.data.repository.CrudRepository;

import ch.axa.punchclock.models.tag;

public interface tagRepository extends CrudRepository<tag, Long> {}