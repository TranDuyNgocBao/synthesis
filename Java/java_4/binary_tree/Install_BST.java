/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary_tree;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Install_BST {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int [] arr = {15,4,20,1};
        for (int i = 0; i < arr.length; i++) {
            bst.add(arr[i]);
        }
        Queue_lib qu = new Queue_lib();
        System.out.print("BFT (queue): ");
        bst.breadth();
        System.out.println("");
        
        System.out.print("DFS pre-order: ");
        bst.pre_order_NLR(bst.root);
        System.out.println("\n");
        
        System.out.print("DFS in-order: ");
        bst.in_order_LNR(bst.root);
        System.out.println("\n");
        
        System.out.print("DFS post-order: ");
        bst.post_order_LRN(bst.root);
        System.out.println("\n");
        
        System.out.print("DFS post-order khU DE QUY: ");
        bst.po_NLR_derecursion();
        System.out.println("");
        
        System.out.print("Dem La: ");
        bst.leaf_count();
        System.out.println("");
        
        System.out.print("La 1 con: ");
        bst.one_child_node();
        System.out.println("");
        
        System.out.print("Height: ");
        System.out.println(bst.height(bst.root) + "\n");
        
        System.out.print("La 2 con: ");
        bst.two_child_node();
        System.out.println("");
        
        System.out.print("BFT de quy: ");
        qu.enqueue(bst.root);
        bst.bFT_recursion(qu);
        System.out.println("\n");
        
        System.out.print("Cay con: ");
        bst.subtree(1);
        System.out.println("");
        
        System.out.print("Cay con BFT: ");
        bst.bftRecursion(bst.arl, 1);
        System.out.println("\n");
        
        System.out.println(bst.Search(bst.root, 5).info);
        System.out.println("Search and success: " + bst.Search(bst.root, 20).info + "\n");
        
        System.out.println("Insert 5, 16, 17");
        bst.insert(5);
        bst.insert(16);
        bst.insert(27);
        System.out.print("BFT: ");
        bst.breadth();
        System.out.println("");
        
        System.out.println("Delete 20");
        bst.deletion(bst.root ,20);
        System.out.print("BFT: ");
        bst.breadth();
    }
}
