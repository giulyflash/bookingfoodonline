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

        //try {
            if (message instanceof ObjectMessage) {
                msg = (ObjectMessage) message;
            try {
                //String materia = (String) msg.getObject();
                MateriaPrima mp = new MateriaPrima();
            mp.setId(Long.MIN_VALUE);
            mp.setNome("rerewetw");
            materiaPrimaFacade.create(mp);
                //Long id = (Long)msg.getLongProperty("id_mag");
                //String nomeMateria = (String)msg.getStringProperty("zona");
                int quantita = msg.getIntProperty("rifornimenti");
                String zona = msg.getStringProperty("zona");
                Long id_mag = msg.getLongProperty("id_mag");
                Long id_materia = msg.getLongProperty("id_MateriaPrima");
                //lineaMagazzinoFacade.editLineaMagazzino(id, zona, quantita);

                Fornitore f = new Fornitore();
                f.setId(Long.MIN_VALUE);
                f.setIndirizzo("via savigliano");
                f.setLocalita(zona);
                f.setNome("pippo");
                f.setTelefono("fdfs");
                fornitoreFacade.create(f);
            } catch (JMSException ex) {
                Logger.getLogger(ConsumerOrdineBean.class.getName()).log(Level.SEVERE, null, ex);
            }

                //Long id = (Long)msg.getLongProperty("id_mag");
                //String nomeMateria = (String)msg.getStringProperty("zona");
                /*MateriaPrima mp = new MateriaPrima();
                mp.setId(Long.MIN_VALUE);
                mp.setNome("sugo");
                materiaPrimaFacade.create(mp);*/

                /*int quantita = (int) msg.getIntProperty("rifornimenti");
                String zona = (String)msg.getStringProperty("zona");
                Long id = (Long)msg.getLongProperty("id_mag");
                lineaMagazzinoFacade.editLineaMagazzino(id, zona, quantita);*/
            }
        /*} catch (JMSException e) {
            e.printStackTrace();
            mdc.setRollbackOnly();
        } catch (Throwable te) {
            te.printStackTrace();
        }*/
    }

}
