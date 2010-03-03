/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prova;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author Matteo
 */
@Stateless
public class GestoreFornitureBean implements GestoreFornitureLocal {
    @EJB
    private LineaMagazzinoFacadeLocal lineaMagazzinoFacade;
    @EJB
    private FornitoreFacadeLocal fornitoreFacade;
    @EJB
    private FornitureFacadeLocal fornitureFacade;




    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
    //Eccezione da catturare**************************************************//
    public void gestisciRifornimenti(Long id_mag,Long id_materia,String zona,int n_rifornimenti)throws Exception{
       List<Forniture> lf= fornitureFacade.checkForniture(zona,id_materia);
       if(!lf.isEmpty())
           lineaMagazzinoFacade.editLineaMagazzino(id_mag,id_materia, n_rifornimenti);
       else
           throw new Exception("Fornitura non trovata");
   }
}
