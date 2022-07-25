package bst_prime;

//'main' method must be in a class 'Rextester'.
//openjdk version '11.0.5' 
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node<T> {

    T infor;
    Node<T> left;
    Node<T> right;

    public Node() {
    }

    public Node(T infor) {
        this.infor = infor;
    }

    public Node(T infor, Node<T> left, Node<T> right) {
        this.infor = infor;
        this.left = left;
        this.right = right;
    }

}

class BST<T extends Comparable<T>> {

    Node<T> root = null;

    public BST() {
    }

    boolean isEmpty() {
        return root == null;
    }

    void add(T el) {
        Node<T> tmp = root;
        Node<T> pre = null;
        Node<T> p = new Node<T>(el);
        if (isEmpty()) {
            root = p;
        } else {
            while (tmp != null) {
                pre = tmp;
                if (el.compareTo(tmp.infor) == 1) {
                    tmp = tmp.right;
                } else {
                    tmp = tmp.left;
                }
            }
            if (el.compareTo(pre.infor) == 1) {
                pre.right = p;
            } else {
                pre.left = p;
            }
        }
    }

    void NLR(Node<T> tmp) {
        if (tmp != null) {
            System.out.print(tmp.infor + " ");
            NLR(tmp.left);
            NLR(tmp.right);
        }
    }

    void LNR(Node<T> tmp) {
        if (tmp != null) {
            LNR(tmp.left);
            System.out.print(tmp.infor + " ");
            LNR(tmp.right);
        }
    }

    void LRN(Node<T> tmp) {
        if (tmp != null) {
            LRN(tmp.left);
            LRN(tmp.right);
            System.out.print(tmp.infor + " ");
        }
    }

    int getLeafCount(Node<T> node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            System.out.print(node.infor + "  ");
            return 1;
        } else {
            return getLeafCount(node.left) + getLeafCount(node.right);
        }
    }

    int countNodeHasTwoChildren(Node<T> p) {
        if (p == null) {
            return 0;
        }
        if (p.left != null && p.right != null) {
            System.out.print(p.infor + "   ");
            return 1 + countNodeHasTwoChildren(p.left) + countNodeHasTwoChildren(p.right);
        }
        return countNodeHasTwoChildren(p.left) + countNodeHasTwoChildren(p.right);
    }

    int get1Child(Node<T> p) {
        if (p == null) {
            return 0;
        }
        if (p.left == null ^ p.right == null) {
            System.out.print(p.infor + " ");
            return 1 + get1Child(p.left) + get1Child(p.right);
        }
        return get1Child(p.left) + get1Child(p.right);
    }

    int height(Node<T> p) {
        if (p == null) {
            return 0;
        } else {
            int a = height(p.left);
            int b = height(p.right);
            if (a > b) {
                return a + 1;
            }
            return b + 1;
        }
    }

    void NLRLoop(Node<T> p) {
        if (p == null) {
            return;
        }
        Stack<Node<T>> st = new Stack<>();
        st.push(p);
        while (!st.isEmpty()) {
            p = st.pop();
            System.out.print(p.infor + " ");
            if (p.right != null) {
                st.push(p.right);
            }
            if (p.left != null) {
                st.push(p.left);
            }
        }
    }
    
    List<Integer> make_List_tree(Node<T> p) {
        if (p == null) {
            return null;
        }
        List<Integer> ar = new ArrayList<>();
        Stack<Node<T>> st = new Stack<>();
        st.push(p);
        while (!st.isEmpty()) {
            p = st.pop();
            ar.add((Integer) p.infor);
            if (p.right != null) {
                st.push(p.right);
            }
            if (p.left != null) {
                st.push(p.left);
            }
        }
        return ar;
    }
    
    void find_Prime_max(){
        List<Integer> left_tree = make_List_tree(this.root.left);
        List<Integer> right_tree = make_List_tree(this.root.right);
        
        int maxPr = 0;
        int [] trace = new int[2];
        
        for (int i = 0; i < right_tree.size(); i++) {
            int get_i = right_tree.get(i);
            for (int j = 0; j < left_tree.size(); j++) {
                int get_j = left_tree.get(j);
                if(get_i + get_j > maxPr && gcd(get_i, get_j)==1){
                    maxPr = get_i + get_j;
                    trace[1] = get_i;
                    trace[0] = get_j;
                }
            }
        }
        System.out.println("\nMax pairs So nguyen To cung nhau: " + "(" + trace[0] +","+ trace[1] +")");
    }
    
    private int gcd(int num1, int num2) {
        
        while(num2 != 0){
           int tmp = num1%num2;
           num1 = num2;
           num2 = tmp;
        }

        return num1;
    }
}

class Rextester {

    public static void main(String args[]) {
        BST<Integer> bst = new BST<>();
        int[] a = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int i = 0; i < a.length; i++) {
            bst.add(a[i]);
        }
        System.out.print("NLR: ");
        bst.NLR(bst.root);
        System.out.println("");
        System.out.print("LRN: ");
        bst.LRN(bst.root);
        System.out.println("");
        System.out.print("LNR: ");
        bst.LNR(bst.root);
        System.out.println("");

        System.out.println("So node la: " + bst.getLeafCount(bst.root));
        System.out.println("");
        System.out.println("So node 1 con la: " + bst.get1Child(bst.root));

        System.out.println("");
        System.out.println("So node 2 con la: " + bst.countNodeHasTwoChildren(bst.root));

        System.out.println("");
        System.out.println("Chieu cao cua cay la: " + bst.height(bst.root));

        System.out.println("");
        System.out.print("NLR Khong de quy: ");

        bst.NLRLoop(bst.root);
        
        System.out.println();
        bst.find_Prime_max();
    }
}
