/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circular_list;

/**
 *
 * @author ADMIN
 */
public class MyList {

    Node head, tail;

    public MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    int size() {
        int result = 0;
        if (isEmpty()) {
            return 0;
        } else {
            Node p = head;
            while (true) {
                result++;
                p = p.next;
                if (p == head) {
                    break;
                }
            }
        }
        return result;
    }

    void toArray() {
        if (isEmpty()) {
            System.out.println("Null");
        } else {
            Node p = head;
            while (true) {
                System.out.print(" " + p.info);
                p = p.next;
                if (p == head) {
                    break;
                }
            }
            System.out.println("");
        }
    }

    void addLast(int x) {
        if (isEmpty()) {
            head = tail = new Node(x, head);
        } else {
            Node tmp = new Node(x, head);
            tail.next = tmp;
            tail = tmp;
        }
    }

    void addFirst(int x) {
        if (isEmpty()) {
            head = tail = new Node(x, null);
            head.next = tail.next = head;
        } else {
            Node tmp = new Node(x, null);
            tmp.next = head;
            tail.next = tmp;
            head = tmp;
        }
    }

    void addMany(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            addFirst(arr[i]);
        }
    }

    void addPos(int pos, int x) {
        if (isEmpty() && pos != 0) {
            System.out.println("null");
        } else if (pos < 0 || pos > size()) {
            System.out.println("False");
        } else if (pos == 0) {
            addFirst(x);
        } else if (pos == size()) {
            addLast(x);
        } else {
            Node p = head;
            while (p.next != null) {
                if (pos == 1) {
                    Node tmp = new Node(x, p.next);
                    p.next = tmp;
                    break;
                }
                pos--;
                p = p.next;
            }
        }
    }

    int getFirst() {
        return head.info;
    }

    int getLast() {
        return tail.info;
    }

    int get(int index) {
        if (isEmpty()) {
            System.out.print("Empty");
            return -1;
        } else if (index < 0 || index > size() - 1) {
            System.out.print("False");
            return -1;
        } else if (index == 0) {
            return getFirst();
        } else if (index == size() - 1) {
            return getLast();
        } else {
            Node p = head;
            int i = 0;
            while (p != null) {
                if (i == index) {
                    return p.info;
                }
                i++;
                p = p.next;
            }
        }
        return -1;
    }

    int indexOf(int val) {
        Node p = head;
        int result = 0;
        while (p != null) {
            if (p.info == val) {
                return result;
            }
            result++;
            p = p.next;
            if(p == head)break;
        }
        System.out.print("Cannot Find");
        return -1;
    }
    
    void removeFirst(){
        tail.next = head.next;
        head = head.next;
    }
    
    void removeLast(){
        Node p = head;
        while(true){
            if(p.next == tail){
                p.next = head;
                tail = p;
                break;
            }
            p = p.next;
        }
    }
    
    void remove(int index){
        if(isEmpty())System.out.println("Empty");
        else if(index<0 || index>size()-1)System.out.println("False");
        else if(index == 0)removeFirst();
        else if(index == size()-1)removeLast();
        else{
            Node p = head;
            int i = 0;
            while(p!=null){
                if(i == index -1){
                    p.next = p.next.next;
                    break;
                }
                i++;
                p = p.next;
            }
        }
    }
}
