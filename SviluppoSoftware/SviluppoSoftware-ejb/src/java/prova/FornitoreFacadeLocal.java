/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prova;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Matteo
 */
@Local
public interface FornitoreFacadeLocal {

    void create(Fornitore fornitore);

    void edit(Fornitore fornitore);

    void remove(Fornitore fornitore);

    Fornitore find(Object id);

    List<Fornitore> findAll();

}
