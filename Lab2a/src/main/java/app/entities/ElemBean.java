package app.entities;

import sun.java2d.pipe.SpanShapeRenderer;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class ElemBean implements Serializable {

    private float x;
    private float y;
    private float R;
    private boolean result;
    private long workTime;
    private String currentTime;

    public ElemBean(){}

    public ElemBean(float x, float y, float R, boolean result, long workTime, String currentTime){
        this.x = x;
        this.y = y;
        this.R = R;
        this.result = result;
        this.workTime = workTime;
        this.currentTime = currentTime;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setR(float r) {
        R = r;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public void setWorkTime(long workTime) {
        this.workTime = workTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getR() {
        return R;
    }

    public boolean getResult(){
        return result;
    }

    public long getWorkTime() {
        return workTime;
    }

    public String getCurrentTime() {
        return currentTime;
    }
}
