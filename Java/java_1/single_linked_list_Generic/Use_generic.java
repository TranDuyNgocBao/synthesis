/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package single_linked_list_Generic;

/**
 *
 * @author ADMIN
 */
public class Use_generic {
    public static void main(String[] args) {
        Single_linked_list sll = new Single_linked_list();
        sll.addLast(4);
        sll.addLast(5);
        sll.addLast(6);
        sll.addFirst(3);
        sll.addFirst(2);
        sll.addFirst(1);
        sll.addFirst("Bao");
        String[] arr = {"7", "8", "9", "Her", "LoVe"};
        sll.addMany(arr);
        sll.addPos(1, "Yeu");
        sll.tostring();
        System.out.println(" " + sll.indexOf("Her"));
        System.out.println(" " + sll.indexOf(3));
        System.out.println(" " + sll.get(6).data);
        sll.removeFirst();
        sll.removeLast();
        sll.remove(6);
        sll.tostring();
        sll.clear();
        sll.tostring();
        Integer [] num = {1,2,3};
        sll.addMany(num);
        sll.tostring();
    }
}
