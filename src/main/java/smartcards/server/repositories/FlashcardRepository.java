package smartcards.server.repositories;


import smartcards.server.models.Flashcard;
import org.springframework.data.repository.CrudRepository;

public interface FlashcardRepository extends CrudRepository<Flashcard, Integer> {



}
