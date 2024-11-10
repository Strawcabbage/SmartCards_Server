package smartcards.server.repositories;


import smartcards.server.models.Flashcard;
import org.springframework.data.repository.CrudRepository;
import smartcards.server.models.Set;

import java.util.List;

public interface FlashcardRepository extends CrudRepository<Flashcard, Integer> {

    public List<Flashcard> findBySet(Set set);

}
