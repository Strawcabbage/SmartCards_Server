package smartcards.server.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="FLASHCARD")
public class Flashcard {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Getter
    @Setter
    @Column(name="TERM")
    private String term;

    @Getter
    @Setter
    @Column(name="DEFINITION")
    private String definition;

    @ManyToOne
    @JoinColumn(name = "SET_ID") // Specifies the foreign key column in Flashcard table
    private Set set;
}
