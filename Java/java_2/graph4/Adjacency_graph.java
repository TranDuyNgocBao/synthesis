/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 *
 * @author ADMIN
 */
public class Adjacency_graph {

    int V;
    LinkedList<Node> adjList[];
    final int vocung = 1000000;
    int[][] a = {{0, 7, 9, 0, 0, 14},
    {7, 0, 10, 15, 0, 0},
    {9, 10, 0, 11, 0, 2},
    {0, 15, 11, 0, 6, 0},
    {0, 0, 0, 6, 0, 9},
    {14, 0, 2, 0, 9, 0}};

    public Adjacency_graph() {
        V = 0;
    }
    
    private int getEdge(){
        int count = 0;
        int ex = 0;
        for (int i = 0; i < adjList.length; i++) {
            for (int j = 0; j < adjList[i].size(); j++) {
                if(i != adjList[i].get(j).vertex)count++;
                else ex++;
            }
        }
        count = count/2 + ex;
        return count;
    }

    private void graph(int nodeCount) {
        V = nodeCount;
        adjList = new LinkedList[V];
    }

    private void addEdge(int source, int v, int w) {
        Node newNode = new Node();
        newNode.vertex = v;
        newNode.weight = w;
        adjList[source].add(newNode);
    }

    public void loadGraph() {
        int nodeCount = a[0].length;
        graph(nodeCount);
        for (int i = 0; i < nodeCount; i++) {
            adjList[i] = new LinkedList<>();
            for (int j = 0; j < nodeCount; j++) {
                if (a[i][j] != 0) {
                    addEdge(i, j, a[i][j]);
                }
            }
        }
    }

    public void showGraph() {
        for (int i = 0; i < adjList.length; i++) {
            System.out.print("Vertex " + i + ": ");
            for (int j = 0; j < adjList[i].size(); j++) {
                System.out.print("[" + adjList[i].get(j).vertex + "," + adjList[i].get(j).weight + "] ");
            }
            System.out.println();
        }
    }

    public void dijkstra(int Fnode, int Lnode) {
        boolean S[] = new boolean[V];
        int L[] = new int[V];
        int P[] = new int[V];
        for (int i = 0; i < V; i++) {
            S[i] = false;
            L[i] = vocung;
            P[i] = Fnode;
        }
        int i = 0;
        L[Fnode] = 0;
        while (S[Lnode] == false) {
            //đi tìm những đỉnh kề với đỉnh đang xet và có L[] ngắn nhất, giả sử đó là i
            int min = vocung;
            int min_index = i;
            for (int j = 0; j < V; j++) {
                if (!S[j] && min > L[j]) {
                    min = L[j];
                    min_index = j;
                }
            }
            i = min_index;
            S[i] = true;
            for (int j = 0; j < adjList[i].size(); j++) {
                if (!S[adjList[i].get(j).vertex] && L[adjList[i].get(j).vertex] > L[i] + adjList[i].get(j).weight) {
                    L[adjList[i].get(j).vertex] = L[i] + adjList[i].get(j).weight;
                    P[adjList[i].get(j).vertex] = i;
                }
            }
        }
        System.out.println("Length of Shortest Path is: " + L[Lnode]);
        Stack<Integer> st = new Stack<>();
        int x = Lnode;
        do {
            st.push(x);
            x = P[x];
        } while (x != Fnode);
        if (Lnode != Fnode) {
            st.push(Fnode);
        }
        System.out.print("Path: ");
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
        System.out.println();
    }

    public void dijkstraByMinHeap(int Start, int End) {
        final int INF = 1000000;
        int[] shortest = new int[V];
        int[] backtrace = new int[V];
        Arrays.fill(shortest, INF);
        shortest[Start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(Start, 0));
        backtrace[Start] = -1;
        while (!pq.isEmpty()) {
            int u = pq.peek().vertex;
            int w = pq.peek().weight;
            pq.remove();
            if (shortest[u] != w) {
                continue;
            }
            for (int i = 0; i < adjList[u].size(); i++) {
                int v = adjList[u].get(i).vertex;
                int eg = adjList[u].get(i).weight;
                if (shortest[v] > w + eg) {
                    shortest[v] = w + eg;
                    backtrace[v] = u;
                    pq.add(new Node(v, shortest[v]));
                }
            }
        }
        System.out.println("Length of Shortest Path is: " + shortest[End]);
        Stack<Integer> st = new Stack<>();
        int v = End;
        st.push(v);
        while (backtrace[v] != -1) {
            v = backtrace[v];
            st.push(v);
        }
        System.out.print(st.pop());
        while (!st.empty()) {
            System.out.print(" -> " + st.pop());
        }
        System.out.println();
    }

    public void primJarnik(int start) {
        boolean S[] = new boolean[V];
        int P[] = new int[V];
        int L[] = new int[V];
        for (int i = 0; i < V; i++) {
            S[i] = false;
            L[i] = vocung;
            P[i] = start;
        }
        int i = start;
        L[start] = 0;
        int count = 0;
        
        System.out.println("Edge \tWeight");
        while (count < V-1) {
            S[i] = true;
            int min = vocung;
            int min_index = 0;
            for (int j = 0; j < V; j++) {
                if(S[j]){
                    for (int k = 0; k < adjList[j].size(); k++) {
                        int v = adjList[j].get(k).vertex;
                        int w = adjList[j].get(k).weight;
                        if(!S[v] && L[v]>L[j]+w && min > L[j]+w){
                            L[v] = L[j]+adjList[j].get(k).weight;
                            min = L[j]+adjList[j].get(k).weight;
                            P[j] = v;
                            min_index = j;
                            i = v;
                        }
                    }
                }
            }
            count++;
            System.out.println(min_index + "-" + P[min_index] + " \t" + L[P[min_index]]);
        }
    }
    
    
}
