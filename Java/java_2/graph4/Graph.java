/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph4;

import java.util.LinkedList;

/**
 *
 * @author ADMIN
 */
public class Graph {
    int[][] a = {{0, 7, 9, 0, 0, 14},
                {7, 0, 10, 15, 0, 0},
                {9, 10, 0, 11, 0, 2},
                {0, 15, 11, 0, 6, 0},
                {0, 0, 0, 6, 0, 9},
                {14, 0, 2, 0, 9, 0}};

    int V;
    boolean visited[];
    LinkedList<Integer> g[];

    public Graph() {
    }
    
    private void Graph(int v) {
        V = v;
        g = new LinkedList[V];
        visited = new boolean[V];
        resetVisit();
        for (int i = 0; i < V; i++) {
            g[i] = new LinkedList<>();
        }
    }
    
    private void resetVisit(){
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
    }
    
    private void addEdge(int u, int v){
        g[u].add(v);
    }
    
    public void loadGraph(){
        V = a[0].length;
        Graph(V);
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if(a[i][j] != 0)addEdge(i, j);
            }
        }
    }
    
    public void showGraph(){
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex "+i+": " + g[i].toString());
        }
    }
    
    
}
