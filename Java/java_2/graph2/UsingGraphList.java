/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph2;


/**
 *
 * @author ADMIN
 */
public class UsingGraphList {
    public static void main(String[] args) {
        GraphList gl = new GraphList(14);
        gl.add(0, 0);
        gl.add(0, 1);
        gl.add(0, 6);
        gl.add(0, 8);
        gl.add(1, 4);
        gl.add(1, 6);
        gl.add(1, 9);
        gl.add(2, 4);
        gl.add(2, 6);
        gl.add(3, 4);
        gl.add(3, 5);
        gl.add(3, 8);
        gl.add(4, 5);
        gl.add(4, 9);
        gl.add(7, 8);
        gl.add(7, 9);
        gl.add(10, 11);
        gl.add(12, 13);
        gl.show();
        System.out.println();
        gl.DFS(1);
        System.out.println();
        if(gl.connection()){
            System.out.println("Connection");
        }else System.out.println("Connectionless");
        gl.count_connect();
        System.out.println();
        gl.DFS_NoRecursion(1);
        System.out.println();
        gl.BFS_NoRecursion(1);
        System.out.println();
        gl.BFS(1);
    }
}
