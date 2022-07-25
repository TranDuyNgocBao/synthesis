/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidate;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Utils {
    public static String getStr(String str){
        Scanner sc = new Scanner(System.in);
        System.out.print(str);
        String result = sc.nextLine();
        return result;
    }
    
    public static int getInt(String str) throws NumberFormatException{
        Scanner sc = new Scanner(System.in);
        System.out.print(str);
        int result = Integer.parseInt(sc.nextLine());
        return result;
    }
    
    public static String updateStr(String oldValue,String str){
        System.out.print(str);
        String result = oldValue;
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        if(!tmp.isEmpty()){
            result = tmp;
        }
        return result;
    }
    
    public static int updateInt(int oldValue,String str){
        System.out.print(str);
        int result = oldValue;
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        String regex = "^\\d+$";
        if(!tmp.isEmpty() && tmp.matches(regex)){
            result = Integer.parseInt(tmp);
        }
        return result;
    }
    
    public static void menu(){
        System.out.println("\nCANDIDATE");
        System.out.println("1. Add Experience");
        System.out.println("2. Find by ID");
        System.out.println("3. Find by Index");
        System.out.println("4. Update by ID");
        System.out.println("5. Update by Index");
        System.out.println("6. Remove by ID");
        System.out.println("7. Remove by Index");
        System.out.println("8. Display Experience");
        System.out.println("9. Display All");
        System.out.println("10. Quit");
    }
}
