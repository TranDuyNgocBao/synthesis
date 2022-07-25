/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balance_binary_search_tree;

import binary_tree.*;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Install_balance_algorithm {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Integer [] arr = {5, 1, 9, 8, 7, 0, 2, 3, 4, 6};
        for (int i = 0; i < arr.length; i++) {
            bst.add(arr[i]);
        }
        bst.breadth();
        
        bst.root = null;
        bst.sort_arr(arr);
        bst.balance(arr, 0, arr.length-1);
        bst.breadth();
    }
}
