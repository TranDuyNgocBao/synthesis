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
public class Vase extends Item {

    private int height;
    private String material;

    public Vase() {
    }

    public Vase(int height, String material, int value, String creator) {
        super(value, creator);
        this.height = height;
        this.material = material;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public void input() {
        System.out.print("Value: ");
        super.setValue(Utils.getNumber());
        System.out.print("Creator: ");
        super.setCreator(Utils.getStr().toUpperCase());
        System.out.print("Height: ");
        setHeight(Utils.getNumber());
        System.out.print("Material: ");
        setMaterial(Utils.getStr().toUpperCase());
    }

    @Override
    public void output() {
        System.out.println("Value: " + super.getValue() + "\nCreator: " + super.getCreator());
        System.out.println("Height: " + this.height + "\nMaterial: " + this.material);
    }

}
