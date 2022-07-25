/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringMatching;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class BruteForce {

    //called function
    public static int bruteforce(String text, String tobematched) {
        int length = text.length();
        int plength = tobematched.length();
        int result = -1;

        for (int i = 0; i < length; i++) {
            int j = 0;
            while ((j < plength) && (text.charAt(i + j) == tobematched.charAt(j))) {
                j++;
            }
            if (j == plength) {
                result = 1;
                System.out.println("Found at position:" + (i + 1));
                System.out.println("End at the position:" + ((i+1) + tobematched.length()));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        BruteForce obj = new BruteForce();
        Scanner sc = new Scanner(System.in);
        //text
        System.out.print("Text: ");
        String text = sc.nextLine();

        System.out.print("Word matched: ");
        String tobematched = sc.nextLine();

        int position = obj.bruteforce(text, tobematched);

        if (position == -1) {
            System.out.println("Pattern is not matched in the text");
        }
    }
}
