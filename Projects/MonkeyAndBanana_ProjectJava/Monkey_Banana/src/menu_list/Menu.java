/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu_list;

import interfere.Utils;
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
        int result = -1;
        result = Utils.getNumber("Choice: ");
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
