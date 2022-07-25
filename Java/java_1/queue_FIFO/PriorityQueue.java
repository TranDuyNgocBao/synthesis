/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue_FIFO;


/**
 *
 * @author ADMIN
 * @param <E>
 */
public class PriorityQueue<E> {

    Node<E> head, tail;
    private int length = 0;

    public PriorityQueue() {
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
            while (p.data != null) {
                System.out.print(p.data + " ");
                p = p.next;
            }
            System.out.println("");
        }
    }

    public int size() {
        return length;
    }

    public void enqueue(E data, int prio) {
        if (isEmpty()) {
            tail = new Node(null, 0, null);
            head = new Node(data, prio, tail);
        } else {
            Node<E> p = head;
            Node<E> tmp = new Node(data, prio, null);
            if (head.prioriry < prio) {
                tmp.next = head;
                head = tmp;
            } else {
                while (p != null) {
                    if (p.next.prioriry > prio) {
                        p = p.next;
                    } else break;
                }
                tmp.next = p.next;
                p.next = tmp;
            }
        }
        length++;
    }

    public E dequeue() {
        Node<E> result = head;
        head = head.next;
        length--;
        return result.data;
    }

    E front() {
        Node<E> result = head;
        return result.data;
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
}
