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
public class Morris_Pratt {
    
    private static int[] preMP(char[] X){
        int[] mpNext = new int[X.length+1];
        
        int i = 0;
        int j = mpNext[0] = -1;
        while(i < X.length){
            while( (j > -1) && (X[i] != X[j]) ){
                j = mpNext[j];
            }
            mpNext[++i] = ++j;
        }
        return mpNext;
    }
    
    private static void mp(char[]X, char[]Y){
        int[] mpNext = preMP(X);
        
        int i = 0;
        int m = 0;
        
        System.out.println("\nX in Y: ");
        
        while(m <= Y.length - X.length){
            if(X[i] == Y[m+i]){
                i++;
                
                if(i == X.length){
                    System.out.print(m + " ");
                    m = m + i - mpNext[i];
                    i = 0;
                }
            }else{
                m = m + i - mpNext[i];
                if(i > 0 ){
                    i = mpNext[i];
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
        
        mp(X, Y);
    }
}
