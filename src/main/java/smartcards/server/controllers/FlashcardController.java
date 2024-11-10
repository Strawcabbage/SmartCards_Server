package smartcards.server.controllers;

import org.springframework.web.bind.annotation.*;
import smartcards.server.Services.FlashcardService;
import smartcards.server.Services.SetService;
import smartcards.server.models.Flashcard;
import org.springframework.beans.factory.annotation.Autowired;
import smartcards.server.models.Set;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/flashcards")
public class FlashcardController {

    @Autowired
    private FlashcardService flashcardService;

    @Autowired
    private SetService setService;

    @GetMapping("/all")
    public Iterable<Flashcard> getAllFlashcards() {return flashcardService.getAllFlashcards();}

    @GetMapping("/set")
    public Iterable<Flashcard> getFlashcardBySet(@RequestBody Set set) {

        Optional<Set> setOptional = this.setService.getSetById(set.getId());

        if (setOptional.isEmpty()) {
            return null;
        }

        return this.flashcardService.getFlashcardBySet(set);

    }

    @PostMapping("/create")
    public Flashcard createFlashcard(@RequestBody Flashcard flashcard) {

        if (!Objects.equals(flashcard.getId(), this.flashcardService.getFlashcardById(flashcard.getId()))) {
            return this.flashcardService.createFlashcard(flashcard);
        } else { return null; }

    }

    @DeleteMapping("/delete/{id}")
    public Flashcard deleteFlashcard(@PathVariable("id") Integer id) {

        Optional<Flashcard> flashcardOptional = this.flashcardService.getFlashcardById(id);

        if (flashcardOptional.isEmpty()) {
            return null;
        }

        Flashcard flashcardToDelete = flashcardOptional.get();
        this.flashcardService.deleteFlashcard(id);
        return flashcardToDelete;

    }

    @PutMapping("/update")
    public Flashcard updatFlashcard(@RequestBody Flashcard flashcard) {

        Optional<Flashcard> setOptional = this.flashcardService.getFlashcardById(flashcard.getId());

        if (setOptional.isEmpty()) {
            return null;
        }

        Flashcard flashcardToUpdate = setOptional.get();
        if (flashcard.getTerm() != null) {
            flashcardToUpdate.setTerm(flashcard.getTerm());
        }
        if (flashcard.getDefinition() != null) {
            flashcardToUpdate.setDefinition(flashcard.getDefinition());
        }
        if (flashcard.getSet() != null) {
            flashcardToUpdate.setSet(flashcard.getSet());
        }

        return this.flashcardService.updateSet(flashcardToUpdate);

    }

}
