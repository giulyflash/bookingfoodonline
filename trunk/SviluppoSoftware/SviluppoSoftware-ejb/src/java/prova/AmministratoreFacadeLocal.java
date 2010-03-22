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
public interface AmministratoreFacadeLocal {

    void create(Amministratore amministratore);

    void edit(Amministratore amministratore);

    void remove(Amministratore amministratore);

    Amministratore find(Object id);

    List<Amministratore> findAll();

    List<Amministratore> findRange(int[] range);

    int count();

}
