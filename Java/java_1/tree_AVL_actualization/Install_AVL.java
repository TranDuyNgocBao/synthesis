/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree_AVL_actualization;

import balance_binary_search_tree.*;
import binary_tree.*;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Install_AVL {
    public static void main(String[] args) {
        AVL<Integer> bst = new AVL<>();
        Integer [] arr = {30,10,20,15,40,25,27,26,5,13,14};
        //30,10,20,15,40,25,27,26,5,13,14
        //4,3,1,11,5,9,2,6,15,12
        //12,7,1,3,2,5,10,8,6,9
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i]);
        }
        bst.breadth();
        
        bst.balance_to_AVL();
        bst.breadth();
    }
}
