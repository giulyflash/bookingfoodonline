/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Prova;

import java.util.*;
import javax.ejb.Local;

/**
 *
 * @author Matteo
 */
@Local
public interface PiattoFacadeLocal {

    void create(Piatto piatto);

    void edit(Piatto piatto);

    void remove(Piatto piatto);

    Piatto find(Object id);

    List<Piatto> findAll();

}
