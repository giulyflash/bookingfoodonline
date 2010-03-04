/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prova;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dani1913
 */
@Local
public interface UtenteRegistratoFacadeLocal {

    void create(UtenteRegistrato utenteRegistrato);

    void edit(UtenteRegistrato utenteRegistrato);

    void remove(UtenteRegistrato utenteRegistrato);

    UtenteRegistrato find(Object id);

    List<UtenteRegistrato> findAll();

    List<UtenteRegistrato> findRange(int[] range);

    int count();

}
