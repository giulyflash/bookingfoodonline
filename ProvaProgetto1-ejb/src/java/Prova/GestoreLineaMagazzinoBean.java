/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Prova;

import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Matteo
 */
@Stateless
public class GestoreLineaMagazzinoBean implements GestoreLineaMagazzinoBeanLocal {

    @EJB
    private LineaMagazzinoFacadeLocal lineaMagazzinoFacade;

    public void checkQuantità(Prenotazione p){
        String zona = p.getZona();
        ArrayList<String> listaMaterie;
        ArrayList<ConfigurazionePiatto> piatti = p.getListaPiatti();
        for(ConfigurazionePiatto cp: piatti){
            listaMaterie= cp.materiePrime();
            for(String nome:listaMaterie){
               
            }
        }
    }


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
 
}
