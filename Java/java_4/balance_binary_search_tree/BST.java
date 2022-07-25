/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balance_binary_search_tree;

import binary_tree.*;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author ADMIN
 * @param <T>
 */
public class BST<T extends Comparable> {

    Node<T> root = null;
    ArrayList<Node> arl = new ArrayList<>();

    public BST() {
    }

    boolean isEmpty() {
        return (root == null);
    }

    void add(T data) {
        if (isEmpty()) {
            root = new Node(data);
        } else {
            Node<T> p = root;
            Node<T> prev;
            while (p != null) {
                prev = p;
                if (data.compareTo(p.info) > 0) {
                    p = p.right;
                    if (p == null) {
                        prev.right = new Node(data);
                    }
                } else {
                    p = p.left;
                    if (p == null) {
                        prev.left = new Node(data);
                    }
                }
            }
        }
    }

    //Breadth-First Traversal (Queue)
    void breadth() {
        if (isEmpty()) {
            return;
        }
        Node<T> p = root;
        Queue_lib q = new Queue_lib();
        q.enqueue(p);
        arl.add(p);
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            if (p.left != null) {
                q.enqueue(p.left);
                arl.add(p.left);
            }
            if (p.right != null) {
                q.enqueue(p.right);
                arl.add(p.right);
            }
            System.out.print(p.info + " ");
        }
        System.out.println("");
    }
    
    void insert(T data) {
        if (root == null) {
            root = new Node(data);
            return;
        }

        Node f, p;
        p = root;
        f = null;
        while (p != null) {
            if (data.compareTo(p.info) == 0) {
                System.out.println("This info has been existed");
                return;
            }
            f = p;
            if (data.compareTo(p.info) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (data.compareTo(f.info) < 0) {
            f.left = new Node(data);
        } else {
            f.right = new Node(data);
        }
    }
    
    T[] sort_arr(T[] data){
        for(int i = 0; i< data.length - 1; i++){
            for (int j = i + 1; j < data.length; j++) {
                if(data[i].compareTo(data[j]) > 0){
                    T tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                }
            }
        }
        return data; 
    }

    void balance(T[] data, int first, int last){
        if(first <= last){
            int middle = (first + last)/2;
            insert(data[middle]);
            balance(data, first, middle - 1);
            balance(data, middle + 1, last);
        }
    }
}
