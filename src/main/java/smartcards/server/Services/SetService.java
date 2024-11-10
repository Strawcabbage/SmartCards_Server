package smartcards.server.Services;

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

}
