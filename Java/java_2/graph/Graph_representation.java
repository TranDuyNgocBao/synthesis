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
public  interface Graph_representation {
    void loadFile(String fileURL);
    void representation();
    void deg();
    void sumBound();
    void dfs_DFS(int key);
}
