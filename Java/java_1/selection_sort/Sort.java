/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selection_sort;

import bubble_sort.*;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Sort {

    public static void main(String[] args) {
        final int MAX = 100;
        int[] arr = new int[MAX];

        Scanner sc = new Scanner(System.in);
        System.out.print("Size: ");
        int size = Integer.parseInt(sc.nextLine());
        System.out.print("Input: ");
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(sc.next());
        }
        
        printArray(arr, size);
        selectionSort(arr, size);
    }

    private static void printArray(int arr[], int size) {
        System.out.print("Array = [ ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    private static void selectionSort(int arr[], int size) {
        for (int i = 0; i < size-1; i++) {
            for (int j = i+1; j < size; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        
        System.out.println("Bubble Sort: ");
        printArray(arr, size);
    }
}
