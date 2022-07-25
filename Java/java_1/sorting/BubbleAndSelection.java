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
public class BubbleAndSelection {
    static int a[] = {9,5,8,2,7,4,6};
    
    static void bubbleSort(int m[]){
        for (int i = 0; i < m.length-1; i++) {
            for (int j = i+1; j < m.length; j++) {
                if(m[i]>m[j]){
                    int tmp = m[i];
                    m[i] = m[j];
                    m[j] = tmp;
                }
            }
        }
    }
    
    static void selectionSort(int m[]){
        for (int i = 0; i < m.length-1; i++) {
            int min = i;
            for (int j = i+1; j < m.length; j++) {
                if(m[min] > m[j]){
                    min = j;
                }
            }
            int tmp = m[i];
            m[i] = m[min];
            m[min] = tmp;
        }
    }
    
    public static void main(String[] args) {
        //bubbleSort(a);
        selectionSort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
