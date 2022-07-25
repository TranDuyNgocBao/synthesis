/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author ADMIN
 */
public class SLL extends Node {

    Node head, tail;
    private int length = 0;

    public SLL() {
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
            Node p = head;
            while (p != null) {
                System.out.print("" + p.vertex + ": ");
                for (int i = 0; i < p.arr.size(); i++) {
                    System.out.print(p.arr.get(i) + " ");
                }
                System.out.println("");
                p = p.next;
            }
        }
    }

    int size() {
        return length;
    }

    void addLast(int vertex, int data) {
        boolean check = false;
        if (isEmpty()) {
            head = tail = new Node(vertex, null);
            head.arr.add(data);
            check = true;
        } else {
            Node p = head;
            while (p != null) {
                if (vertex == p.vertex) {
                    p.arr.add(data);
                } else if(p.next == null){
                    Node tmp = new Node(vertex, null);
                    tmp.arr.add(data);
                    p.next = tmp;
                    tail = tmp;
                    p = tmp;
                    check = true;
                }
                p = p.next;
            }
        }
        if (check) {
            length++;
        }
    }
    
    int get_deg(int vertex) {
        Node p = head;
        int length = 0;
        while (p != null) {
            if (p.vertex == vertex) {
                return p.arr.size();
            }
            p = p.next;
        }
        return -1;
    }
}
