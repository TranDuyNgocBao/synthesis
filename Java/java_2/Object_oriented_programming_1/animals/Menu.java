/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animals;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Menu extends ArrayList<String> implements I_Menu{

    public Menu() {
        super();
    }

    @Override
    public void addItems(String str) {
        this.add(str);
    }

    @Override
    public int getChoice() {
        int result = Utils.getNumber("Choose a number: ");
        return result;
    }

    @Override
    public void showMenu() {
        System.out.println("");
        for(String cd : this){
            System.out.println(cd);
        }
    }
    
}
