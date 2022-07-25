/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal.v1;

/**
 *
 * @author ADMIN
 */
public class Two_Legged extends Animals{
    private int swings;
    private final String sound = "coocku";

    public Two_Legged() {
        this.leg = "Two legs";
    }

    public Two_Legged(int swings, String name, String leg, String color, String move, String eat, int weight) {
        super(name, leg, color, move, eat, weight);
        this.swings = swings;
    }

    public int getSwings() {
        return swings;
    }

    public void setSwings(int swings) {
        this.swings = swings;
    }

    public String getSound() {
        return sound;
    }

    @Override
    public void inputAnimal() {
        System.out.println("Two_legged Animals:");
        this.name = Utils.getStr("Name: ");
        this.color = Utils.getStr("Color: ");
        this.move = Utils.getStr("How to move? : ");
        this.eat = Utils.getStr("How to eat? : ");
        this.weight = Utils.getNumber("Weight(kg): ");
        this.swings = Utils.getNumber("How many swings? : ");
    }

    @Override
    public void updating() {
        System.out.println("Updating Two_legged");
        this.name = Utils.updateStr(this.name, "Name: ");
        this.color = Utils.updateStr(this.color, "Color: ");
        this.move = Utils.updateStr(this.move, "Move: ");
        this.eat = Utils.updateStr(this.eat, "Eat: ");
        this.weight = Utils.updateInt(this.weight, "Weight: ");
        this.swings = Utils.updateInt(this.swings, "Swings? : ");
    }

    @Override
    public String toString() {
        return super.toString() + "\nTwo_Legged{" + "swings=" + swings + ", sound=" + sound + '}';
    }
    
}
