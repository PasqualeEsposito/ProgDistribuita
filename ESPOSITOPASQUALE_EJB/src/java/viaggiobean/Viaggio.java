/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viaggiobean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlRootElement;
import static viaggiobean.Viaggio.CERCA_CATEGORIA;
import static viaggiobean.Viaggio.CERCA_DESTINAZIONE;
import static viaggiobean.Viaggio.CERCA_ID;
import static viaggiobean.Viaggio.CERCA_PER_PREZZO;
import static viaggiobean.Viaggio.TUTTI_I_VIAGGI;


@Entity
@NamedQueries({
    @NamedQuery(name = CERCA_ID, query = "SELECT v FROM Viaggio v WHERE v.id = ?1"),
    @NamedQuery(name = CERCA_CATEGORIA, query = "SELECT v FROM Viaggio v WHERE v.categoria = ?1"),
    @NamedQuery(name = CERCA_DESTINAZIONE, query = "SELECT v FROM Viaggio v WHERE v.destinazione = ?1"),
    @NamedQuery(name = CERCA_PER_PREZZO, query = "SELECT v FROM Viaggio v WHERE v.prezzo < ?1"),
    @NamedQuery(name = TUTTI_I_VIAGGI, query = "SELECT v FROM Viaggio v")
})
@XmlRootElement
public class Viaggio implements Serializable {
    public static final String CERCA_ID = "Viaggio.cercaId";
    public static final String CERCA_CATEGORIA = "Viaggio.cercaCategoria";
    public static final String CERCA_DESTINAZIONE = "Viaggio.cercaDestinazione";
    public static final String CERCA_PER_PREZZO = "Viaggio.cercaPerPrezzo";
    public static final String TUTTI_I_VIAGGI = "Viaggio.tuttiIViaggi";
    
    @Id
    private int id;
    private String categoria;
    private String destinazione;
    private int pacchetti;
    private float prezzo;
    //Aggiunta annotazioni per delimitare il range del campo "sconto"
    @Min(0) @Max(100)
    private int sconto;
    private int disponibilita;

    public Viaggio() {
    }

    public Viaggio(int id, String categoria, String destinazione, int pacchetti, float prezzo, int sconto, int disponibilita) {
        this.id = id;
        this.categoria = categoria;
        this.destinazione = destinazione;
        this.pacchetti = pacchetti;
        this.prezzo = prezzo;
        this.sconto = sconto;
        this.disponibilita = disponibilita;
    }

    public int getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public int getPacchetti() {
        return pacchetti;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public int getSconto() {
        return sconto;
    }

    public int getDisponibilita() {
        return disponibilita;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public void setPacchetti(int pacchetti) {
        this.pacchetti = pacchetti;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public void setSconto(int sconto) {
        this.sconto = sconto;
    }

    public void setDisponibilita(int disponibilita) {
        this.disponibilita = disponibilita;
    }

    @Override
    public String toString() {
        return "Viaggio{" + "id=" + id + ", categoria=" + categoria + ", destinazione=" + destinazione + ", pacchetti=" + pacchetti + ", prezzo=" + prezzo + ", sconto=" + sconto + ", disponibilita=" + disponibilita + '}';
    }
}
