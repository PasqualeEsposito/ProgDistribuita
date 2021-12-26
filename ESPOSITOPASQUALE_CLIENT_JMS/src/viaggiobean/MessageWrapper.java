/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viaggiobean;

import java.io.Serializable;

public class MessageWrapper implements Serializable {
    private int id;
    private int sconto;

    public MessageWrapper(int id, int sconto) {
        this.id = id;
        this.sconto = sconto;
    }

    public int getId() {
        return id;
    }

    public int getSconto() {
        return sconto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSconto(int sconto) {
        this.sconto = sconto;
    }
}

