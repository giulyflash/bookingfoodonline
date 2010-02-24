/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prova;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Matteo
 */
@Stateless
public class FornitoreFacade implements FornitoreFacadeLocal {
    @PersistenceContext
    private EntityManager em;

    public void create(Fornitore fornitore) {
        em.persist(fornitore);
    }

    public void edit(Fornitore fornitore) {
        em.merge(fornitore);
    }

    public void remove(Fornitore fornitore) {
        em.remove(em.merge(fornitore));
    }

    public Fornitore find(Object id) {
        return em.find(Fornitore.class, id);
    }

    public List<Fornitore> findAll() {
        return em.createQuery("select object(o) from Fornitore as o").getResultList();
    }
    

}
