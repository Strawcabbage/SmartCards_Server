package smartcards.server.Services;

import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import smartcards.server.models.Set;
import smartcards.server.repositories.SetRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SetService {

    private final SetRepository setRepository;

    public SetService(SetRepository setRepository) {
        this.setRepository = setRepository;
    }

    public Iterable<Set> getAllSets() { return this.setRepository.findAll();}

    public Optional<Set> getSetById(Integer id) { return this.setRepository.findById(id);}

    @Transactional
    public Set createSet(@RequestBody Set set) {return this.setRepository.save(set);}

    public void deleteSet(Integer id) {this.setRepository.deleteById(id);}

    public Set updateSet(@RequestBody Set set) {return this.setRepository.save(set);}

}
