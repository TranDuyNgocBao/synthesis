/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor_management_program;

import java.util.Scanner;

/**
 *
 * @author ADMIN
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
}
