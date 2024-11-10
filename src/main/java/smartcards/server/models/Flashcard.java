package smartcards.server.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    private String term;

    @Setter
    private String definition;

    @Setter
    private int set_num;

    @Setter
    @ManyToOne
    private Set set;


}
