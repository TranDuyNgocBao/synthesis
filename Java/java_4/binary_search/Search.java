/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary_search;

/**
 *
 * @author ADMIN
 */
public class Search {
    public static void main(String[] args) {
        Array cd = new Array(Utils.getNum("Size: "));
        cd.inputArray();
        cd.outputArray();
        System.out.println("Binary search: " + cd.binarySearch(Utils.getNum("Find = ")));
    }
}
