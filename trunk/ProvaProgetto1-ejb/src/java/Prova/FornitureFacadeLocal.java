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
public interface FornitureFacadeLocal {

    void create(Forniture forniture);

    void edit(Forniture forniture);

    void remove(Forniture forniture);

    Forniture find(Object id);

    List<Forniture> findAll();

    List<Forniture> checkForniture(String zona,String nomeMateria);

}
