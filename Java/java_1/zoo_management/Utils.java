/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
    Document   : admin
    Created on : July 11, 2021, 3:39:25 PM
    Author     : hd
 */
package animal.v1;

import java.util.Scanner;

/**
 *
 * @author hd
 */
public class Utils {
    public static int getNumber(String str) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        boolean check = true;
        do {
            try {
                System.out.print(str);
                result = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Wrong Format");
            }
        } while (check);
        return result;
    }

    public static String getStr(String str) {
        Scanner sc = new Scanner(System.in);
        System.out.print(str);
        String result = sc.nextLine();
        return result;
    }
    
    public static boolean getBool(String str){
        Scanner sc = new Scanner(System.in);
        boolean result = true;
        boolean check = true;
        do {
            try {
                System.out.print(str);
                result = Boolean.parseBoolean(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Input again (true or false)");
            }
        } while (check);
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
    
    public static boolean updateBool(boolean oldValue,String str){
        System.out.print(str);
        boolean result = oldValue;
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        if(!tmp.isEmpty()){
            result = Boolean.parseBoolean(tmp);
        }
        return result;
    }
}
