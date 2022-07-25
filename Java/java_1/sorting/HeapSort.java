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
public class HeapSort {
    
    public static void swap(int a[], int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    public static void moveDown(int []a, int first, int last){
        //first is father node
        //leftChild = 2*father + 1, rightChild = 2*father + 2
        int largest = 2*first + 1; // suppose largest is the leftChild
        while(largest <= last){
            //Checking the right child greater than left child?
            if(largest < last && a[largest] < a[largest + 1])largest++; // move to right child
            if(a[first] < a[largest]){ // father < child
                swap(a, first, largest); // swap father and largest child
                first = largest; // move down to subtree
                largest = 2*first + 1; // set leftChild to subtree
            }
            //to exit loop: the heap property isn't violated by a[first]
            else largest = last + 1;
        }
    }
    
    public static void heapSort(int[] a, int n){
        //transfer the initial array to max heap
        for (int i = n/2 -1; i >= 0 ; --i) {
            moveDown(a, i, n-1);
        }
        for (int i = n-1; i >= 1; --i) {
            swap(a, 0, i); // Move the largest value to the end of group
            moveDown(a, 0, i-1); //transfer the remainder to max heap
        }
    }
    
    public static void main(String[] args) {
        //int a[] = {5, 8, 2, 3, 4, 1, 9, 7};
        int a[] = {2,8,6,1,10,15,3,12,11};
        heapSort(a, a.length);
        for (int i : a)System.out.print(i + " ");
        System.out.println();
    }
}
