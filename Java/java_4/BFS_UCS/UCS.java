/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asscsd;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
//
class Pair1 implements Comparable<Pair1>{

    int value;
    int x, y;

    public Pair1(int value, int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair1 o) {
        return this.value - o.value;
    }

}

class Main1 {

    private static final int[] row = {-1, -1, -1, 0, 1, 0, 1, 1};
    private static final int[] col = {-1, 1, 0, -1, -1, 1, 0, 1};
    
    public static boolean isSafe(int[][] mat, int x, int y, boolean[][] processed) {
        return (x >= 0 && x < processed.length) && (y >= 0 && y < processed[0].length)
                && (mat[x][y] != 0) && !processed[x][y];
    }
    public static int UCS(int[][] mat, boolean[][] processed, int i, int j, int island) {
     
        PriorityQueue<Pair1> q = new PriorityQueue<>();
        island++;
        q.add(new Pair1(island,i, j));
        mat[i][j] = island;
        processed[i][j] = true;
        
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();

            for (int k = 0; k < row.length; k++) {
                //island++;
                if (isSafe(mat, x + row[k], y + col[k], processed)) {
                    processed[x + row[k]][y + col[k]] = true;
                    mat[x + row[k]][y + col[k]] = island;
                    q.add(new Pair1(island ,x + row[k], y + col[k]));
                }
            }
        }
        
        return island;
    }
    public static int countIslands(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return 0;
        }

        // `M × N` matrix
        int M = mat.length; //10
        int N = mat[0].length; //10

        // stores if a cell is processed or not
        boolean[][] processed = new boolean[M][N];
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                processed[i][j] = false;
            }
        }
        
        int island = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 1 && !processed[i][j]) {
                    island = UCS(mat, processed, i, j, island);
                }
            }
        }
        return island;
    }

    public static void main(String[] args) {
//        int[][] mat
//                = {//0  1  2  3  4  5  6  7  8  9
//                    /*0*/ {1, 0, 2, 0, 0, 0, 3, 3, 3, 3},
//                    /*1*/ {0, 0, 2, 0, 0, 0, 3, 0, 0, 0},
//                    /*2*/ {2, 2, 2, 2, 0, 0, 3, 0, 0, 0},
//                    /*3*/ {1, 0, 0, 2, 0, 3, 0, 0, 0, 0},
//                    /*4*/ {2, 2, 2, 2, 0, 0, 0, 5, 5, 5},
//                    /*5*/ {0, 2, 0, 2, 0, 0, 5, 5, 5, 5},
//                    /*6*/ {0, 0, 0, 0, 0, 5, 5, 5, 0, 0},
//                    /*7*/ {0, 0, 0, 4, 0, 0, 5, 5, 5, 0},
//                    /*8*/ {4, 0, 4, 0, 4, 0, 0, 5, 0, 0},
//                    /*9*/ {4, 4, 4, 4, 0, 0, 0, 5, 5, 5}
//                };

        int [][] mat ={ {1, 0, 1, 0, 0, 0, 1, 1, 1, 1},
                    {0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
                    {1, 1, 1, 1, 0, 0, 1, 0, 0, 0},
                    {1, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                    {1, 1, 1, 1, 0, 0, 0, 1, 1, 1},
                    {0, 1, 0, 1, 0, 0, 1, 1, 1, 1},
                    {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                    {0, 0, 0, 1, 0, 0, 1, 1, 1, 0},
                    {1, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                    {1, 1, 1, 1, 0, 0, 0, 1, 1, 1}
        };

//        int[][] mat = {{1, 0, 0, 0, 1},
//        {0, 1, 0, 0, 0},
//        {1, 0, 0, 1, 0},
//        {0, 0, 0, 0, 1},
//        {1, 0, 1, 1, 0}};

        System.out.println("The total number of islands: " + countIslands(mat));
        
        for (int i = 0; i < mat[0].length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
//     0 1 2 3 4
//    ----------
//   0|1 0 0 0 1
//   1|0 1 0 0 0
//   2|1 0 0 1 0
//   3|0 0 0 0 1
//   4|1 0 1 1 0
}