/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_List;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class LinkedList_Clockwise {

    static Scanner sc = new Scanner(System.in);

    static boolean checkList(LinkedList<Integer> ll) {
        for (int i = 0; i < ll.size() - 1; i++) {
            if (ll.get(i) > ll.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    static void clockWise(LinkedList<Integer> ll, int j) {
        int tmp = ll.get(0);
        for (int i = 0; i < j-1; i++) {
            ll.set(i, ll.get(i + 1));
        }
        ll.set(j - 1, tmp);
    }
    
    static int getMax(LinkedList<Integer> ll, int j){
        int res = ll.get(0);
        for (int i = 0; i < j; i++) {
            if(res < ll.get(i))res=ll.get(i);
        }
        return res;
    }

    static int countWise(LinkedList<Integer> ll) {
        int result = 0;
        boolean status = false;
        int j = ll.size();
        int max = getMax(ll, j);
        while (!status) {
            status = checkList(ll);
            if (!status) {
                while(ll.get(j-1)!=max){
                    clockWise(ll, j);
                    result++;
                }
                j--;
                max = getMax(ll, j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(5);
        ll.add(6);
        ll.add(3);
        ll.add(4);
        ll.add(8);
        ll.add(9);

        System.out.println(countWise(ll));
    }
}
