package it.unisa.c07.biblionet.gestioneEventi.service;

import java.util.Optional;

import it.unisa.c07.biblionet.model.entity.Evento;
import it.unisa.c07.biblionet.model.entity.Libro;

/**
 * Implementa l'interfaccia service
 * per il sottosistema GestioneEventi.
 * @author Nicola Pagliara
 * @author Luca Topo
 */
public interface GestioneEventiService {

    /**
     * Implementa la funzionalità che permette
     * di trovare un evento dato il suo identificativo
     * @param idEvento L'identificativo dell'evento
     * @return L'Evento trovato
     */
    Optional<Evento> getEventoById(int idEvento);

    /**
     * Implementa la funzionalità che permette
     * ad un Esperto di organizzare un Evento.
     * @param evento L'Evento da memorizzare
     * @return L'Evento appena creato
     */
    Evento creaEvento(Evento evento);

    /**
     * Implementa la funzionalità che permette
     * ad un Esperto di modificare un Evento
     * precentemente creato da lui stesso.
     * @param evento L'Evento modificato da
     *               memorizzare
     * @return L'Evento modificato
     */
    Evento modificaEvento(Evento evento);

    /**
     * Metodo di utilità per recuperare
     * un libro a partire dall'ID.
     * @param id Id del libro da recuperare
     * @return Il libro recuperato
     */
    Optional<Libro> getLibroById(int id);

    /**
     * Implementa la funzionalità che permette
     * ad un Esperto di eliminare un evento.
     * @param id L'id dell'evento da eliminare
     * @return L'evento che è stato eliminato, o
     *         un Optional vuoto se l'evento non
     *         esiste.
     */
    Optional<Evento> eliminaEvento(int id);
}
