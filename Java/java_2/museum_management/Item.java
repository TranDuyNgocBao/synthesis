/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_6;

/**
 *
 * @author ADMIN
 */
public abstract class Item {

    private int value = 0;
    private String creator = "";

    public Item() {
    }

    public Item(int value, String creator) {
        this.value = value;
        this.creator = creator;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public abstract void input();

    public abstract void output(); 
}
