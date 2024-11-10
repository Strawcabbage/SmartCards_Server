package smartcards.server.controllers;

import smartcards.server.Services.SetService;
import smartcards.server.models.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/sets")
public class SetController {

    @Autowired
    private SetService setService;

    @GetMapping("/all")
    public Iterable<Set> getAllSets() {return setService.getAllSets();}

    @GetMapping("/{id}")
    public Optional<Set> getSetById(@PathVariable("id") Integer id) {return setService.getSetById(id);}

}
