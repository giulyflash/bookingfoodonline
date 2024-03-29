/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prova;

import java.io.PrintWriter;
import javax.jms.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.jms.Queue;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
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
        try{
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer mc = session.createConsumer(queue);
            MessageProducer messageProducer = session.createProducer(queue);

            Long idMagazzino;
            Long id_materia;
            int quantitaMinima;
            int quantita;
            int n_rifornimenti;
            ArrayList<String> listaMaterie;
            String zona = p.getZona();
            ConfigurazionePiatto[] piatti = p.getMappaPiatti().values().toArray(new ConfigurazionePiatto[p.getMappaPiatti().size()]);

            for(int i=0;i<p.getMappaPiatti().size();i++){
                listaMaterie= piatti[i].materiePrime();
                ot.println(listaMaterie);

                for(int j=0;j<listaMaterie.size();j++){
                    LineaMagazzino o = (LineaMagazzino)lineaMagazzinoFacade.findCheckMateria(listaMaterie.get(j), zona).get(0);
                    id_materia = o.getMatPrima().getId();
                    idMagazzino = o.getMag().getId();
                    quantitaMinima = o.getSogliaMinima();
                    quantita = o.getQuantita();
                    n_rifornimenti = o.getN_rif();

                    o.setQuantita(quantita-piatti[i].getQnt());

                    lineaMagazzinoFacade.edit(o);

                    if(quantita<quantitaMinima){
                           //contattaFornitori(zona,idMagazzino,n_rifornimenti,id_materia);
                        ObjectMessage message = session.createObjectMessage();
                        message.setLongProperty("id_mag", idMagazzino);
                        message.setLongProperty("id_materia", id_materia);
                        message.setStringProperty("zona", zona);
                        message.setIntProperty("rifornimenti", n_rifornimenti);
                        messageProducer.send(message);
                    }
                }
            }
            messageProducer.close();
            connection.close();
            mc.close();
        }catch(Exception e){}
    }




    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")

}
