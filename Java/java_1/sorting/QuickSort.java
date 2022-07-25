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
public class QuickSort {

    public static void swap(int a[], int first, int mid) {
        int tmp = a[first];
        a[first] = a[mid];
        a[mid] = tmp;
    }

    public static void quickSort1(int a[], int first, int last) {
        int mid = (first + last) / 2;
        swap(a, first, mid);
        int lower = first + 1, upper = last;
        int pivote = a[first];
        while (lower <= upper) {
            while (lower <= upper && pivote > a[lower]) {
                lower++;
            }
            while (lower <= upper && pivote < a[upper]) {
                upper--;
            }
            if (lower < upper) {
                swap(a, lower++, upper--);
            } else {
                lower++;
            }
        }
        swap(a, upper, first);

        if (first < upper - 1) {
            quickSort1(a, first, upper - 1);
        }
        if (upper + 1 < last) {
            quickSort1(a, upper + 1, last);
        }
    }

    static int pivotEnd(int[] a, int front, int end) {
        int temp = a[end];
        for (int j = front; j < end; j++) {
            if (a[j] < temp) {
                swap(a, front++, j);
            }
        }
        swap(a, front, end);
        return front;
    }

    static int pivotFront(int[] a, int front, int end) {
        swap(a, front, end);
        return pivotEnd(a, front, end);
    }

    static int pivotMid(int[] a, int front, int end) {
        int mid = (front + end) / 2;
        swap(a, mid, end);
        return pivotEnd(a, front, end);
    }

    static int pivotRand(int[] a, int front, int end) {
        int pi = (int) (Math.random() * (end - front + 1)) + front;
        swap(a, pi, end);
        return pivotEnd(a, front, end);
    }

    static void quick(int[] a, int front, int end) {
        if (front < end) {
            int p = pivotRand(a, front, end);
            quick(a, front, p - 1);
            quick(a, p + 1, end);
        }
    }

    public static void main(String[] args) {
        int a[] = {5, 8, 2, 3, 4, 1, 9, 7};
        //quickSort1(a, 0, a.length-1);
        quick(a, 0, a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
