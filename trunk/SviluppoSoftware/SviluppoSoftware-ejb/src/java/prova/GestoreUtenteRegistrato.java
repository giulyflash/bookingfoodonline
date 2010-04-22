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

    public void addUser(UtenteRegistrato utente) {
        utenteRegistratoFacade.create(utente);
    }

    public UtenteRegistrato findUser(String username) {
        return utenteRegistratoFacade.find(username);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
