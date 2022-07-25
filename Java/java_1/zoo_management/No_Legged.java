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
public class No_Legged extends Animals{
    private boolean poisonous;
    private final String typeEating = "Devour";

    public No_Legged() {
        this.leg = "No legs";
    }

    public No_Legged(String name) {
        super(name);
    }
    

    public No_Legged(boolean poisonous, String name, String leg, String color, String move, String eat, int weight) {
        super(name, leg, color, move, eat, weight);
        this.poisonous = poisonous;
    }

    public boolean isPoisonous() {
        return poisonous;
    }

    public void setPoisonous(boolean poisonous) {
        this.poisonous = poisonous;
    }

    public String getTypeEating() {
        return typeEating;
    }

    @Override
    public void inputAnimal() {
        System.out.println("No_legged Animals:");
        this.name = Utils.getStr("Name: ");
        this.color = Utils.getStr("Color: ");
        this.move = Utils.getStr("How to move? : ");
        this.eat = Utils.getStr("Eat what? : ");
        this.weight = Utils.getNumber("Weight(kg): ");
        this.poisonous = Utils.getBool("Is it poisonous? : ");
    }

    @Override
    public void updating() {
        System.out.println("Updating No_legged");
        this.name = Utils.updateStr(this.name, "Name: ");
        this.color = Utils.updateStr(this.color, "Color: ");
        this.move = Utils.updateStr(this.move, "Move: ");
        this.eat = Utils.updateStr(this.eat, "Eat: ");
        this.weight = Utils.updateInt(this.weight, "Weight: ");
        this.poisonous = Utils.updateBool(this.poisonous, "Poisonous? : ");
    }

    @Override
    public String toString() {
        return super.toString() + "\nNo_Legged{" + "poisonous=" + poisonous + ", typeEating=" + typeEating + '}';
    }

}
