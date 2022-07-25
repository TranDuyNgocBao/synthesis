/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food_management;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Menu extends ArrayList<String> implements I_Menu{

    @Override
    public void addItems(String str) {
        this.add(str);
    }

    @Override
    public int getChoice() {
        int result = 0;
        while(result<1 || result>5)result = Utils.getNumber("Choice (From 1-5): ");
        return result;
    }

    @Override
    public void showMenu() {
        System.out.println("");
        this.forEach((String x) -> {
            System.out.println(x);
        });
    }
    
}
