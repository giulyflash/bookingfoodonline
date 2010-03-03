/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prova;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author Matteo
 */
@MessageDriven(mappedName = "jms/ConsumerOrdine", activationConfig =  {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
    })
public class ConsumerOrdineBean implements MessageListener {
    @EJB
    private GestoreFornitureLocal gestoreFornitureBean;
    @EJB
    private FornitoreFacadeLocal fornitoreFacade;
    @EJB
    private MateriaPrimaFacadeLocal materiaPrimaFacade;
    @EJB
    private LineaMagazzinoFacadeLocal lineaMagazzinoFacade;





    @Resource
    private MessageDrivenContext mdc;



    public ConsumerOrdineBean() {
    }

    public void onMessage(Message message) {
        ObjectMessage msg = null;

        try {
            if (message instanceof ObjectMessage) {
                msg = (ObjectMessage) message;       
                Long id_mag = msg.getLongProperty("id_mag");
                Long id_materia = msg.getLongProperty("id_materia");
                String zona = msg.getStringProperty("zona");
                int quantita = msg.getIntProperty("rifornimenti");        
                try{
                    gestoreFornitureBean.gestisciRifornimenti(id_mag,id_materia,zona,quantita);
                }catch(Exception e){System.out.println("Fornitura non trovata");
                }
               
            }
        } catch (Exception ex) {
                Logger.getLogger(ConsumerOrdineBean.class.getName()).log(Level.SEVERE, null, ex);
                }

    }

}
