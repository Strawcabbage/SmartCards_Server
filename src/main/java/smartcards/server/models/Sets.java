package smartcards.server.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Sets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    private String name;
    /*
    @Getter
    @Setter
    @Column(name = "USER_NAME")
    private String userName;
    */
    @Setter
    @OneToMany(mappedBy = "set", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Flashcard> flashcards = new ArrayList<>();

}
