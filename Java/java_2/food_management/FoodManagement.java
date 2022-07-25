/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food_management;

/**
 *
 * @author ADMIN
 */
public abstract class FoodManagement implements Comparable{

    String id, name, type, place;

    public FoodManagement() {
    }

    public FoodManagement(String id) {
        this.id = id;
        //this.id = name;
    }

    public FoodManagement(String id, String name, String type, String place) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.place = place;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public abstract void addFood();

    @Override
    public String toString() {
        return "ID=" + id + ", NAME=" + name + ", TYPE=" + type + ", PLACE=" + place;
    }

    @Override
    public boolean equals(Object obj) {
        return this.id.equals(((FoodManagement)obj).getId()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public abstract int compareTo(Object o);
}
