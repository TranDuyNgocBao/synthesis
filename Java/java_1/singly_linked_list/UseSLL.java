/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singly_linked_list;

import java.util.LinkedList;

/**
 *
 * @author ADMIN
 */
public class UseSLL {
    public static void main(String[] args) {
        MyList sll = new MyList();
        int [] arr = {1, 2, 3, 5, 6, 7};
        sll.addMany(arr);
//        LinkedList<Integer> ll = new LinkedList<>();
//        ll.get(0);
        sll.addPos(0, 4);
       // sll.removePos(4);
        sll.traverse();
        System.out.println(" " + sll.get(7).info);
        System.out.println(" " + sll.indexOf(6));
        System.out.println(" " + sll.indexOf(8));
        sll.removeAll();
    }
}
