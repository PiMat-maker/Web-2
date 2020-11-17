package app.entities;

import java.io.Serializable;
import java.util.concurrent.Executors;

public class Except implements Serializable {

    private String message;

    public Except(){
        this.message = "";
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
