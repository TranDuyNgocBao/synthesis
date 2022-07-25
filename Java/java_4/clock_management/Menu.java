package clock.management;

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
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        int result = 0;
        do{
            try{
                System.out.print("Choice: ");
                result = Integer.parseInt(sc.nextLine());
                check = false;
            }catch(NumberFormatException e){
                System.out.println("Need an integer");
            }
        }while(check);
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
