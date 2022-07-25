/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author ADMIN
 */
public class UsingClass {
    public static void main(String[] args) {
        System.out.println("Enter Array");
        Array obj = new Array();
        obj.array_in();
        
        if(obj.getN() == 0){
            System.out.println("No Elements in array");
            return;
        }
        
        System.out.println("Function:");
        System.out.println("1. Display Array");
        System.out.println("2. Sort Array");
        System.out.println("3. Check Array");
        int choose = Utils.input_("Choose: ");
        
        switch(choose){
            case 1: 
                System.out.print("Array: [");
                obj.array_out();
                System.out.println("]");
                break;
                
            case 2: 
                System.out.print("Array sorted in ascending order: [");
                obj.sort_a();
                obj.array_out();
                System.out.println("]");
                break;
                
            case 3:
                int[] a = {0,1,2};
                System.out.println(a.length);
                System.out.println(obj.check_a(Utils.input_("Input search value: ")));
                break;
            
            default: 
                System.out.println("No function exist");
                break;
        }
    }
}
