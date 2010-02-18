/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Prova;

import java.util.ArrayList;
import javax.jms.Connection;
import javax.jms.Queue;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;


/**
 *
 * @author Matteo
 */
@Stateless
public class GestoreLineaMagazzinoBean implements GestoreLineaMagazzinoBeanLocal {
    @EJB
    private MagazzinoFacadeLocal magazzinoFacade;

    @EJB
    private LineaMagazzinoFacadeLocal lineaMagazzinoFacade;

    private MagazzinoFacadeLocal MagazzinoFacade;

    @Resource(mappedName = "jms/ConsumerOrdineFactory")
    private ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/ConsumerOrdine")
    private Queue queue;

    public void checkQuantità(Prenotazione p){
        String zona = p.getZona();
        Long idMagazzino;        
        int quantitaMinima;
        int quantita;
        int n_rifornimenti;
        ArrayList<String> listaMaterie;
        ArrayList<ConfigurazionePiatto> piatti = p.getListaPiatti();
        for(ConfigurazionePiatto cp: piatti){
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
        }
    }

    private void contattaFornitori(String zona,Long id_Magazzino,int n_rifornimenti){
        try{
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);

            ObjectMessage message = session.createObjectMessage();
            // here we create NewsEntity, that will be sent in JMS message
            message.setStringProperty("zona", zona);
            message.setLongProperty("id_mag", id_Magazzino);
            message.setIntProperty("rifornimenti", n_rifornimenti);
            messageProducer.send(message);
            messageProducer.close();
            connection.close();
    
        }catch(Exception e){}
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
 
}
