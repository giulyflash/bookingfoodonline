/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prova;

import javax.ejb.Local;

/**
 *
 * @author Matteo
 */
@Local
public interface GestoreFornitureLocal {
    void gestisciRifornimenti(Long id_mag,Long id_materia,String zona,int n_rifornimenti)throws Exception;
}
