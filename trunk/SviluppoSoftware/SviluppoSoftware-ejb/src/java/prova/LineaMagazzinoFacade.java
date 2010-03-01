/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prova;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Matteo
 */
@Stateless
public class LineaMagazzinoFacade implements LineaMagazzinoFacadeLocal {
    @PersistenceContext
    private EntityManager em;

    public void create(LineaMagazzino lineaMagazzino) {
        em.persist(lineaMagazzino);
    }

    public void edit(LineaMagazzino lineaMagazzino) {
        em.merge(lineaMagazzino);

    }



    public void remove(LineaMagazzino lineaMagazzino) {
        em.remove(em.merge(lineaMagazzino));
    }

    public LineaMagazzino find(Object id) {
        return em.find(LineaMagazzino.class, id);
    }

    public List<LineaMagazzino> findAll() {
        return em.createQuery("select object(o) from LineaMagazzino as o").getResultList();
    }
   // public List<Integer> findQuantitaMateria(String nome,String zona){
    public List<LineaMagazzino> findCheckMateria(String nome,String zona){
        return(List<LineaMagazzino>)em.createQuery("select object(m) from LineaMagazzino m where m.mag.Localita = '"+zona+"' and m.matPrima.nome = '"+nome+"'").getResultList();
    }

    public void editLineaMagazzino(Long id_mag,Long id_materia,int quantitaAggiunta){
        List<LineaMagazzino> Lista = em.createQuery("select object(m) from LineaMagazzino m where m.mag.id = "+ id_mag+ " and m.matPrima.id = "+ id_materia).getResultList();
        //Lista.get(0).setQuantita(500);
        Lista.get(0).setQuantita(Lista.get(0).getQuantita()+ quantitaAggiunta);
        edit(Lista.get(0));
    }


    public List<LineaMagazzino> findLocalita(){
        //return (String)em.createQuery("SELECT lm.mag.LocalitÃ  FROM LineaMagazzino lm WHERE lm.mag.LocalitÃ ='Torino'").getSingleResult();
        return em.createQuery("select l from LineaMagazzino l where l.sogliaMinima = '50'").getResultList();
    }
}
