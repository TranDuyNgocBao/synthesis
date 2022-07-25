/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author ADMIN
 */
public class InsertionSort {
    static int a[] = {9,5,8,2,7,4,6};
    
    static void insertionSort(int m[]){
        for (int i = 1; i < m.length; i++) {
            int key = m[i];
            int j = i-1;
            
            while(j>=0 && a[j]>key){
                m[j+1] = m[j];
                j--;
            }
            
            m[j+1] = key;
        }
    }
    
    public static void main(String[] args) {
        insertionSort(a);
        for (int i : a) {
            System.out.print(i+" ");
        }
        System.out.println("");
    }
}
