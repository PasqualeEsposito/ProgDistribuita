/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viaggiobean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
@DataSourceDefinition(
   className = "org.apache.derby.jdbc.EmbeddedDataSource",
   name = "java:global/jdbc/EsameDS",
   user = "app", password = "app",
   databaseName = "EsameDB",
   properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {
    @Inject
    private ViaggioEJB ejb;
    private Viaggio v1, v2, v3;
    
    @PostConstruct
    public void populateDB() {
        v1 = new Viaggio(1, "Mare", "Seychelles", 45, 500, 10, 10);
        v2 = new Viaggio(2, "Mare", "Corfù", 32, 200, 0, 20);
        v3 = new Viaggio(3, "Montagna", "Cortuna", 34, 700, 20, 30);
        
        ejb.aggiungiViaggio(v1);
        ejb.aggiungiViaggio(v2);
        ejb.aggiungiViaggio(v3);
    }
    
    @PreDestroy
    public void clearDB() {
        ejb.rimuoviViaggio(v1);
        ejb.rimuoviViaggio(v2);
        ejb.rimuoviViaggio(v3);
    }
}
