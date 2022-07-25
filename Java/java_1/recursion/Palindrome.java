/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author ADMIN
 */
public class Palindrome {
    static boolean checkPalindrome(String str, int starts, int ends){
        if(starts == ends)return true;
        if(str.charAt(starts) != str.charAt(ends))return false;
        if(starts < ends + 1)return checkPalindrome(str, starts + 1, ends -1);
        return true;
    }
    
    static boolean palindromeRecursion(String str){
        int n = str.length();
        if(n == 0)return true;
        return checkPalindrome(str, 0, n-1);
    }
    
    static boolean palindromeSLL(String str){
        if(str.length() < 2)return true;
        LinkedList<String> ll = new LinkedList();
        String tmp;
        for (int i = 0; i < str.length(); i++) {
            tmp = "";
            tmp += str.charAt(i);
            ll.addLast(tmp);
        }
        while(ll.getFirst() == null ? ll.getLast() == null : ll.getFirst().equals(ll.getLast())){
            ll.removeFirst();
            if(ll.isEmpty())return true;
            ll.removeLast();
            if(ll.isEmpty())return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(palindromeRecursion("geed"));
        System.out.println(palindromeSLL("geeg"));
        System.out.println(palindromeRecursion("g"));
        System.out.println(palindromeSLL("ge"));
        System.out.println(palindromeRecursion("gba"));
        System.out.println(palindromeSLL("gbg"));
    }
}
