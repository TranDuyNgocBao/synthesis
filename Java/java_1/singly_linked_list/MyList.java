/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singly_linked_list;

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

    void addLast(int x) {
        if (isEmpty()) {
            head = tail = new Node(x, null);
        } else {
            Node q = new Node(x, null);
            tail.next = q;
            tail = q;
        }
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            System.out.print(" " + p.info);
            p = p.next;
        }
        System.out.println();
    }

    void addMany(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            addLast(arr[i]);
        }
    }

    void addFirst(int x) {
        if (isEmpty()) {
            head = tail = new Node(x, null);
        } else {
            Node q = new Node(x, null);
            q.next = head;
            head = q;
        }
    }

    int count() {
        Node tmp = head;
        int result = 0;
        while (tmp != null) {
            result++;
            tmp = tmp.next;
        }
        return result;
    }

    void addPos(int pos, int x) {
        int size = count();
        if (size==0 && pos!=0) {
            System.out.println("False");
        } else {
            if (pos < 0 || pos > size) {
                System.out.println("False");
            } else {
                if (pos == size) {
                    addLast(x);
                } else if (pos == 0) {
                    addFirst(x);
                } else {
                    int length = 0;
                    Node p = head;
                    while (p != null) {
                        length++;
                        if (length - 1 == pos - 1) {
                            Node tmp = new Node(x, null);
                            tmp.next = p.next;
                            p.next = tmp;
                            break;
                        }
                        p = p.next;
                    }
                }
            }
        }
    }

    void removeFirst() {
        if (isEmpty()) {
            System.out.println("False");
        } else {
            head = head.next;
        }
    }

    void removeLast() {
        if (tail == null) {
            System.out.println("False");
        } else {
            Node p = head;
            while (p != null) {
                if (p.next == tail) {
                    p.next = null;
                }
                p = p.next;
            }
        }
    }

    void removePos(int pos) {
        if (isEmpty()) {
            System.out.println("False");
        } else if (pos < 0 && pos > count() - 1) {
            System.out.println("False");
        } else if (pos == 0) {
            head = head.next;
        } else {
            Node p = head;
            int length = 0;
            while (p != null) {
                length++;
                if (length - 1 == pos) {
                    Node tmp = p.next;
                    p.next = tmp.next;
                }
                p = p.next;
            }
        }
    }

    void removeAll() {
        if (isEmpty()) {
            System.out.println("null");
        } else {
            clear();
            System.out.println("Cleared");
        }
    }

    Node get(int pos) {
        Node p = head;
        int length = 0;
        while (p != null) {
            if (length == pos) {
                return p;
            }
            length++;
            p = p.next;
        }
        return new Node(-1);
    }

    int indexOf(int val) {
        Node p = head;
        int length =0;
        while (p != null) {
            if(p.info == val)return length;
            length++;
            p = p.next;
        }
        return -1;
    }
}
