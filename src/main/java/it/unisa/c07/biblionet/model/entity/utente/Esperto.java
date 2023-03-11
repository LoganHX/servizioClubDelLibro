package it.unisa.c07.biblionet.model.entity.utente;

import it.unisa.c07.biblionet.model.entity.ClubDelLibro;
import it.unisa.c07.biblionet.model.entity.Genere;
import it.unisa.c07.biblionet.utils.Length;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

/**
 * Questa classe rappresenta un Esperto
 * Un esperto possiede un username ,un nome e un cognome.
 * Un esperto ha una biblioteca per cui lavora,
 * una lista di generi di cui è esperto,
 * e una lista di club che gestisce.
 */
@Entity
@SuperBuilder
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class Esperto implements HaGenere {

    @Id
    @Column(nullable = false, length = Length.LENGTH_320)
    @NonNull
    private String email;



    /**
     * Rappresenta la biblioteca dove lavora l'esperto. todo gestita attraverso la "chiave esterna"
     */
    @Column(nullable = false, length = Length.LENGTH_60)
    @NonNull
    private String emailBiblioteca;

    /**
     * Rappresenta la lista di generi di cui un esperto è esperto.
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Genere> generi;

    /**
     * Rappresenta la lista di club gestiti dall'esperto.
     */
    @OneToMany
    @ToString.Exclude
    private List<ClubDelLibro> clubs;


    /**
     *
     * @param email È la mail dell'esperto.
     * @param biblioteca È la biblioteca dove lavora l'esperto.
     */
    public Esperto(final String email,
                   final String biblioteca) {
        this.email = email;
        this.emailBiblioteca = biblioteca;
    }
/*
    public boolean equals (Object o){
        if(o instanceof Esperto) {
            Esperto e = (Esperto)o;
            return e.getEmail().equals(this.getEmail());
        }
        else
            return false;
    }
*/
}
