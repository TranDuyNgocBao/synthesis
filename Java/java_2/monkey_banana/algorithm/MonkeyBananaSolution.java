/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import interfere.Utils;
import static interfere.Utils.a;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 *
 * 
 */
public class MonkeyBananaSolution {

    private int row;
    private int col;

    private int a[][];
    private LinkedList<Integer> g[];

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    
    

    public MonkeyBananaSolution(int[][] a) {
        this.a = a;
        row = a[0].length;
        col = a.length;
        Utils.map = new HashMap<>();
        Utils.map.put(1, "Monkey");
        Utils.map.put(2, "Stick");
        Utils.map.put(3, "Chair");
        Utils.map.put(4, "Banana");
    }
    
    public void showMap() {
        System.out.println();
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == 0) {
                    System.out.print(a[i][j] + "\t");
                } else {
                    System.out.print(Utils.map.get(a[i][j]) + "\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private void BFS(int start, int end) {
        Queue_lib<Integer> qul = new Queue_lib<>();
        boolean[] visited = new boolean[row * col + 1];
        Arrays.fill(visited, true);
        qul.enqueue(start);
        visited[start] = false;
        int count = 0;
        int trace[] = new int[row * col + 1];
        trace[start] = 0;

        while (!qul.isEmpty()) {
            int key = qul.dequeue();
            for (int i = 0; i < g[key].size(); i++) {
                int v = g[key].get(i);
                if (visited[v]) {
                    qul.enqueue(v);
                    visited[v] = false;
                    trace[v] = key;
                }
                if (v == end) {
                    qul.clear();
                    break;
                }
            }
        }
        if (trace.length == 0) {
            System.out.println("Cannot find");
        } else {
            Stack path = new Stack();
            int destiny = end;
            while (destiny != 0) {
                path.push(destiny);
                destiny = trace[destiny];
                count++;
            }
            int prev = (int) path.pop();
            while (!path.isEmpty()) {
                int location = (int) path.pop();
                int check = location - prev;
                if (check == 1) {
                    System.out.print("Right ");
                }
                if (check == -1) {
                    System.out.print("Left ");
                }
                if (check == row) {
                    System.out.print("Down ");
                }
                if (check == -row) {
                    System.out.print("Up ");
                }
                prev = location;
            }
        }
        System.out.println("(total = " + (--count) + ")");
    }

    public int get_position(int type) {
        int count = 0;
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                count++;
                if (a[i][j] == type) {
                    return count;
                }
            }
        }
        return 0;
    }

    public void replace_type(int pos, int type) {
        int count = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                count++;
                if (count == pos) {
                    a[i][j] = type;
                    return;
                }
            }
        }
    }

    public void fastWay(int source, int des) {
        row = a[0].length;
        col = a.length;
        int start = 0, end = 0;
        int count = 0;

        g = new LinkedList[row * col + 2];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                count++;
                g[count] = new LinkedList();
                if (i - 1 >= 0) {
                    g[count].add(count - row);
                }
                if (i + 1 < col) {
                    g[count].add(count + row);
                }
                if (j + 1 < row) {
                    g[count].add(count + 1);
                }
                if (j - 1 >= 0) {
                    g[count].add(count - 1);
                }
                if (a[i][j] == source) {
                    start = count;
                }
                if (a[i][j] == des) {
                    end = count;
                }
            }
        }
        System.out.print("From " + Utils.map.get(source) + " to " + Utils.map.get(des) + ": ");
        BFS(start, end);
    }

    public int shortestDis(int start, int end) {
        boolean[][] visited = new boolean[row][col];
        Queue_lib<Cell> q = new Queue_lib();
        int startX = -1, startY = -1;
        int dis = 0;
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == start) {
                    startX = i;
                    startY = j;
                }
            }
        }
        q.enqueue(new Cell(startX, startY, 0));
        visited[startX][startY] = true;
        while (!q.isEmpty()) {
            Cell p = q.dequeue();

            if (a[p.x][p.y] == end) {
                dis = p.dist;
                break;
            }
            //up
            if (checkValid(p.x - 1, p.y, visited)) {
                q.enqueue(new Cell(p.x - 1, p.y, p.dist + 1));
                visited[p.x - 1][p.y] = true;

            }
            //down
            if (checkValid(p.x + 1, p.y, visited)) {
                q.enqueue(new Cell(p.x + 1, p.y, p.dist + 1));
                visited[p.x + 1][p.y] = true;
            }
            //left
            if (checkValid(p.x, p.y - 1, visited)) {
                q.enqueue(new Cell(p.x, p.y - 1, p.dist + 1));
                visited[p.x][p.y - 1] = true;
            }
            //right
            if (checkValid(p.x, p.y + 1, visited)) {
                q.enqueue(new Cell(p.x, p.y + 1, p.dist + 1));
                visited[p.x][p.y + 1] = true;
            }
        }
        return dis;
    }

    private boolean checkValid(int x, int y, boolean visited[][]) {
        if (x >= 0 && x < row
                && y >= 0 && y < col
                && visited[x][y] == false) {
            return true;
        } else {
            return false;
        }
    }

}

