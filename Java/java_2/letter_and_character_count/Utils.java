/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letter_and_character_count;

import binary_search.*;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Utils {
    static Scanner sc = new Scanner(System.in);
            
//    public static int getNum(String str){
//        int result = 0;
//        boolean check = true;
//        do {
//            try {
//                System.out.print(str);
//                result = Integer.parseInt(sc.nextLine());
//                check = false;
//            } catch (NumberFormatException e) {
//                System.out.println("Wrong format");
//            }
//        } while (check);
//        return result;
//    }
    
    public static String getString(String str){
        System.out.print(str);
        String result = sc.nextLine();
        return result;
    }
}
