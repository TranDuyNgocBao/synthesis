/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

/**
 *
 * @author ADMIN
 */
public class Operation {
    public static void main(String[] args) {
        MathOperation mo = new MathOperation();
        
        System.out.print("Sum number1 + number2 = ");
        mo.summation("-12345", "12344");
        
        System.out.print("Sub number1 - number2 = ");
        mo.subtraction("25", "25");
        
        System.out.print("Product number1 * number2 = ");
        mo.production("32233", "45436"); 
        
        System.out.print("Divide number1 / number2 = ");
        mo.division("-456", 2);
    }
}
