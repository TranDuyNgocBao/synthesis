/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_6;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Utils {

    public static int getNumber() {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        boolean check = true;
        do {
            try {
                result = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Input again: ");
            }
        } while (check);
        return result;
    }

    public static String getStr() {
        Scanner sc = new Scanner(System.in);
        String result = sc.nextLine();
        return result;
    }
    
    public static boolean getBool(){
        Scanner sc = new Scanner(System.in);
        boolean result = true;
        boolean check = true;
        do {
            try {
                result = Boolean.parseBoolean(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Input again (true or false): ");
            }
        } while (check);
        return result;
    }
    
    public static String check_class(Object item){
        if(item instanceof Vase)return "Vase";
        if(item instanceof Statue)return "Statue";
        if(item instanceof Painting)return "Painting";
        return "Wrong";
    }
    
    public static void menu(){
        System.out.println("1. Add new Vase");
        System.out.println("2. Add new Statue");
        System.out.println("3. Add new Painting");
        System.out.println("4. Display All Items");
        System.out.println("5. Find Item by Creator");
        System.out.println("6. Update Item");
        System.out.println("7. Remove Item");
        System.out.println("8. Sort Item");
        System.out.println("9. Exit");
    }
}
