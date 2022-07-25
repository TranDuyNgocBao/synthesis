/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class array {
    public static void main(String[] args) {
        int a[];
        int n;
        int i;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter: ");
        n = Integer.parseInt(sc.nextLine());
        a = new int[n];
        
        for(i =0 ; i <n; i++ ){
            System.out.print("Enter the " + (i+1) + "/" + n + " element: ");
            a[i]= Integer.parseInt(sc.nextLine());
        }
        
        System.out.print("Enter values: ");
        for(int x : a)System.out.format("%5d" , x);
        
        int S=0;
        for(int x : a)S+=x;
        System.out.println("\nSum = " + S);
    }
}
