/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph4;

/**
 *
 * @author ADMIN
 */
public class UsingGraph {
    public static void main(String[] args) {
//        Graph gr = new Graph();
//        gr.loadGraph();
        Adjacency_graph agr = new Adjacency_graph();
        agr.loadGraph();
        agr.showGraph();
        agr.dijkstra(0, 4);
        agr.dijkstraByMinHeap(0, 4);
        agr.primJarnik(0);
    }
}
