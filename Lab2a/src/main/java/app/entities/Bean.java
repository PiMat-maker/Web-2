package app.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

public class Bean implements Serializable {

    private LinkedList<ElemBean> bean;

    public Bean(){
        this.bean = new LinkedList<>();
    }

    public void setBean(LinkedList<ElemBean> bean){
        this.bean = bean;
    }

    public LinkedList<ElemBean> getBean(){
        return bean;
    }

}
