/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Utils {
    public static int input_(String str){
        boolean check = true;
        int n = 0;
        do{
        try{
            System.out.print(str);
       
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        //if(n < 0)throw new Exception();
        check = false;
        }catch(NumberFormatException e){
            System.out.println("Try again");
        }
        }while(check);
        return n;
    }
}
