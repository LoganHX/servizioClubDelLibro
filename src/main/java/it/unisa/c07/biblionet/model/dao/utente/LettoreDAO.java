package it.unisa.c07.biblionet.model.dao.utente;

import it.unisa.c07.biblionet.model.entity.utente.Lettore;
import it.unisa.c07.biblionet.model.entity.utente.UtenteRegistrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Questa classe rappresenta il DAO di un Lettore.
 */
@Repository
public interface LettoreDAO extends JpaRepository<Lettore, String> {
    /**
     * Implementa la funzionalità di ricerca di un utente Lettore nel DB.
     * @param email dell'utente da cercare.
     * @return dell'utente trovato.
     */
    Lettore findByEmail(String email);

    /**
     * Query custom che recupera dal DB un lettore dato il
     * suo id.
     * @param email L'ID del lettore
     * @return Lettore trovato
     */
    @Query("SELECT l FROM Lettore l WHERE l.email=?1")
    Lettore findByID(String email);


}
