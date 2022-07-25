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
public class MyList {
    Node head, tail;

    public MyList() {
        head = tail = null;
    }
    
    boolean isEmpty(){
        return (head == null);
    }
    
    void clear(){
        head = tail = null;
    }
    
    void addLast(int x){
        if(isEmpty()){
            head = tail = new Node(x, null, null);
        }else{
            Node tmp = new Node(x, tail, null);
            tail.next = tmp;
            tail = tmp;
        }
    }
    
    void toArray(){
        Node p = head;
        while(p != null){
            System.out.print(" " + p.info);
            p = p.next;
        }
        System.out.println("");
                
    }
    
    void addFirst(int x){
        if(isEmpty()){
            head = tail = new Node(x, null, null);
        }else{
            Node tmp = new Node(x, null, head);
            head.prev = tmp;
            head = tmp;
        }
    }
    
    void addAll(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            addLast(arr[i]);
        }
    }
    
    int get(int index){
        int result = -9999;
        int length = 0;
        Node p = head;
        while(p != null){
            if(length == index){
                return p.info;
            }
            length++;
            p = p.next;
        }
        return result;
    }
    
    int getFirst(){
        return head.info;
    }
    
    int getLast(){
        return tail.info;
    }
    
    int size(){
        int result = 0;
        Node p = head;
        while(p != null){
            result++;
            p = p.next;
        }
        return result;
    }
    
    void addPos(int index, int x){
        int size = size();
        if(size==0 && index!=0)System.out.println("False");
        else if(index<0 || index > size)System.out.println("False");
        else if(index == 0) addFirst(x);
        else if(index == size)addLast(x);
        else{
            int check = 0;
            Node p = head;
            while(p!=null){
                if(check == index -1){
                    Node tmp = new Node(x, p, p.next);
                    p.next.prev = tmp;
                    p.next = tmp;
                    break;
                }
                check++;
                p = p.next;
            }
        }
    }
    
    void removeFirst(){
        head = head.next;
        head.prev = null;
    }
     
    void removeLast(){
        tail = tail.prev;
        tail.next = null;
    }
    
    void remove(int index){
        if(isEmpty())System.out.println("False");
        else if(index<0 || index>size()-1)System.out.println("False");
        else if(index == 0)removeFirst();
        else if(index == size()-1)removeLast();
        else{
            Node p = head;
            while(p!=null){
                if(index == 0){
                    p.prev.next = p.next;
                    p.next.prev = p.prev;
                    break;
                }
                index--;
                p = p.next;
            }
        }
    }
    
    int indexOf(int val){
        int result = -1;
        if(isEmpty())System.out.print("False");
        else{
            Node p = head;
            while(p!=null){
                result++;
                if(p.info == val)return result;
                p = p.next;
            }
            result = -1;
        }
        System.out.print("False");
        return result;
    }
}
