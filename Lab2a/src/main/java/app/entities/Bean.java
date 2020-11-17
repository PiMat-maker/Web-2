package app.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

public class Bean implements Serializable {

    private LinkedList<HashMap<String, String>> bean;

    public Bean(){
        this.bean = new LinkedList<>();
    }

    public void setBean(LinkedList<HashMap<String, String>> bean){
        this.bean = bean;
    }

    public LinkedList<HashMap<String, String>> getBean(){
        return bean;
    }

}
