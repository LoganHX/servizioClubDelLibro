package it.unisa.c07.biblionet.model.entity;

import it.unisa.c07.biblionet.model.entity.utente.Biblioteca;
import it.unisa.c07.biblionet.model.entity.utente.Lettore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketPrestito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTicket;

    @NonNull
    @Column(nullable = false)
    private byte stato;

    @NonNull
    @Column(nullable = false)
    private LocalDateTime dataRichiesta;

    @NonNull
    @Column(nullable = false)
    private LocalDateTime dataRestituzione;

    @NonNull
    @Column(nullable = false)
    @ManyToOne
    private Libro libro;

    @NonNull
    @Column(nullable = false)
    @ManyToOne
    private Biblioteca biblioteca;

    @NonNull
    @Column(nullable = false)
    @ManyToOne
    private Lettore lettore;

}
