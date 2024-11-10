package smartcards.server.controllers;

import org.springframework.web.bind.annotation.*;
import smartcards.server.Services.FlashcardService;
import smartcards.server.models.Flashcard;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

@RestController
@RequestMapping("/flashcards")
public class FlashcardController {

    @Autowired
    private FlashcardService flashcardService;

    @GetMapping("/all")
    public Iterable<Flashcard> getAllFlashcards() {return flashcardService.getAllFlashcards();}

    @PostMapping("/create")
    public Flashcard createFlashcard(@RequestBody Flashcard flashcard) {

        if (!Objects.equals(flashcard.getId(), this.flashcardService.getFlashcardById(flashcard.getId()))) {
            return this.flashcardService.createFlashcard(flashcard);
        } else { return null; }

    }

}
