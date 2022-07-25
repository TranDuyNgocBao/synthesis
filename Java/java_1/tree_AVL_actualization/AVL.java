/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree_AVL_actualization;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 * @param <T>
 */
public class AVL<T extends Comparable> {

    Node<T> root = null;

    public AVL() {
    }

    boolean isEmpty() {
        return (root == null);
    }

    //Breadth-First Traversal (Queue)
    void breadth() {
        if (isEmpty()) {
            return;
        }
        Node<T> p = root;
        Queue_lib q = new Queue_lib();
        q.enqueue(p);
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            if (p.left != null) {
                q.enqueue(p.left);
            }
            if (p.right != null) {
                q.enqueue(p.right);
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

    //height
    int height(Node<T> p) {
        if (p == null) {
            return 0;
        }
        int a = height(p.left);
        int b = height(p.right);
        if (a > b) {
            return a + 1;
        }
        return b + 1;
    }

    //Balance to AVL
    Node rotationLeft(Node curr) {
        Node tmp = curr.right;
        curr.right = tmp.left;
        tmp.left = curr;
        curr = tmp;
        return curr;
    }

    Node rotationRight(Node curr) {
        Node tmp = curr.left;
        curr.left = tmp.right;
        tmp.right = curr;
        curr = tmp;
        return curr;
    }

    Node check_eqls(Node key){
        Node<T> p = root;
        Queue_lib q = new Queue_lib();
        q.enqueue(p);
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            if (p.left != null) {
                if(p.left == key)return p;
                q.enqueue(p.left);
            }
            if (p.right != null) {
                if(p.right == key)return p;
                q.enqueue(p.right);
            }
        }
        return null;
    }
    
    void balance_to_AVL() {
        if (isEmpty()) {
            return;
        }
        Node<T> p = root;
        Queue_lib q = new Queue_lib();
        q.enqueue(p);
        while (!q.isEmpty()) {
            Node parent;
            p = (Node) q.dequeue();
            parent = check_eqls(p);
            int factor = Math.abs(height(p.right) - height(p.left));
            if (factor > 1) {
                // Right
                if (height(p.left) < height(p.right)) {
                    Node child = p.right;
                    if (height(child.left) < height(child.right)) {
                        if (p != root) {
                            if (parent.left == p) {
                                parent.left = rotationLeft(p);
                                p = parent.left;
                            } else {
                                parent.right = rotationLeft(p);
                                p = parent.right;
                            }
                        } else {
                            root = rotationLeft(p);
                            p = root;
                        }
                    } else if (height(child.left) > height(child.right)) {
                        p.right = rotationRight(child);
                        if (p != root) {
                            if (parent.left == p) {
                                parent.left = rotationLeft(p);
                                p = parent.left;
                            } else {
                                parent.right = rotationLeft(p);
                                p = parent.right;
                            }
                        } else {
                            root = rotationLeft(p);
                            p = root;
                        }
                    }
                    // Left
                } else {
                    Node child = p.left;
                    if (height(child.left) > height(child.right)) {
                        if (p != root) {
                            if (parent.left == p) {
                                parent.left = rotationRight(p);
                                p = parent.left;
                            } else {
                                parent.right = rotationRight(p);
                                p = parent.right;
                            }
                        } else {
                            root = rotationRight(p);
                            p = root;
                        }
                    } else if (height(child.left) < height(child.right)) {
                        p.left = rotationLeft(child);
                        if (p != root) {
                            if (parent.left == p) {
                                parent.left = rotationRight(p);
                                p = parent.left;
                            } else {
                                parent.right = rotationRight(p);
                                p = parent.right;
                            }
                        } else {
                            root = rotationRight(p);
                            p = root;
                        }
                    }
                }
            }
            if (p.left != null) {
                q.enqueue(p.left);
            }
            if (p.right != null) {
                q.enqueue(p.right);
            }
        }
    }
}
