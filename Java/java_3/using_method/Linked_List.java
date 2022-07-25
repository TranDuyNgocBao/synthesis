/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package using_method;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author ADMIN
 */
public class Linked_List {
    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < arr.length; i++) {
            ll1.add(arr[i]);
        }
        String[] str = {"Ani", "Sam", " Joe"}; 
        for (String str1 : str) {
            ll1.addFirst(str1);
        }
        LinkedList ll2 = new LinkedList();
        LinkedList ll3 = new LinkedList();
        ll3.addAll(ll1);
        ll2.addAll(ll1);
        ll3.addAll(5, ll2);
        ll3.addFirst(56);
        System.out.println("ll2 "+ll2.toString());
        System.out.println("clone "+ll1.clone());
        System.out.println("ll3 contains ll1?"+ll3.containsAll(ll1));
        System.out.println("ll3 contains 76?" + ll3.contains(76));
        ll2.clear();
        System.out.println("clear ll2 "+ll2.toString());
        System.out.println("ll3 "+ll3.toString());
        System.out.println("first element ll3"+ll3.element());
        System.out.println("ll3 == ll1? " + ll3.equals(ll1));
        System.out.println("dedescendingIterator():");
        Iterator x = ll3.descendingIterator();
        while(x.hasNext()){
            System.out.println(x.next());
        }

    }
}
