/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viaggiobean;

import javax.enterprise.event.Observes;

//Avevo aggiunto l'annotazione @Event
public class ViaggioEvent {
    public void notify(@Observes Viaggio v) {
        System.out.println("Aggiornamento effettuato");
    }
}
