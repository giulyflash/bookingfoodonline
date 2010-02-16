/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Prova;

import java.util.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Matteo
 */
@Stateless
public class PiattoFacade implements PiattoFacadeLocal {
    @PersistenceContext
    private EntityManager em;

    public void create(Piatto piatto) {
        em.persist(piatto);
    }

    public void edit(Piatto piatto) {
        em.merge(piatto);
    }

    public void remove(Piatto piatto) {
        em.remove(em.merge(piatto));
    }

    public Piatto find(Object id) {
        return em.find(Piatto.class, id);
    }

    public List<Piatto> findAll() {
        return em.createQuery("select object(o) from Piatto as o").getResultList();
    }

}
