/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prova;

import javax.ejb.Stateless;
import java.util.*;
import javax.ejb.EJB;

/**
 *
 * @author Matteo
 */
@Stateless
public class GestorePiattoBean implements GestorePiattoBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
    @EJB
    private PiattoFacadeLocal piattoFacade;

    public GestorePiattoBean(){}

    public List<Piatto> findPiatti() {
       List<Piatto> aP = piattoFacade.findAll();
        return aP;
    }

    public void addPiatto(Piatto piatto) {
        
        piattoFacade.create(piatto);
    }
    public List<Piatto> findPiattiPerCategoria(String categoria){
        return null;


    }


    
 
}
