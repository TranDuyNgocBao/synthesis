/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bracket_check;

import java.util.LinkedList;

/**
 *
 * @author ADMIN
 * @param <E>
 */
public class Stack_lib<E> {
    LinkedList<E> ll = new LinkedList<>();
    boolean isEmpty(){
        return ll.isEmpty();
    }
    
    void clear(){
        ll.clear();
    }
    
    void push(E data){
        ll.addLast(data);
    }
    
    E pop(){
       E data = ll.getLast();
       ll.removeLast();
       return data;
    }
    
    E peek(){
        return ll.getLast();
    }
}
