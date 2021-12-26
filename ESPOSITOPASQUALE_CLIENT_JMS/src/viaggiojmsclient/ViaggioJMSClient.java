/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viaggiojmsclient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import viaggiobean.MessageWrapper;


public class ViaggioJMSClient {

    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        ConnectionFactory connFactory = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");
        
        MessageWrapper msg = new MessageWrapper(1, 50);
        try(JMSContext jmsContext = connFactory.createContext()){
            //Corretto il nome dell'oggetto JMSContext (all'esame scritto ho dichiarato la variabile con il nome "jmsContext" ma poi l'ho utilizzata col nome "jms")
            jmsContext.createProducer().send(topic, msg);
        }
    }
    
}
