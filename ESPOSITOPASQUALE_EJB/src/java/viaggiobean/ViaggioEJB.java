/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viaggiobean;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author corso-pd
 */
@Stateless
@LocalBean
@WebService
public class ViaggioEJB implements ViaggioEJBRemote {
    @Inject
    private EntityManager em;
    
    @Override
    public void aggiungiViaggio(Viaggio v) {
        em.persist(v);
    }

    @Override
    public void rimuoviViaggio(Viaggio v) {
        em.remove(em.merge(v));
    }

    @Override
    public void aggiornaViaggio(Viaggio v) {
        em.merge(v);
    }

    @Override
    public List<Viaggio> cercaPerPrezzo(float prezzo) {
        TypedQuery<Viaggio> q = em.createNamedQuery(Viaggio.CERCA_PER_PREZZO, Viaggio.class);
        q.setParameter(1, prezzo);
        return q.getResultList();
    }

    @Override
    public List<Viaggio> cercaCategoria(String categoria) {
        TypedQuery<Viaggio> q = em.createNamedQuery(Viaggio.CERCA_CATEGORIA, Viaggio.class);
        q.setParameter(1, categoria);
        return q.getResultList();
    }

    @Override
    public List<Viaggio> cercaDestinazione(String destinazione) {
        TypedQuery<Viaggio> q = em.createNamedQuery(Viaggio.CERCA_DESTINAZIONE, Viaggio.class);
        q.setParameter(1, destinazione);
        return q.getResultList();
    }

    @Override
    public List<Viaggio> tuttiIViaggi() {
        TypedQuery<Viaggio> q = em.createNamedQuery(Viaggio.TUTTI_I_VIAGGI, Viaggio.class);
        return q.getResultList();
    }

    @Override
    public Viaggio cercaId(int id) {
        TypedQuery<Viaggio> q = em.createNamedQuery(Viaggio.CERCA_ID, Viaggio.class);
        q.setParameter(1, id);
        return q.getSingleResult();
    }
}
