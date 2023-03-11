package it.unisa.c07.biblionet.model.entity.utente;

import it.unisa.c07.biblionet.model.entity.ClubDelLibro;
import it.unisa.c07.biblionet.model.entity.Genere;
import it.unisa.c07.biblionet.model.entity.Evento;
import it.unisa.c07.biblionet.utils.Length;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.util.List;

/**
 * Questa classe rappresenta un Lettore.
 * Un Lettore può essere interessato a più generi,
 * può partecipare a più eventi,
 * e far parte di più club.
 */
@Entity
@SuperBuilder
@Data
@NoArgsConstructor
public class Lettore implements HaGenere {
    @Id
    @Column(nullable = false, length = Length.LENGTH_320)
    @NonNull
    private String email;


    /**
     * Rappresenta i generi che interessano a un lettore.
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Genere> generi;

    /**
     * Rappresenta i clubs a cui il lettore appartiene.
     */
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @ToString.Exclude
    private List<ClubDelLibro> clubs;

    /**
     * Rappresenta gli eventi a cui prende parte.
     */
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @ToString.Exclude
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Evento> eventi;

    /**
     * Rappresenta i tickets a cui è collegato.
     */
    /*
    todo gestita nell'altro sottosistema con un riferimento alla chiave (email) del lettore
    @OneToMany
    @ToString.Exclude
    private List<TicketPrestito> tickets;
    */



    /**
     *
     * @param email la email del lettore.

     */
    public Lettore(final String email) {
        this.email = email;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj.getClass().equals(this.getClass())) {
            Lettore lettore = (Lettore) obj;
            return (this.getEmail().equals(lettore.getEmail()));
        }
        return false;
    }


}
