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
public class Zero_legged extends Animals{
    
    private boolean poisonous;
    
    public Zero_legged() {
        do {            
            this.id = Utils.getNumber("ID: ");
        } while (Utils.idNOrepeated(this.id));
    }
    
    public Zero_legged(int id){
        super(id);
    }

    public Zero_legged(boolean poisonous, int id, int leg, int weight, String color) {
        super(id, leg, weight, color);
        this.poisonous = poisonous;
        this.leg = 0;
    }

    Zero_legged(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isPoisonous() {
        return poisonous;
    }

    public void setPoisonous(boolean poisonous) {
        this.poisonous = poisonous;
    }

    @Override
    public String eat() {
        return "hunt small animals and devour them";
    }

    @Override
    public void add() {
        this.weight = Utils.getNumber("Weight: ");
        this.color = Utils.getString("Color: ");
        this.poisonous = Utils.getBool("Poisonous: ");
    }

    @Override
    public void update() {
        this.weight = Utils.updateNumber(this.weight, "Update weight: ");
        this.color = Utils.updateString(this.color, "Update color: ");
        this.poisonous = Utils.updateBool(this.poisonous, "Update poisonous: ");
    }

    @Override
    public String move() {
        return "can creep";
    }

    @Override
    public String toString() {
        return "Zero_legged: " + super.toString() + ", poisonous=" + poisonous
                + ", move=" + move() + ", eat=" + eat();
    }
    
}
