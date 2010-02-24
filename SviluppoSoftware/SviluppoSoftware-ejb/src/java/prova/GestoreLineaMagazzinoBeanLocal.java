/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prova;

import java.io.PrintWriter;
import javax.ejb.Local;

/**
 *
 * @author Matteo
 */
@Local
public interface GestoreLineaMagazzinoBeanLocal {

    void checkQuantita(Prenotazione p,PrintWriter o);
}


