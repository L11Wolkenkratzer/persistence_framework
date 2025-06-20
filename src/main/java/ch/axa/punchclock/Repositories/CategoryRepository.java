
package ch.axa.punchclock.Repositories;

import org.springframework.data.repository.CrudRepository;

import ch.axa.punchclock.models.category;

public interface CategoryRepository extends CrudRepository<category, Long> {}
