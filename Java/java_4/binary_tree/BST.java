/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary_tree;

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

    // Depth-First Traversals
    void pre_order_NLR(Node<T> p) {
        if (isEmpty()) {
            return;
        }
        if (p == null) {
            return;
        }
        System.out.print(p.info + " ");
        pre_order_NLR(p.left);
        pre_order_NLR(p.right);
    }

    void in_order_LNR(Node<T> p) {
        if (isEmpty()) {
            return;
        }
        if (p == null) {
            return;
        }
        in_order_LNR(p.left);
        System.out.print(p.info + " ");
        in_order_LNR(p.right);
    }

    void post_order_LRN(Node<T> p) {
        if (isEmpty()) {
            return;
        }
        if (p == null) {
            return;
        }
        post_order_LRN(p.left);
        post_order_LRN(p.right);
        System.out.print(p.info + " ");
    }

    // NLR (Derecursion)
    void po_NLR_derecursion() {
        if (isEmpty()) {
            return;
        }
        Stack st = new Stack();
        Node<T> p = root;
        st.push(p);
        while (!st.isEmpty()) {
            p = (Node) st.pop();
            System.out.print(p.info + " ");
            if (p.right != null) {
                st.push(p.right);
            }
            if (p.left != null) {
                st.push(p.left);
            }
        }
        System.out.println("");
    }

    // Leaf node
    void leaf_count() {
        if (isEmpty()) {
            return;
        }
        int count = 0;
        Node<T> p = root;
        Queue_lib q = new Queue_lib();
        Queue_lib countlist = new Queue_lib();
        q.enqueue(p);
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            if (p.left != null) {
                q.enqueue(p.left);
            }
            if (p.right != null) {
                q.enqueue(p.right);
            }
            if (p.left == null && p.right == null) {
                count++;
                countlist.enqueue(p.info);
            }
        }
        System.out.print(count + ": ");
        while (!countlist.isEmpty()) {
            System.out.print(countlist.dequeue() + " ");
        }
        System.out.println("");
    }

    // 1 child-node
    void one_child_node() {
        if (isEmpty()) {
            return;
        }
        Stack st = new Stack();
        Queue_lib childlist = new Queue_lib();
        Node<T> p = root;
        st.push(p);
        int count = 0;
        while (!st.isEmpty()) {
            p = (Node) st.pop();
            if (p.right != null) {
                if (p.left == null) {
                    count++;
                    childlist.enqueue(p.info);
                }
                st.push(p.right);
            }
            if (p.left != null) {
                if (p.right == null) {
                    count++;
                    childlist.enqueue(p.info);
                }
                st.push(p.left);
            }
        }
        System.out.print(count + ": ");
        while (!childlist.isEmpty()) {
            System.out.print(childlist.dequeue() + " ");
        }
        System.out.println("");
    }

    // 2 child-node
    void two_child_node() {
        if (isEmpty()) {
            return;
        }
        Stack st = new Stack();
        Queue_lib childlist = new Queue_lib();
        Node<T> p = root;
        st.push(p);
        int count = 0;
        while (!st.isEmpty()) {
            p = (Node) st.pop();
            int check = 0;
            if (p.right != null) {
                st.push(p.right);
                check++;
            }
            if (p.left != null) {
                st.push(p.left);
                check++;
            }
            if (check == 2) {
                count++;
                childlist.enqueue(p.info);
            }
        }
        System.out.print(count + ": ");
        while (!childlist.isEmpty()) {
            System.out.print(childlist.dequeue() + " ");
        }
        System.out.println("");
    }

    // height
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

    // Breadth-First Traversal (Recursion)
    void bFT_recursion(Queue_lib qu) {
        if (qu.isEmpty()) {
            return;
        }
        Node<T> tmp = (Node) qu.dequeue();
        System.out.print(tmp.info + " ");
        if (tmp.left != null) {
            qu.enqueue(tmp.left);
        }
        if (tmp.right != null) {
            qu.enqueue(tmp.right);
        }
        bFT_recursion(qu);
    }

    // Subtree at level
    private int subtree_height(Node<T> p, T data) {
        if (p == null) {
            return -(2 * height(root));
        }
        if (p.info.compareTo(data) == 0) {
            return 1;
        }
        int a = subtree_height(p.left, data);
        int b = subtree_height(p.right, data);
        if (a > b) {
            return a + 1;
        }
        return b + 1;
    }

    void subtree(int lv) {
        if (isEmpty()) {
            return;
        }
        Node<T> p = root;
        Queue_lib q = new Queue_lib();
        q.enqueue(p);
        System.out.println("Level " + lv + ":");
        if (lv == 1) {
            pre_order_NLR(p);
            System.out.println("");
            return;
        }
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            if (p.left != null) {
                q.enqueue(p.left);
                if (lv == subtree_height(root, p.left.info)) {
                    pre_order_NLR(p.left);
                    System.out.println("");
                }
            }
            if (p.right != null) {
                q.enqueue(p.right);
                if (lv == subtree_height(root, p.right.info)) {
                    pre_order_NLR(p.right);
                    System.out.println("");
                }
            }
        }
    }

    void bftRecursion(ArrayList<Node> list, int g) {
        System.out.print("\nLevel " + g + ": ");
        ArrayList<Node> newList = new ArrayList<>();
        for (Node node : list) {
            if (node.left != null) {
                newList.add(node.left);
            }
            if (node.right != null) {
                newList.add(node.right);
            }
            System.out.print(node.info + " ");
        }
        //System.out.println("");

        if (!newList.isEmpty()) {
            bftRecursion(newList, g + 1);
        }
    }

    //Search
    Node Search(Node p, T data) {
        if (p == null) {
            return new Node("Cannot search");
        }
        if (data.compareTo(p.info) == 0) {
            return p;
        }
        if (data.compareTo(p.info) < 0) {
            return Search(p.left, data);
        }
        return Search(p.right, data);
    }

    //Insertion
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

    //Delete Node
    Node getMinimumkey(Node curr) {
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    Node deletion(Node p, T key) {
        // Node pointed to the current node
        Node parent = null;

        // Start
        Node curr = p;

        // search for key and set parent
        while (curr != null && curr.info != key) {
            parent = curr;

            if (key.compareTo(curr.info) < 0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        // if cannot find key
        if (curr == null) {
            return p;
        }

        // Case 1: node to be deleted has no children, i.e., it is a leaf node
        if (curr.left == null && curr.right == null) {
            //if tree has more than root node
            if (curr != p) {
                if (parent.left == curr) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else {
                p = null;
            }
        } // Case 2: node to be deleted has two children
        else if (curr.left != null && curr.right != null) {
            // find its inorder successor node
            Node successor = getMinimumkey(curr.right);

            // store successor value
            T val = (T) successor.info;

            // recursively delete the successor. Note that the successor
            // will have at most one child (right child)
            deletion(p, (T) successor.info);

            // copy value of the successor to the current node
            curr.info = val;
        } // Case 3: node to be deleted has only one children
        else {
            //choose a child node
            Node child = (curr.left != null) ? curr.left : curr.right;

            // if the node to be deleted is not a root node, set its parent
            // to its child
            if (curr != p) {
                if (curr == parent.left) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            } else {
                p = child;
            }
        }
        return p;
    }
}
