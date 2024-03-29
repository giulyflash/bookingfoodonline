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
public interface LineaMagazzinoFacadeLocal {

    void create(LineaMagazzino lineaMagazzino);

    void edit(LineaMagazzino lineaMagazzino);

    void remove(LineaMagazzino lineaMagazzino);

    LineaMagazzino find(Object id);

    List<LineaMagazzino> findAll();

    List<LineaMagazzino> findCheckMateria(String nome,String zona);

    List<LineaMagazzino> findLocalità();


}
