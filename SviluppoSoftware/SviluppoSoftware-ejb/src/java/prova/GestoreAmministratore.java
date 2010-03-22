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
public class GestoreAmministratore implements GestoreAmministratoreLocal {
    @EJB
    private AmministratoreFacadeLocal amministratoreFacade;



    public Amministratore findAdmin(String identificator) {
        return amministratoreFacade.find(identificator);
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


}
