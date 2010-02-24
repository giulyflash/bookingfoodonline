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
public interface GestorePiattoBeanLocal {

    public List<Piatto> findPiatti();

    public void addPiatto(Piatto piatto);
}
