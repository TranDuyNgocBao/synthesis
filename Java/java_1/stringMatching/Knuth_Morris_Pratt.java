/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringMatching;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Knuth_Morris_Pratt {
    
    private static int[] lbsArray(char[] X){
        int[] lbs = new int[X.length];
        
        int len = 0;
        int i = 1;
        lbs[0] = 0;
        
        while(i < X.length){
            
            if(X[i] == X[len]){
                len++;
                lbs[i] = len;
                i++;
            }else{
                
                if(len != 0){
                    len = lbs[len - 1];
                }else{
                    lbs[i] = len;
                    i++;
                }
                
            }
            
        }
        return lbs;
    }
    
    private static void kmp(char[]X, char[]Y){
        
        int[] lbs = lbsArray(X);
        int j = 0;
        
        int m = X.length;
        int n = Y.length;
        
        System.out.println("\nX in Y: ");
        
        int i = 0;
        
        while(i < n){
            if(X[j] == Y[i]){
                ++i;
                ++j;   
            }
            
            if(j == m){
                System.out.print((i-j) + " ");
                j = lbs[j-1];
            }else if( (i<n) && (X[j] != Y[i]) ){
                if(j != 0){
                    j = lbs[j-1];
                }else{ 
                    ++i;
                }
            }
            
        }
        
        System.out.println();
        
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("X: "); String x = sc.nextLine();
        System.out.print("\nY: "); String y = sc.nextLine();
        char[] X = x.toCharArray();
        char[] Y = y.toCharArray();
        
        kmp(X, Y);
    }
}
