/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viaggiobean;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author corso-pd
 */
@Remote
public interface ViaggioEJBRemote {
    public void aggiungiViaggio(Viaggio v);
    public void rimuoviViaggio(Viaggio v);
    public void aggiornaViaggio(Viaggio v);
    
    public List<Viaggio> cercaPerPrezzo(float prezzo);
    public List<Viaggio> cercaCategoria(String categoria);
    public List<Viaggio> cercaDestinazione(String destinazione);
    public List<Viaggio> tuttiIViaggi();
    public Viaggio cercaId(int id);
}
