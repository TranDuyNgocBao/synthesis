/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package single_linked_list_Generic;

/**
 *
 * @author ADMIN
 * @param <E>
 */
public class Single_linked_list<E extends Comparable<E>> {

    Node<E> head, tail;
    private int length = 0;

    public Single_linked_list() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void tostring() {
        if (isEmpty()) {
            System.out.println(" Empty");
        } else {
            Node<E> p = head;
            while (p != null) {
                System.out.print(" " + p.data);
                p = p.next;
            }
            System.out.println("");
        }
    }

    int size() {
        return length;
    }

    void addLast(E data) {
        if (isEmpty()) {
            head = tail = new Node(data, null);
        } else {
            Node<E> tmp = new Node(data, null);
            tail.next = tmp;
            tail = tmp;
        }
        length++;
    }

    void addFirst(E data) {
        if (isEmpty()) {
            head = tail = new Node(data, null);
        } else {
            Node<E> tmp = new Node(data, null);
            tmp.next = head;
            head = tmp;
        }
        length++;
    }

    void addMany(E[] arr) {
        for (E arr1 : arr) {
            addLast(arr1);
        }
    }

    void addPos(int index, E data) {
        if (length == 0 && index != 0) {
            System.out.println("False");
        } else if (index < 0 || index > length) {
            System.out.println("False");
        } else if (index == 0) {
            addFirst(data);
        } else if (index == length) {
            addLast(data);
        } else {
            Node<E> p = head;
            int i = 0;
            while (p != null) {
                if (i + 1 == index) {
                    Node<E> tmp = new Node(data);
                    tmp.next = p.next;
                    p.next = tmp;
                    break;
                }
                i++;
                p = p.next;
            }
        }
    }

    Node get(int index) {
        Node<E> p = head;
        int i = 0;
        while (p != null) {
            if (i == index) {
                return p;
            }
            i++;
            p = p.next;
        }
        return new Node("Cannot find index");
    }

    int indexOf(E val) {
        if (isEmpty()) {
            System.out.print(" False");
            return -1;
        } else {
            Node<E> p = head;
            int i = 0;
            while (p != null) {
                if (p.data.equals(val) && val.compareTo(p.data)==0) {
                    return i;
                }
                i++;
                p = p.next;
            }
        }
        System.out.print(" False");
        return -1;
    }

    void removeFirst() {
        if (isEmpty()) {
            System.out.println(" False");
        } else {
            head = head.next;
            length--;
        }
    }

    void removeLast() {
        if (isEmpty()) {
            System.out.println(" False");
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
        }
    }
    
    void remove(int index){
        if(isEmpty())System.out.println(" False");
        else if(index<0 || index>length-1)System.out.println(" False");
        else if(index == 0)removeFirst();
        else if(index == length-1)removeLast();
        else{
            Node<E> p = head;
            int i = 0;
            while(p!=null){
                if(i+1 == index){
                    p.next = p.next.next;
                    length--;
                    break;
                }
                i++;
                p=p.next;
            }
        }
    }
}
