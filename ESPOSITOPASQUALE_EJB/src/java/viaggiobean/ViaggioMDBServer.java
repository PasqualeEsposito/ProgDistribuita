/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viaggiobean;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/javaee7/Topic",
        activationConfig = {@ActivationConfigProperty(propertyName = "acknowledge", propertyValue = "auto-Acknowledge")})
public class ViaggioMDBServer implements MessageListener {
    @Inject
    //Corretta la classe dell'evento
    Event<Viaggio> event;
    
    @Inject
    //Corretta la classe dell'oggetto
    ViaggioEJB ejb;
    
    @Override
    public void onMessage(Message message) {
        MessageWrapper msg;
        //Aggiunto try-catch
        try {
            msg = message.getBody(MessageWrapper.class);
            Viaggio v = ejb.cercaId(msg.getId());
            int sconto = v.getSconto();
            if(v.getCategoria().equals("Montagna") || v.getCategoria().equals("montagna")) {
                if(sconto <= 95)
                    sconto += 5;
                else
                    sconto = 100;
            }
            v.setSconto(sconto);
            //Aggiornamento viaggio
            ejb.aggiornaViaggio(v);
            event.fire(v);
        } catch (JMSException ex) {
            Logger.getLogger(ViaggioMDBServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
