package smartcards.server.Services;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import smartcards.server.repositories.FlashcardRepository;
import org.springframework.stereotype.Service;
import smartcards.server.models.Flashcard;

import java.util.List;
import java.util.Optional;

@Service
public class FlashcardService {

    private final FlashcardRepository flashcardRepository;

    public FlashcardService(FlashcardRepository flashcardRepository) {
        this.flashcardRepository = flashcardRepository;
    }

    public Iterable<Flashcard> getAllFlashcards() {return this.flashcardRepository.findAll();}

    public Optional<Flashcard> getFlashcardById(Integer id) {return this.flashcardRepository.findById(id);}

    public List<Flashcard> getFlashcardBySetId(Integer set_id) {return this.flashcardRepository.findBySet_Id(set_id);}

    public Flashcard createFlashcard(@RequestBody Flashcard flashcard) {return this.flashcardRepository.save(flashcard);}

    public void deleteFlashcard(@PathVariable("id") Integer id) {this.flashcardRepository.deleteById(id);}

    public Flashcard updateSet(@RequestBody Flashcard flashcard) {return this.flashcardRepository.save(flashcard);}


    public void saveAll(List<Flashcard> flashcards) {this.flashcardRepository.saveAll(flashcards);}
}