//    public void botPlay() {
//        fastWay(1, 2);
//        fastWay(2, 3);
//        fastWay(3, 4);
//    }
//    
//    public void botPlay() {
//        boolean hasStick = false;
//        boolean toChair = false;
//        boolean push = false;
//        boolean climb = false;
//        boolean hasBanana = false;
//        /*not have stick and chair and banana*/ 
//        System.out.print("0. "); state(1, hasStick, toChair, hasBanana, push, climb);
//        System.out.print("1. "); fastWay(1, 2); state(1, hasStick=true, toChair, hasBanana, push, climb);  
//                                 takeStick(hasStick);
//        System.out.print("2. "); fastWay(2, 3); state(1, hasStick, toChair=true, hasBanana, push, climb);
//                                 pushChair(toChair); push = true;
//        System.out.print("3. "); fastWay(3, 4); state(1, hasStick, toChair, hasBanana, push, climb);
//                                 climbChair(toChair); climb = true;
//                                 waveStick(hasStick); hasBanana = true;
//        System.out.print("4. "); state(1, hasStick, toChair, hasBanana, push, climb);
//    }
//
//    //state
//    private void state(int monkey, boolean hasStick, boolean toChair, boolean hasBanana, boolean push, boolean climb) {
//        if(hasStick && !toChair && !hasBanana) {
//            System.out.println("   The monkey goes to the stick and still doesn't have banana");
//        }
//        if(!hasStick && toChair && !hasBanana) {
//            System.out.println("The monkey goes to the chair and still doesn't have banana");
//        }
//        if(!hasStick && !toChair && !hasBanana) {
//            System.out.println("The monkey doesn't have banana");
//        }
//        if(hasStick && toChair && hasBanana) {
//            System.out.println("The monkey has banana");
//        }
//        if(hasStick && toChair && !hasBanana) {
//            if(!push && !climb) System.out.println("   The monkey has stick and goes to the chair but still doesn't have banana");
//        }
//    }
//    
//    private void takeStick(boolean hasStick) { //kiểm tra đã cầm gậy chưa
//        if (hasStick) System.out.println("-> The monkey takes the stick");
//        else System.out.println("-> The monkey doesn't take the stick");
//    }
//
//    private void waveStick(boolean hasStick) {
//        if (hasStick) System.out.println("-> The monkey waves the stick");
//        else System.out.println("-> The monkey doesn't wave the stick");
//    }
//
//    private void pushChair(boolean toChair) {
//        if (toChair) System.out.println("-> The monkey pushes the chair");
//        else System.out.println("-> The monkey doesn't pushes the chair");;
//    }
//
//    private void climbChair(boolean toChair) {
//        if (toChair) System.out.println("-> The monkey climbs on the chair");
//        else System.out.println("-> The monkey doesn't climbs on the chair");
//    }  
