/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor_management_program;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Menu extends ArrayList<String> implements I_Menu{

    @Override
    public void addItem(String str) {
        this.add(str);
    }

    @Override
    public void showMenu() {
        System.out.println("");
        for (String cd : this) {
            System.out.println(cd);
        }
    }

    @Override
    public int getChoice() {
        int result = Utils.getNumber("Choice: ");
        return result;
    }


    
}
