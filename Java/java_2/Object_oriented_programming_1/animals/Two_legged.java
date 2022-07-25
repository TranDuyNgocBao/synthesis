/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animals;

import candidate.I_IDlist;
import candidate.IDlist;

/**
 *
 * @author ADMIN
 */
public class Two_legged extends Animals{

    private int swings;
    
    public Two_legged() {
        do {            
            this.id = Utils.getNumber("ID: ");
        } while (Utils.idNOrepeated(this.id));
    }

    public Two_legged(int swings, int id, int leg, int weight, String color) {
        super(id, leg, weight, color);
        this.swings = swings;
        this.leg = 2;
    }

    public int getSwings() {
        return swings;
    }

    public void setSwings(int swings) {
        this.swings = swings;
    }
    
    @Override
    public String move() {
        return "can walk";
    }

    @Override
    public String eat() {
        return "fresh fruit";
    }
    
    private String sound(){
        return "can make a \"coocku\"";
    }

    @Override
    public void add() {
        this.weight = Utils.getNumber("Weight: ");
        this.color = Utils.getString("Color: ");
        this.swings = Utils.getNumber("Swings: ");
    }

    @Override
    public void update() {
        this.weight = Utils.updateNumber(this.weight, "Update weight: ");
        this.color = Utils.updateString(this.color, "Update color: ");
        this.swings = Utils.updateNumber(this.swings, "Update swings: ");
    }

    @Override
    public String toString() {
        return "Two_legged: " + super.toString() + ", swings=" + swings
                + ", sound=" + sound() + ", move=" + move() + ", eat=" + eat();
    }
    
}
