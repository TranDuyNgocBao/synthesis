/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curriculum_abstract;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Using_curriculum {
    public static void main(String[] args) {
        System.out.println("CURRICULUM:");
        System.out.println("1. FPT");
        System.out.println("2. Ton Duc Thang");
        System.out.println("3. Bach Khoa HCM");
        
        System.out.print("Choose: ");
        int n = 0;
        try{
            Scanner sc = new Scanner(System.in);
            n = Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e){
            System.out.println("Wrong syntax");
        }
        
        switch(n){
            case 1: 
                System.out.println("\nFPT: ");
                Curriculum fpt = new FPT();
                fpt.output();
                break;
            
            case 2: 
                System.out.println("\nTon Duc Thang: ");
                Curriculum tdt = new Tonducthang();
                tdt.output();
                break;
                
            case 3: 
                System.out.println("\nBach Khoa HCM: ");
                Curriculum bk = new Bachkhoa_hcm();
                bk.output();
                break;
                
            default:
                System.out.println("wrong syntax");
                break;
        }
    }
}

