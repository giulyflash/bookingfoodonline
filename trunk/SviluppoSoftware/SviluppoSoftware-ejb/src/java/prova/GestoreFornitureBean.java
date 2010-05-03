/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prova;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import prova.LineaMagazzino;


/**
 *
 * @author Matteo
 */
@Stateless
public class GestoreFornitureBean implements GestoreFornitureLocal {
    @EJB
    private MateriaPrimaFacadeLocal materiaPrimaFacade;
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
        boolean trovato = false;


         /*MateriaPrima mp20 = new MateriaPrima();
            mp20.setId(Long.MIN_VALUE+40);
            mp20.setNome("radicchio");
            materiaPrimaFacade.create(mp20);*/

         List<Forniture> lf = fornitureFacade.findAll();
         for(Forniture f:lf)
            if(((f.getForn().getLocalita().equals(zona))&&(f.getMatPrima().getId().equals(id_materia))&&(!trovato)))
              { trovato=true;
                List<LineaMagazzino> lista = lineaMagazzinoFacade.findAll();
                for(LineaMagazzino linea:lista)
                    if((linea.getMag().getId().equals(id_mag))&&(linea.getMatPrima().getId().equals(id_materia)))
                        {linea.setQuantita(linea.getQuantita()+n_rifornimenti);
                         lineaMagazzinoFacade.edit(linea);
                        }
              }



        //lineaMagazzinoFacade.editLineaMagazzino(id_mag,id_materia, 1000);
       /*List<Forniture> lf= fornitureFacade.checkForniture(zona,id_materia);
       if(!lf.isEmpty())
           lineaMagazzinoFacade.editLineaMagazzino(id_mag,id_materia, n_rifornimenti);
       else
           throw new Exception("Fornitura non trovata");*/
   }
}
