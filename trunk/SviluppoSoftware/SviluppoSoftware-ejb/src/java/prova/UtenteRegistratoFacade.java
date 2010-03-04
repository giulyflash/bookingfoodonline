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
public class UtenteRegistratoFacade implements UtenteRegistratoFacadeLocal {
    @PersistenceContext(unitName = "SviluppoSoftware-ejbPU")
    private EntityManager em;

    public void create(UtenteRegistrato utenteRegistrato) {
        em.persist(utenteRegistrato);
    }

    public void edit(UtenteRegistrato utenteRegistrato) {
        em.merge(utenteRegistrato);
    }

    public void remove(UtenteRegistrato utenteRegistrato) {
        em.remove(em.merge(utenteRegistrato));
    }

    public UtenteRegistrato find(Object id) {
        return em.find(UtenteRegistrato.class, id);
    }

    public List<UtenteRegistrato> findAll() {
        return em.createQuery("select object(o) from UtenteRegistrato as o").getResultList();
    }

    public List<UtenteRegistrato> findRange(int[] range) {
        Query q = em.createQuery("select object(o) from UtenteRegistrato as o");
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        return ((Long) em.createQuery("select count(o) from UtenteRegistrato as o").getSingleResult()).intValue();
    }

}
