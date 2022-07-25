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
public class MergeSort {
    
    static int [] temp;
    
    @SuppressWarnings("empty-statement")
    private static void merge(int []a, int first, int last){
        int mid = (first + last)/2;
        int i = first;
        int j = mid + 1;
        int k = 0;
        
        //Merge
        while(i <= mid && j <= last){ // take Left < Right
            if(a[i] < a[j])temp[k++] = a[i++];
            else temp[k++] = a[j++];
        }
        
        //Remainder
        while(i <= mid)temp[k++] = a[i++];
        while(j <= last)temp[k++] = a[j++];
        
        //Recover
        for(k = 0, i = first; i<=last; a[i++] = temp[k++]);
    }
    
    private static void mergeSort(int []a, int first, int last){
        int mid = (first + last)/2;
        if(first < mid)mergeSort(a, first, mid);
        if(mid + 1 < last)mergeSort(a, mid+1, last);
        merge(a, first, last);
    }
    
    private static void mergeSort(int []a, int n){
        if(n<2)return;
        temp = new int[n];
        mergeSort(a, 0, n-1);
    }
    
    public static void main(String[] args) {
        int a[] = {5, 8, 2, 3, 4, 1, 9, 7};
        mergeSort(a, a.length);
        for (int i : a)System.out.print(i + " ");
        System.out.println();
    }
}
