/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prova;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dani1913
 */
@Stateless
public class AmministratoreFacade implements AmministratoreFacadeLocal {
    @PersistenceContext(unitName = "SviluppoSoftware-ejbPU")
    private EntityManager em;

    public void create(Amministratore amministratore) {
        em.persist(amministratore);
    }

    public void edit(Amministratore amministratore) {
        em.merge(amministratore);
    }

    public void remove(Amministratore amministratore) {
        em.remove(em.merge(amministratore));
    }

    public Amministratore find(Object id) {
        return em.find(Amministratore.class, id);
    }

    public List<Amministratore> findAll() {
        return em.createQuery("select object(o) from Amministratore as o").getResultList();
    }

    public List<Amministratore> findRange(int[] range) {
        Query q = em.createQuery("select object(o) from Amministratore as o");
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        return ((Long) em.createQuery("select count(o) from Amministratore as o").getSingleResult()).intValue();
    }

}
