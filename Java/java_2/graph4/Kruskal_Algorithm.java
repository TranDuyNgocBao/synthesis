/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph4;

import java.util.Arrays;

/**
 *
 * @author ADMIN
 */
public class Kruskal_Algorithm {
     class Edge implements Comparable<Edge> {  
        int source, destination, weight;  
  
        public int compareTo(Edge edgeToCompare) {  
            return this.weight - edgeToCompare.weight;  
        }  
    };  
  
    // create class Subset for union  
    class Subset {  
        int parent, value;  
    };  
      
    //initialize vertices, edges and edgeArray  
    int vertices, edges;  
    Edge edgeArray[];  
  
    // using constructor to create a graph  
    Kruskal_Algorithm(int vertices, int edges) {  
        this.vertices = vertices;  
        this.edges = edges;  
        edgeArray = new Edge[this.edges];  
        for (int i = 0; i < edges; ++i)  
            edgeArray[i] = new Edge();  //create edge for all te edges given by the user  
    }  
      
    // create applyKruskal() method for applying Kruskal's Algorithm  
    void applyKruskal() {  
          
        // initialize finalResult array to store the final MST  
        Edge finalResult[] = new Edge[vertices];  
        int newEdge = 0;  
        int index = 0;  
        for (index = 0; index < vertices; ++index)  
            finalResult[index] = new Edge();  
  
        // using sort() method for sorting the edges  
        Arrays.sort(edgeArray);  
          
        // create an array of the vertices of type Subset for the subsets of vertices  
        Subset subsetArray[] = new Subset[vertices];  
          
        // aloocate memory to create vertices subsets  
        for (index = 0; index < vertices; ++index)  
            subsetArray[index] = new Subset();  
  
        // it is used to create subset with single element  
        for (int vertex = 0; vertex < vertices; ++vertex) {  
            subsetArray[vertex].parent = vertex;  
            subsetArray[vertex].value = 0;  
        }  
        index = 0;  
          
        // use for loop to pick the smallers edge from the edges and increment the index for next iteration  
        while (newEdge < vertices - 1) {  
            // create an instance of Edge for next edge  
            Edge nextEdge = new Edge();  
            nextEdge = edgeArray[index++];  
              
            int nextSource = findSetOfElement(subsetArray, nextEdge.source);  
            int nextDestination = findSetOfElement(subsetArray, nextEdge.destination);  
              
            //if the edge doesn't create cycle after including it, we add it in the result and increment the index  
            if (nextSource != nextDestination) {  
                finalResult[newEdge++] = nextEdge;  
                performUnion(subsetArray, nextSource, nextDestination);  
            }  
        }  
        for (index = 0; index < newEdge; ++index)  
            System.out.println(finalResult[index].source + " - " + finalResult[index].destination + ": " + finalResult[index].weight);  
    }  
      
    // create findSetOfElement() method to get set of an element  
    int findSetOfElement(Subset subsetArray[], int i) {  
        if (subsetArray[i].parent != i)  
            subsetArray[i].parent = findSetOfElement(subsetArray, subsetArray[i].parent);  
        return subsetArray[i].parent;  
    }  
      
    // create performUnion() method to perform union of two sets  
    void performUnion(Subset subsetArray[], int sourceRoot, int destinationRoot) {  
          
        int nextSourceRoot = findSetOfElement(subsetArray, sourceRoot);  
        int nextDestinationRoot = findSetOfElement(subsetArray, destinationRoot);  
  
        if (subsetArray[nextSourceRoot].value < subsetArray[nextDestinationRoot].value)  
            subsetArray[nextSourceRoot].parent = nextDestinationRoot;  
        else if (subsetArray[nextSourceRoot].value > subsetArray[nextDestinationRoot].value)  
            subsetArray[nextDestinationRoot].parent = nextSourceRoot;  
        else {  
            subsetArray[nextDestinationRoot].parent = nextSourceRoot;  
            subsetArray[nextSourceRoot].value++;  
        }  
    }
    
    int[][] a = {{0, 7, 9, 0, 0, 14},
    {7, 0, 10, 15, 0, 0},
    {9, 10, 0, 11, 0, 2},
    {0, 15, 11, 0, 6, 0},
    {0, 0, 0, 6, 0, 9},
    {14, 0, 2, 0, 9, 0}};
    
    public static void main(String[] args) {
        Kruskal_Algorithm graph = new Kruskal_Algorithm(6, 10);
        
        graph.edgeArray[0].source = 0;
        graph.edgeArray[0].destination = 1;
        graph.edgeArray[0].weight = 7;
        graph.edgeArray[0].source = 0;
        graph.edgeArray[0].destination = 2;
        graph.edgeArray[0].weight = 9;
        graph.edgeArray[0].source = 0;
        graph.edgeArray[0].destination = 5;
        graph.edgeArray[0].weight = 14;
        graph.applyKruskal();
    }
}
