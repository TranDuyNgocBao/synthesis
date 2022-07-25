/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balance_binary_search_tree;

import binary_tree.*;
import queue_FIFO.*;
import java.util.LinkedList;

/**
 *
 * @author ADMIN
 * @param <T>
 */
public class Queue_lib<T> {

    LinkedList<T> ll = new LinkedList<>();

    void clear() {
        ll.clear();
    }
    
    boolean isEmpty(){
        return ll.isEmpty();
    }
    
    void enqueue(T el){
        ll.addFirst(el);
    }
    
    T dequeue(){
        T result = ll.getLast();
        ll.removeLast();
        return result;
    }
    
    T front(){
        T result = ll.getLast();
        return result;
    }
}
