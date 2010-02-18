/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Prova;

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
                int quantita = (int) msg.getIntProperty("rifornimenti");
                String zona = (String)msg.getStringProperty("zona");
                Long id = (Long)msg.getLongProperty("id_mag");

            }
        } catch (JMSException e) {
            e.printStackTrace();
            mdc.setRollbackOnly();
        } catch (Throwable te) {
            te.printStackTrace();
        }
    }
    
}
