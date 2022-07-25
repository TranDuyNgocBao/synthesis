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
public abstract class Animals {
    protected String name;
    protected String leg, color, move, eat;
    protected int weight;

    public Animals() {
    }

    public Animals(String name) {
        this.name = name;
    }

    public Animals(String name, String leg, String color, String move, String eat, int weight) {
        this.name = name;
        this.leg = leg;
        this.color = color;
        this.move = move;
        this.eat = eat;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEat() {
        return eat;
    }

    public void setEat(String eat) {
        this.eat = eat;
    }

    public String getLeg() {
        return leg;
    }

    public void setLeg(String leg) {
        this.leg = leg;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    public abstract void inputAnimal();
    
    public abstract void updating();

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((Animals)obj).getName());
    }

    @Override
    public String toString() {
        return "Animals{" + "name=" + name + ", leg=" + leg + ", color=" + color + ", move=" + move + ", eat=" + eat + ", weight=" + weight + '}';
    }
    
}
