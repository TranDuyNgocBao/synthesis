/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import bracket_check.*;
import java.util.LinkedList;

/**
 *
 * @author ADMIN
 * @param <E>
 */
public class Stack_lib<E> {
    LinkedList<E> ll = new LinkedList<>();
    int length = 0;
    boolean isEmpty(){
        return ll.isEmpty();
    }
    
    int size(){
        return length;
    }
    
    void clear(){
        ll.clear();
    }
    
    void push(E data){
        ll.addLast(data);
        length++;
    }
    
    E pop(){
       E data = ll.getLast();
       ll.removeLast();
       length--;
       return data;
    }
    
    E peek(){
        return ll.getLast();
    }
    
    void showAll(){
        System.out.println(ll.toString());
    }
}
