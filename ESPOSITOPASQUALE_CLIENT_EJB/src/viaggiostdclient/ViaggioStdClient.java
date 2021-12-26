/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viaggiostdclient;

import java.util.List;
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import viaggiobean.Viaggio;
import viaggiobean.ViaggioEJBRemote;

/**
 *
 * @author corso-pd
 */
public class ViaggioStdClient {

    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        //Aggiustata la stringa del lookup
        ViaggioEJBRemote v = (ViaggioEJBRemote) ctx.lookup("java:global/ESPOSITOPASQUALE_EJB/ViaggioEJB!viaggiobean.ViaggioEJBRemote");
        
        System.out.print("Cercare i viaggi che hanno un costo inferiore a euro: ");
        Scanner sc = new Scanner(System.in);
        float prezzo = sc.nextFloat();
        
        List<Viaggio> list = v.cercaPerPrezzo(prezzo);
        System.out.println("Tutti i viaggi con un costo inferiore di " + prezzo + "€:");
        for(Viaggio x: list)
            System.out.println(x);
    }
    
}
