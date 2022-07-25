/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number_games;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Number_Games {
    static Scanner sc = new Scanner(System.in);
    
    static final int mod = 1000000007;
    
    public static int substrings(String n){
        int len = n.length();
 
        long sumofdigits[] = new long[len];
 
        sumofdigits[0] = n.charAt(0) - '0';
        int res = 0;
        res += sumofdigits[0];
 
        for (int i = 1; i < len; i++) {
            sumofdigits[i] = ((i + 1) * (n.charAt(i) - '0') + 10 * sumofdigits[i - 1])%mod;
            res = (int) ((res + sumofdigits[i]) %mod) ;
        }
        return res%mod ;
    }
    
    public static void main(String[] args) {
        String n = sc.nextLine();
        int result = substrings(n);
        System.out.println(result);
    }
}
