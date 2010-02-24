/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prova;

import java.util.ArrayList;
import javax.jms.Queue;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.annotation.security.PermitAll;


/**
 *
 * @author Matteo
 */@PermitAll    
@Stateless
public class GestoreLineaMagazzinoBean implements GestoreLineaMagazzinoBeanLocal {
    @EJB
    private MateriaPrimaFacadeLocal materiaPrimaFacade;
    @EJB
    private MagazzinoFacadeLocal magazzinoFacade;


    @EJB
    private LineaMagazzinoFacadeLocal lineaMagazzinoFacade;


    @Resource(mappedName = "jms/ConsumerOrdineFactory")
    private ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/ConsumerOrdine")
    private Queue queue;

    @PermitAll    
    public void checkQuantita(Prenotazione p){
       // String zona = p.getZona();
        Long idMagazzino;        
        int quantitaMinima;
        int quantita;
        int n_rifornimenti;
        ArrayList<String> listaMaterie;
        //ArrayList<ConfigurazionePiatto> piatti = p.getListaPiatti();

        MateriaPrima mp = new MateriaPrima();
        mp.setId(Long.MIN_VALUE);
        mp.setNome("sugo");
       // o.println("Sono in checkQuantita");
        materiaPrimaFacade.create(mp);
      //  contattaFornitori("sugo",Long.MIN_VALUE,600);

       /* for(ConfigurazionePiatto cp: piatti){
            listaMaterie= cp.materiePrime();
            for(String nome:listaMaterie){
                LineaMagazzino o = (LineaMagazzino)lineaMagazzinoFacade.findCheckMateria(nome, zona);
                
                idMagazzino = o.getMag().getId();
                quantitaMinima = o.getSogliaMinima();
                quantita = o.getQuantita();
                n_rifornimenti = o.getN_rif();
                if(quantita<quantitaMinima)
                    contattaFornitori(zona,idMagazzino,n_rifornimenti);
            }
        }*/
    }

    /*private void contattaFornitori(String zona,Long id_Magazzino,int n_rifornimenti){
        try{
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);

            ObjectMessage message = session.createObjectMessage();
            message.setObject("salve giovani");
            // here we create NewsEntity, that will be sent in JMS message
            //message.setStringProperty("zona", zona);
            //message.setLongProperty("id_mag", id_Magazzino);
            //message.setIntProperty("rifornimenti", n_rifornimenti);
            messageProducer.send(message);
            messageProducer.close();
            connection.close();
    
        }catch(Exception e){}
    }*/

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
 
}
