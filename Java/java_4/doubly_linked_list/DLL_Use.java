/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doubly_linked_list;

import java.util.LinkedList;

/**
 *
 * @author ADMIN
 */
public class DLL_Use {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        MyList dll = new MyList();
        int[] arr = {1, 2, 3, 4, 5, 6, 8};
        dll.addAll(arr);
        dll.addPos(6, 7);
        dll.toArray();
    }
}
