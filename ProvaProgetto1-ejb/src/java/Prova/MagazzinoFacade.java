/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Prova;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Matteo
 */
@Stateless
public class MagazzinoFacade implements MagazzinoFacadeLocal {
    @PersistenceContext
    private EntityManager em;

    public void create(Magazzino magazzino) {
        em.persist(magazzino);
    }

    public void edit(Magazzino magazzino) {
        em.merge(magazzino);
    }

    public void remove(Magazzino magazzino) {
        em.remove(em.merge(magazzino));
    }

    public Magazzino find(Object id) {
        return em.find(Magazzino.class, id);
    }

    public List<Magazzino> findAll() {
        return em.createQuery("select object(o) from Magazzino as o").getResultList();
    }

    public Long findId(String zona){
        return (Long)em.createQuery("SELECT id FROM MAGAZZINO" + " WHERE zona= '"+zona+"'").getSingleResult();
    }


}
