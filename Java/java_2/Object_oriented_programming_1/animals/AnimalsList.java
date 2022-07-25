/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animals;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ADMIN
 */
public class AnimalsList extends ArrayList implements I_List {

    @Override
    public void add(int leg) {
        if (leg == 0) {
            Zero_legged cd = new Zero_legged();
            cd.add();
            this.add(cd);
        } else {
            Two_legged cd = new Two_legged();
            cd.add();
            this.add(cd);
        }
    }

    @Override
    public void update() {
        int index;
        String id = Utils.getString("Update ID: ");
        index = this.indexOf(new Zero_legged(id));
        Animals cd;
        if (index > -1) {
            cd = (Animals) this.get(index);
            cd.update();
            this.set(index, cd);
            System.out.println("Updated!");
        } else {
            System.out.println("Not found");
        }
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void search() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showByType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
