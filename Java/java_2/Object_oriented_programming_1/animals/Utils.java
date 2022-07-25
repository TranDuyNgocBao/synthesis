/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animals;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Utils {
    
    static Scanner sc = new Scanner(System.in);
    
    public static int getNumber(String str){
        int result = 0;
        boolean check = true;
        do{
            try {
            System.out.print(str);
            result = Integer.parseInt(sc.nextLine());
            check = false;
        } catch (NumberFormatException e) {
            System.out.println("Re-enter a number");
        }
        }while(check);
        return result;
    }
    
    public static String getString(String str){
        System.out.print(str);
        String result = sc.nextLine();
        return result;
    }
    
    public static boolean getBool(String str){
        boolean check = true;
        boolean result = true;
        String tmp, regex1 = "true", regex2= "false";
        do {            
            try {
                System.out.print(str);
                tmp = sc.nextLine();
                if(tmp.isEmpty())break;
                if(tmp.matches(regex1) || tmp.matches(regex2)){
                result = Boolean.parseBoolean(tmp);
                }else{
                    throw new Exception();
                }
                check = false;
            } catch (Exception e) {
                System.out.println("Try \"true\" or \"false\" !!!");
            }
        } while (check);
        return result;
    }
    
    public static int updateNumber(int oldValue ,String str){
        int result = oldValue;
        String tmp;
        String regex = "^d{3}$";
        boolean check = true;
        do {            
            try {
                System.out.print(str);
                tmp = sc.nextLine();
                if(!tmp.isEmpty() && tmp.matches(regex)){
                    result = Integer.parseInt(tmp);
                    check = false;
                }else if(!tmp.isEmpty() && !tmp.matches(regex)){
                    throw new Exception();
                }else{
                    check = false;
                }
            } catch (Exception e) {
                System.out.print("Try an integer number less than 999");
            }
        } while (check);
        return result;
    }
    
    public static String updateString(String oldValue, String str){
        String result = oldValue;
        System.out.print(str);
        String tmp = sc.nextLine();
        if(!tmp.isEmpty()){
            result = tmp;
        }
        return result;
    }
    
    public static boolean updateBool(boolean oldValue, String str){
        boolean result = oldValue;
        String tmp, regex1 = "true", regex2= "false";
        boolean check = true;
        do {            
            System.out.print(str);
            tmp = sc.nextLine();
            if(tmp.isEmpty())break;
            if(tmp.matches(regex1) || tmp.matches(regex2)){
                result = Boolean.parseBoolean(tmp);
            }
            check = false;
        } while (check);
        return result;
    }
    
    static int [] arr = new int[300];
    static int count = 0;
    public static boolean idNOrepeated(int check){
        boolean result = true;
        if(arr.length>0){
            boolean tmp = true;
            for (int i = 0; i < count; i++) {
                if(check == arr[i]){
                    tmp = false;
                    break;
                }
                
            }
            if(tmp){
                arr[count++] = check;
                result = false;
            }
        }else{
            arr[count++] = check;
            result = false;
        }
        return result;
    }
}
