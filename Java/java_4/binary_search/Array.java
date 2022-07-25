/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary_search;

/**
 *
 * @author ADMIN
 */
public class Array {

    public static final int MAX = 100;
    private int[] arr = new int[MAX];
    private int size;

    public Array(int size) {
        this.size = size;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void inputArray() {
        for (int i = 0; i < size; i++) {
            arr[i] = Utils.getNum("Entry " + (i + 1) + ": ");
        }
        sortArray();
    }

    public void outputArray() {
        System.out.print("Array: [ ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    private void sortArray() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public boolean binarySearch(int num) {
        int right = size;
        for (int i = 0; i < right; i++) {
            int mid = (right + i )/2;
            if (num == arr[mid]) {
                return true;
            } else if (num < arr[mid]) {
                right = mid;
                i--;
            } else {
                i = mid;
            }
        }
        return false;
    }
}
