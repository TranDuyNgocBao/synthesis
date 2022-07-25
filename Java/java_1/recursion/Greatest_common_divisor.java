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
public class Greatest_common_divisor {
    static int GCDRecursion(int num1, int num2){
        if(num2 !=0)return GCDRecursion(num2, num1%num2);
        return num1;
    }
    
    static int GCDDeRecursion(int a, int b){
        while(b!=0){
            int tmp = b;
            b = a%b;
            a = tmp;
        }
        return a;
    }
    
    public static void main(String[] args) {
        System.out.println(GCDRecursion(9, 49));
        System.out.println(GCDDeRecursion(100, 86));
    }
}
