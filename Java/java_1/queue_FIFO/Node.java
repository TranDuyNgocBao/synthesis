/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue_FIFO;

import stack_FILO.*;
import single_linked_list_Generic.*;
import java.io.*;

/**
 *
 * @author ADMIN
 * @param <E>
 * @param <T>
 */
public class Node<E> {
    E data;
    int prioriry;
    Node<E> next;

    public Node() {
    }

    public Node(E data, int prioriry, Node<E> next) {
        this.data = data;
        this.prioriry = prioriry;
        this.next = next;
    }

    public Node(E data) {
        this.data = data;
        this.prioriry = 0;
        this.next = null;
    }
    
}
