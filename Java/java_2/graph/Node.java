/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Node {
    public int vertex;
    public ArrayList arr = new ArrayList();
    Node next;

    public Node() {
    }

    public Node(int vertex, Node next) {
        this.vertex = vertex;
        this.next = next;
    }
}
