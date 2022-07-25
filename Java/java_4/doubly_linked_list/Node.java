/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doubly_linked_list;

/**
 *
 * @author ADMIN
 */
public class Node {
    int info;
    Node prev, next;

    public Node() {
    }

    public Node(int info) {
        this.info = info;
    }

    public Node(int info, Node prev, Node next) {
        this.info = info;
        this.prev = prev;
        this.next = next;
    }
    
    
}
