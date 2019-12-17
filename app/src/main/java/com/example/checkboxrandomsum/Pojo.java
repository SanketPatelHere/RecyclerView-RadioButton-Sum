package com.example.checkboxrandomsum;

public class Pojo {
    int i;
    boolean selected = false;
    public Pojo()
    {

    }
    public Pojo(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "i=" + i +
                ", selected=" + selected +
                '}';
    }

    /*public String toPosition() {
        return "Pojo{" +
                "i=" + i +
                '}';
    }*/


}
