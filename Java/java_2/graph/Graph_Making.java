/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author ADMIN
 */
public class Graph_Making {
    public static void main(String[] args) {
        String fileURL = "Edge_List.txt";
        System.out.println("Adjacency List:");
        Graph_representation adlist = new Adjacency_list();
        adlist.loadFile(fileURL);
        adlist.representation();
        
        System.out.println("\nAdjacency Matrix:");
        Graph_representation mtList = new Adjacency_matrix();
        mtList.loadFile(fileURL);
        mtList.representation();
        
        System.out.println("\nIncident Matrix:");
        Graph_representation icMtrix = new Incident_matrix();
        icMtrix.loadFile(fileURL);
        icMtrix.representation();
        
        System.out.println("\nDegree:");
        adlist.deg();
        
        System.out.print("\nSum Bound: ");
        mtList.sumBound();
        System.out.println();
        
        System.out.println("\nDFS travel:");
        mtList.dfs_DFS(5);
        System.out.println();
    }
}
