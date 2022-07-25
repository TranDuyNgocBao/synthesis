/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

import java.util.Stack;

/**
 *
 * @author ADMIN
 */
public class AI1504_exponential {
    static int factorialRecursion(int n){
        if(n < 1)return 0;
        if(n == 1) return 1;
        return n*factorialRecursion(n-1);
    }
    
    static int factorialLoop(int n){
        int result = 1;
        if(n<1)return 0;
        for (int i = 2; i <= n; i++) {
            result*=i;
        }
        return result;
    }
    
    static int factorialStack(int n){
        Stack<Integer> st = new Stack<>();
        do {            
            st.push(n);
        } while (--n>0);
        int result = 1;
        while(!st.isEmpty())result*=st.pop();
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println("Recursion " + factorialRecursion(5));
        System.out.println("Loop " + factorialLoop(5));
        System.out.println("Stack " + factorialStack(5));
    }
}
