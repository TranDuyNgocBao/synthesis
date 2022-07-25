/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubble_sort;

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
        bubbleSort(arr, size);
    }

    private static void printArray(int arr[], int size) {
        System.out.print("Array = [ ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    private static void bubbleSort(int arr[], int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        
        System.out.println("Bubble Sort: ");
        printArray(arr, size);
    }
}
