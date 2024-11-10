package smartcards.server.repositories;

import smartcards.server.models.Flashcard;
import smartcards.server.models.Set;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SetRepository extends CrudRepository<Set, Integer> {

    public List<Set> findByName(String name);

}
