/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prova;

import javax.ejb.Local;

/**
 *
 * @author dani1913
 */
@Local
public interface GestoreAmministratoreLocal {

    Amministratore findAdmin(String identificator);
    
}
