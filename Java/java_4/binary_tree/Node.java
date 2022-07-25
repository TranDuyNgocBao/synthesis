/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary_tree;

/**
 *
 * @author ADMIN
 * @param <T>
 */
public class Node<T> {
    T info;
    Node<T> left, right;

    public Node() {
    }

    public Node(T info) {
        this.info = info;
        this.left = this.right = null;
    }

    public Node(T info, Node<T> left, Node<T> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }
    
    
    
}
