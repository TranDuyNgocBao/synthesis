/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author ADMIN
 */
public class Fibonacci {
    static int FibonacciRecursion(int n){
        if(n==1)return 1;
        if(n==0)return 0;
        return FibonacciRecursion(n-1)+FibonacciRecursion(n-2);
    }
    
    static int FibonacciDeRecursion(int n){
        int result =0;
        if(n == 0)return 0;
        if(n == 1)return 1;
        int pre1 = 0, pre2 = 1;
        for (int i = 2; i <= n; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int n = 5;
        while(n>0)System.out.print(FibonacciRecursion(n--)+" ");
        System.out.println("");
        n=5;
        while(n>0)System.out.print(FibonacciDeRecursion(n--)+" ");
        System.out.println("");
    }
}
