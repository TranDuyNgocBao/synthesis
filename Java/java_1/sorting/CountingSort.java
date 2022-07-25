/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.Arrays;

/**
 *
 * @author ADMIN
 */
public class CountingSort {
    static int maxNum(int arr[]){
        int result = arr[0];
        for (int i : arr) {
            if(i > result)result = i;
        }
        return result;
    }
    
    static int minNum(int arr[]){
        int result = arr[0];
        for (int i : arr) {
            if(i < result)result = i;
        }
        return result;
    }
    
    static void countingSort(int arr[]){
        int max = maxNum(arr);
        int min = minNum(arr);
        
        int[] count = new int[max+1];
        Arrays.fill(count, 0);
        
        int[] output = new int[arr.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = arr[i];
        }
        
        for (int i : arr) {
            ++count[i];
        }
        
        for (int i = min; i <= max; i++) {
            if(i>0)count[i] += count[i-1];
        }
        
        for (int i = 0; i < output.length; i++) {
            arr[count[output[i]] - 1] = output[i];
            --count[output[i]];
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {1,4,1,2,5,2,6,9,8,0,0};
        countingSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
