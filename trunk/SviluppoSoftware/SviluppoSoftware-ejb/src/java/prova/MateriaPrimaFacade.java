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
public class MateriaPrimaFacade implements MateriaPrimaFacadeLocal {
    @PersistenceContext
    private EntityManager em;

    public void create(MateriaPrima materiaPrima) {
        em.persist(materiaPrima);
    }

    public void edit(MateriaPrima materiaPrima) {
        em.merge(materiaPrima);
    }

    public void remove(MateriaPrima materiaPrima) {
        em.remove(em.merge(materiaPrima));
    }
    public MateriaPrima find(Object id) {
        return em.find(MateriaPrima.class, id);
    }
    public List<MateriaPrima> findAll() {
        return em.createQuery("select object(o) from MateriaPrima as o").getResultList();
    }
}
