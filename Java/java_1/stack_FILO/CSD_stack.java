/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack_FILO;

import single_linked_list_Generic.*;

/**
 *
 * @author ADMIN
 * @param <E>
 */
public class CSD_stack<E extends Comparable<E>>{

    Node<E> head, tail;
    private int length = 0;

    public CSD_stack() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void push(E data) {
        if (isEmpty()) {
            head = tail = new Node(data, null);
        } else {
            Node<E> tmp = new Node(data, null);
            tail.next = tmp;
            tail = tmp;
        }
        length++;
    }

    E pop() throws Exception {
        Node<E> result = tail;
        if (isEmpty()) {
            throw new Exception("False");
        } else {
            Node<E> p = head;
            while (p != null) {
                if (p.next == tail) {
                    p.next = null;
                    length--;
                    break;
                }
                p = p.next;
            }
            tail = p;
        }
        return result.data;
    }

    E peek() throws Exception {
        if(isEmpty()){
            throw new Exception("False");
        }
        return tail.data;
    }

}
