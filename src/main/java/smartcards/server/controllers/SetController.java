package smartcards.server.controllers;

import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;
import smartcards.server.Services.SetService;
import smartcards.server.models.Set;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Transactional
    @PostMapping("/create")
    public Set createSet(@RequestBody Set set) {
        System.out.println("Creating Set: " + set.getName());
        return this.setService.createSet(set);

    }

    @DeleteMapping("/delete/{id}")
    public Set deleteSet(@PathVariable("id") Integer id) {

        Optional<Set> setOptional = this.setService.getSetById(id);

        if (setOptional.isEmpty()) {
            return null;
        }

        Set setToDelete = setOptional.get();
        this.setService.deleteSet(id);
        return setToDelete;

    }

    @PutMapping("/update")
    public Set updatSet(@RequestBody Set set) {

        Optional<Set> setOptional = this.setService.getSetById(set.getId());

        if (setOptional.isEmpty()) {
            return null;
        }

        Set setToUpdate = setOptional.get();
        if (set.getName() != null) {
            setToUpdate.setName(set.getName());
        }

        return this.setService.updateSet(setToUpdate);

    }


}
