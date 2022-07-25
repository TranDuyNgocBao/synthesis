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
public class Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);

        String ID, name;
        ID = input_id();
        System.out.print("Input name: ");
        name= scanner.nextLine();

        int a,b;
        System.out.print("Input a: ");
        a = scanner.nextInt();
        System.out.print("Input b: ");
        b = scanner.nextInt();

        System.out.println("\nWelcome: " +ID + " " + name);
        System.out.println("Result " + a + " + "+ b + " = " + (a+b));
        
    }
    
    private static String input_id(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input ID: ");
        String ID;
        ID = scanner.nextLine();
        return ID;
    }
    
}
