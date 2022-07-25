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
public class Statue extends Item {

    private int weight;
    private String colour;

    public Statue() {
    }

    public Statue(int weight, String colour, int value, String creator) {
        super(value, creator);
        this.weight = weight;
        this.colour = colour;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public void input() {
        System.out.print("Value: ");
        super.setValue(Utils.getNumber());
        System.out.print("Creator: ");
        super.setCreator(Utils.getStr().toUpperCase());
        System.out.print("Weight: ");
        setWeight(Utils.getNumber());
        System.out.print("Colour: ");
        setColour(Utils.getStr().toUpperCase());
    }

    @Override
    public void output() {
        System.out.println("Value: " + super.getValue() + "\nCreator: " + super.getCreator());
        System.out.println("Weight: " + this.weight + "\nColor: " + this.colour);
    }

}
