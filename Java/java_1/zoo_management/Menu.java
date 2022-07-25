package animal.v1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Menu extends ArrayList<String> implements I_Menu{
    public Menu(){
        super();
    }
    // must implement all abstract method of I_Menu interface
    
    @Override
    public void addItem(String s) {
        this.add(s);
    }

    @Override
    public int getChoice() {
        int result = Utils.getNumber("Choice: ");
        return result;
    }

    @Override
    public void showMenu() {
        System.out.println("");
        this.forEach(cd -> {
            System.out.println(cd);
        });
    }
    
}
