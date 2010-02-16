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
public interface MagazzinoFacadeLocal {

    void create(Magazzino magazzino);

    void edit(Magazzino magazzino);

    void remove(Magazzino magazzino);

    Magazzino find(Object id);

    List<Magazzino> findAll();
    
    Long findId(String zona);

}    

