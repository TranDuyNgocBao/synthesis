/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

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
    
    public boolean isEmpty(){
        return ll.isEmpty();
    }
    
    public void enqueue(T el){
        ll.addFirst(el);
    }
    
    public T dequeue(){
        T result = ll.getLast();
        ll.removeLast();
        return result;
    }
    
    T front(){
        T result = ll.getLast();
        return result;
    }
}
