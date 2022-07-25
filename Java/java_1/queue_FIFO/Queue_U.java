/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue_FIFO;

/**
 *
 * @author ADMIN
 */
public class Queue_U {
    public static void main(String[] args) {
//        Queue_lib<Integer> ql = new Queue_lib<>();
//        ql.enqueue(1);
//        ql.enqueue(2);
//        ql.enqueue(3);
//        System.out.println(ql.dequeue());
//        System.out.println(ql.front());
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.enqueue("A", 21);
        pq.enqueue("B", 19);
        pq.enqueue("C", 15);
        pq.enqueue("D", 22);
        pq.enqueue("E", 16);
        pq.tostring();
        System.out.println(pq.dequeue());
        System.out.println(pq.front());
    }
}
