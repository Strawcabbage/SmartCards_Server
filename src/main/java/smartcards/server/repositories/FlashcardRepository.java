package smartcards.server.repositories;


import smartcards.server.models.Flashcard;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlashcardRepository extends CrudRepository<Flashcard, Integer> {

    List<Flashcard> findBySet_Id(Integer set_id);

}
