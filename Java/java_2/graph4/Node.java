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
public class Node implements Comparable{

    int vertex, weight;

    public Node() {
    }

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        return (this.weight - (((Node) o).weight));
    }
}
