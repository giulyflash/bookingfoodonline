/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prova;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.jms.Queue;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.annotation.security.PermitAll;
import javax.jms.Connection;
import javax.jms.MessageConsumer;
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
    private MateriaPrimaFacadeLocal materiaPrimaFacade;
    @EJB
    private MagazzinoFacadeLocal magazzinoFacade;


    @EJB
    private LineaMagazzinoFacadeLocal lineaMagazzinoFacade;


    @Resource(mappedName = "jms/ConsumazioneOrdiniFactory")
    private ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/ConsumazioneOrdini")
    private Queue queue;
   
    public void checkQuantita(Prenotazione p, PrintWriter ot){
        String zona = p.getZona();
        Long idMagazzino;
        Long id_materia;
        int quantitaMinima;
        int quantita;
        int n_rifornimenti;
        ArrayList<String> listaMaterie;
        ArrayList<ConfigurazionePiatto> piatti = p.getListaPiatti();


            

       for(ConfigurazionePiatto cp: piatti){
            listaMaterie= cp.materiePrime();
            ot.println(listaMaterie);
            for(String nome:listaMaterie){
                ot.println("agòiehgoòaeihgioawe");

                LineaMagazzino o = (LineaMagazzino)lineaMagazzinoFacade.findCheckMateria(nome, zona).get(0);
                id_materia = o.getMatPrima().getId();
                idMagazzino = o.getMag().getId();
                ot.println(id_materia.toString());
                quantitaMinima = o.getSogliaMinima();
                quantita = o.getQuantita();
                n_rifornimenti = o.getN_rif();           
                
                if(quantita<quantitaMinima)
                    contattaFornitori(zona,idMagazzino,n_rifornimenti,id_materia);
                    
                
            }
        }

    }

    private void contattaFornitori(String zona,Long id_Magazzino,int n_rifornimenti,Long materia){
        try{
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
           

            ObjectMessage message = session.createObjectMessage();            
            message.setLongProperty("id_mag", id_Magazzino);
            message.setLongProperty("id_materia", materia);
            message.setStringProperty("zona", zona);            
            message.setIntProperty("rifornimenti", n_rifornimenti);            
            messageProducer.send(message);

           
            MessageConsumer mc = session.createConsumer(queue);
            
            
            messageProducer.close();
           
            connection.close();
        }catch(Exception e){}
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")

}
