/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curriculum_interfaces;

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
                FPT fpt = new Fundamental_training();
                fpt.output_fpt();
                fpt = new Advanced_training();
                fpt.output_fpt();
                fpt= new Specialized_training();
                fpt.output_fpt();
                break;
            
            case 2: 
                System.out.println("\nTon Duc Thang: ");
                Tonducthang tdt = new Fundamental_training();
                tdt.output_tonducthang();
                tdt = new Advanced_training();
                tdt.output_tonducthang();
                tdt= new Specialized_training();
                tdt.output_tonducthang();
                break;
                
            case 3: 
                System.out.println("\nBach Khoa HCM: ");
                Bachkhoa_hcm bk = new Fundamental_training();
                bk.output_bkhcm();
                bk = new Advanced_training();
                bk.output_bkhcm();
                bk= new Specialized_training();
                bk.output_bkhcm();
                break;
                
            default:
                System.out.println("wrong syntax");
                break;
        }
    }
}
