/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_function;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Utils {
    public static int getType(String str){
        Scanner sc = new Scanner(System.in);
        boolean ch = true;
        int n = 0;
        
        do{
            System.out.print(str);
            try{
                n = Integer.parseInt(sc.nextLine());
                ch = false;
            }catch(NumberFormatException e){
            }
            
        }while(ch);
        return n;
    }
    public static String getStr(String str){
        String result = "";
        boolean ch = true;
        
        do{
            System.out.print(str);
            Scanner sc = new Scanner(System.in);
            String tmp = sc.nextLine();
            if(!tmp.isEmpty()){
                result = tmp;
                ch =false;
            }
        }while(ch);
        return result;
    }
    
    public static String updateStr(String oldValue, String str){
        String result = oldValue;
        
        Scanner sc = new Scanner(System.in);
        System.out.print(str);
        String tmp = sc.nextLine();
        
        if(!tmp.isEmpty()){
            result = tmp;
        }else System.out.println("Not change");
        
        return result;
    }
    
    public static int updateNum(int oldValue, String str){
        int result = oldValue;
        
        Scanner sc = new Scanner(System.in);
        
        String tmp2 = "";
        int tmp1 = 0;
        boolean ch = true;
        
        do{
            try{
            System.out.print(str);
            tmp1 = Integer.parseInt(sc.nextLine());
            tmp2 = Integer.toString(tmp1);
            ch = false;
        }catch(NumberFormatException e){   
        }
        }while(ch);
        
        if(!tmp2.isEmpty()){
            result = tmp1;
        }else System.out.println("Not change");
        
        return result;
    }
}
