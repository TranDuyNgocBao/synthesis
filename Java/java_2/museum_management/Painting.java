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
public class Painting extends Item {

    private int height;
    private int width;
    private boolean isWatercolour;
    private boolean isFramed;

    public Painting() {
    }

    public Painting(int height, int width, boolean isWatercolour, boolean isFramed, int value, String creator) {
        super(value, creator);
        this.height = height;
        this.width = width;
        this.isWatercolour = isWatercolour;
        this.isFramed = isFramed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isIsWatercolour() {
        return isWatercolour;
    }

    public void setIsWatercolour(boolean isWatercolour) {
        this.isWatercolour = isWatercolour;
    }

    public boolean isIsFramed() {
        return isFramed;
    }

    public void setIsFramed(boolean isFramed) {
        this.isFramed = isFramed;
    }

    @Override
    public void input() {
        System.out.print("Value: ");
        super.setValue(Utils.getNumber());
        System.out.print("Creator: ");
        super.setCreator(Utils.getStr().toUpperCase());
        System.out.print("Height: ");
        setHeight(Utils.getNumber());
        System.out.print("Width: ");
        setWidth(Utils.getNumber());
        System.out.print("Is painting Watercolour? ");
        setIsWatercolour(Utils.getBool());
        System.out.print("Is painting Framed? ");
        setIsFramed(Utils.getBool());
    }

    @Override
    public void output() {
        System.out.println("Value: " + super.getValue() + "\nCreator: " + super.getCreator());
        System.out.println("Height: " + this.height + "\nWidth: " + this.width
                + "\nWatercolour? " + this.isWatercolour
                + "\nFramed? " + this.isFramed);
    }

}
