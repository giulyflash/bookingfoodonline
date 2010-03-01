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
public class FornitureFacade implements FornitureFacadeLocal {
    @PersistenceContext
    private EntityManager em;

    public void create(Forniture forniture) {
        em.persist(forniture);
    }

    public void edit(Forniture forniture) {
        em.merge(forniture);
    }

    public void remove(Forniture forniture) {
        em.remove(em.merge(forniture));
    }

    public Forniture find(Object id) {
        return em.find(Forniture.class, id);
    }

    public List<Forniture> findAll() {
        return em.createQuery("select object(o) from Forniture as o").getResultList();
    }

    public List<Forniture> checkForniture(String zona,Long idMateria){
        return(List<Forniture>)em.createQuery("select object(f) from Forniture f where f.forn.localita = '"+zona+"' and f.matPrima.id = "+idMateria).getResultList();
    }
}
