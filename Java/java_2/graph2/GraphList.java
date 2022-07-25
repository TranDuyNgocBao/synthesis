/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import queue_FIFO.PriorityQueue;
import queue_FIFO.Queue_lib;

/**
 *
 * @author ADMIN
 */
public class GraphList {

    int V, connect = 0;
    LinkedList<Integer> g[];
    boolean visited[];

    public GraphList(int v) {
        this.V = v;
        g = new LinkedList[v];
        visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            g[i] = new LinkedList<>();
            visited[i] = false;
        }
    }

    void add(int u, int v) {
        g[u].add(v);
        if (v != u) {
            g[v].add(u);
        }
    }

    void show() {
        for (int i = 0; i < V; i++) {
            System.out.println("[" + i + "]" + g[i].toString());
        }
    }

    void DFS(int i) {
        visited[i] = true;
        System.out.print(i + " ");
        for (int j = 0; j < g[i].size(); j++) {
            int key = g[i].get(j);
            if (!visited[key]) {
                DFS(key);
            }
        }
    }

    boolean connection() {
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
        System.out.println();
        for (int i = 0; i < V; i++) {
            connect = 0;
            depthFirst(i);
            if (connect == V) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    private void depthFirst(int i) {
        visited[i] = true;
        connect++;
        for (int j = 0; j < g[i].size(); j++) {
            int key = g[i].get(j);
            if (!visited[key]) {
                depthFirst(key);
            }
        }
    }

    void count_connect() {
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                System.out.print("Connection " + count + ": ");
                DFS(i);
                System.out.println();
            }
        }

    }

    void DFS_NoRecursion(int k) {
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
        Stack st = new Stack();
        st.push(k);
        while (!st.isEmpty()) {
            int key = (int) st.pop();
            if (!visited[key]) {
                visited[key] = true;
                System.out.print(key + " ");
                for (int i = g[key].size() - 1; i >= 0; i--) {
                    st.push(g[key].get(i));
                }
            }
        }
    }

    void BFS_NoRecursion(int k) {
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
        Queue_lib qu = new Queue_lib();
        qu.enqueue(k);
        while (!qu.isEmpty()) {
            int key = (int) qu.dequeue();
            if (!visited[key]) {
                visited[key] = true;
                System.out.print(key + " ");
                for (int i = 0; i < g[key].size(); i++) {
                    qu.enqueue(g[key].get(i));
                }
            }
        }
    }
    
    private void BFS(Queue_lib qu){
        int key = (int) qu.dequeue();
        if (!visited[key]) {
                visited[key] = true;
                System.out.print(key + " ");
                for (int i = 0; i < g[key].size(); i++) {
                    qu.enqueue(g[key].get(i));
                }
            }
        if(!qu.isEmpty())BFS(qu);
        return;
    }
    
    void BFS(int k){
        Queue_lib qu = new Queue_lib();
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
        qu.enqueue(k);
        BFS(qu);
        System.out.println();
    }
}
