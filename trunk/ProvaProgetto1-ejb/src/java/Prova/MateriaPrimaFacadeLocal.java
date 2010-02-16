/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Prova;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Matteo
 */
@Local
public interface MateriaPrimaFacadeLocal {

    void create(MateriaPrima materiaPrima);

    void edit(MateriaPrima materiaPrima);

    void remove(MateriaPrima materiaPrima);

    MateriaPrima find(Object id);

    List<MateriaPrima> findAll();

}
