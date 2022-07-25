/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph3;

import java.util.Stack;


/**
 *
 * @author ADMIN
 */
public class ShortestPath {
    static final int vocung = 1000000;
    static int [][] a = {{0, 7, 9, 0, 0, 14},
                        {7, 0, 10, 15, 0, 0},
                        {9, 10, 0, 11, 0, 2},
                        {0, 15, 11, 0, 6, 0},
                        {0, 0, 0, 6, 0, 9},
                        {14, 0, 2, 0, 9, 0}};
    static int size = 6;
    
    static void Dijkstra(int Fnode, int Lnode){
        boolean S[] = new boolean[size];
        int L[] = new int[size];
        int P[] = new int[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i!=j && a[i][j]==0)a[i][j]=vocung;
            }
        }
        for (int i = 0; i < size; i++) {
            S[i] = false;
            L[i] = vocung;
            P[i] = Fnode;
        }
        int i = 0;
        L[Fnode] = 0;
        while(S[Lnode] == false){
            //đi tìm những đỉnh kề với đỉnh đang xet và có L[] ngắn nhất, giả sử đó là i
            int min = vocung;
            int min_index = i;
            for (int j = 0; j < size; j++) {
                if(!S[j] && min>L[j]){
                    min = L[j];
                    min_index = j;
                }
            }
            i = min_index;
            S[i] = true;
            for (int j = 0; j < size; j++) {
                if(!S[j] && L[j]>L[i]+a[i][j]){
                    L[j] = L[i]+a[i][j];
                    P[j] = i;
                }
            }
        }
        System.out.println("Length of Shortest Path is: " + L[Lnode]);
        Stack<Integer> st = new Stack<>();
        int x = Lnode;
        do{
            st.push(x);
            x = P[x];
        }while(x != Fnode);
        if(Lnode != Fnode)st.push(Fnode);
        System.out.print("Path: ");
        while(!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Dijkstra(0, 4);
    }
}
