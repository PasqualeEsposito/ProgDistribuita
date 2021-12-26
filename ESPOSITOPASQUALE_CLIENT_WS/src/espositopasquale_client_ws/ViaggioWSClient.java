/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espositopasquale_client_ws;

import java.util.List;
import viaggiobean.Viaggio;

/**
 *
 * @author corso-pd
 */
public class ViaggioWSClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Viaggio> list = tuttiIViaggi();

        for(Viaggio v: list)
            System.out.println(v);
    }

    //Aggiunto il metodo con il drag-n-drop
    private static java.util.List<viaggiobean.Viaggio> tuttiIViaggi() {
        viaggiobean.ViaggioEJBService service = new viaggiobean.ViaggioEJBService();
        viaggiobean.ViaggioEJB port = service.getViaggioEJBPort();
        return port.tuttiIViaggi();
    }
    
}
