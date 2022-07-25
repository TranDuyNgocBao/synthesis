/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animals;

/**
 *
 * @author ADMIN
 */
public abstract class Animals{
    int id, leg, weight;
    String color;

    public Animals() {
    }

    public Animals(int id) {
        this.id = id;
    }
    
    

    public Animals(int id, int leg, int weight, String color) {
        this.id = id;
        this.leg = leg;
        this.weight = weight;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLeg() {
        return leg;
    }

    public void setLeg(int leg) {
        this.leg = leg;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract String move();

    public abstract String eat();

    public abstract void add();

    public abstract void update();

    @Override
    public String toString() {
        return "id=" + id + ", leg=" + leg + ", weight=" + weight + ", color=" + color + '}';
    }

    @Override
    public boolean equals(Object obj) {
        return (this.id == ((Animals) obj).getId());
    }
    
}
