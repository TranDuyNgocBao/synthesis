/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food_management;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author ADMIN
 */
public class Food extends FoodManagement {

    String date;

    public Food() {
    }

    public Food(String id) {
        super(id);
    }

    public Food(String date, String id, String name, String type, String place) {
        super(id, name, type, place);
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    @Override
    public void addFood() {
        this.name = Utils.getString("Name: ").trim();
        this.type = Utils.getFirstString(this.name).trim();
        this.place = Utils.getString("Place: ").trim();
        this.date = Utils.getDate("Date: ").trim();
    }

    @Override
    public String toString() {
        Date datenow = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String nowdate = formatter.format(datenow);
        if(Utils.compareDate(nowdate, date) < 1){
            System.out.print("<In use> ");
        }else{
            System.out.print("<Out of Date> ");
        }
        return super.toString() + ", DATE=" + date;
    }

    @Override
    public int compareTo(Object o) {
        return Utils.compareDate(this.date, ((Food)o).getDate());
   } 
}
