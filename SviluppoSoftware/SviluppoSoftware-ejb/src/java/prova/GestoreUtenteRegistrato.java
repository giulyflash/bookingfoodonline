/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prova;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author dani1913
 */
@Stateless
public class GestoreUtenteRegistrato implements GestoreUtenteRegistratoLocal {

    @EJB
    private UtenteRegistratoFacadeLocal utenteRegistratoFacade;



    public GestoreUtenteRegistrato() {
    }

    /* aggiunta nuovo utente - registrazione - */
    public void addUser(UtenteRegistrato user) {
        utenteRegistratoFacade.create(user);
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


 
}
