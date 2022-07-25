/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree_Heap;

/**
 *
 * @author ADMIN
 */
public class Heap {
    
    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    private static void moveDown(int [] arr, int first, int last){
        int largest = 2*first + 1;
        while(largest <= last){
            if(largest < last && arr[largest] < arr[largest+1])largest++;
            if(arr[first] < arr[largest]){
                swap(arr, first, largest);
                first = largest;
                largest = 2*first + 1;
            }else largest = last + 1;
        }
    }
    
    public static void main(String[] args) {
        int a[] = {2,8,6,1,10,15,3,12,11};
        int n = a.length;
        
        for (int i = n/2-1; i >= 0; --i) {
            moveDown(a, i, n-1);
        }
        
        System.out.println("Heap:");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
}
