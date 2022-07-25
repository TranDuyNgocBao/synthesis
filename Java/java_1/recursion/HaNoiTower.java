/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author ADMIN
 */
public class HaNoiTower {
    static int counT = 0;
    static void moveDisksHanoiTower(int nDisks, String stCol, String midCol, String endCol){
        if(nDisks == 1){
            counT++;
            System.out.println(counT +". Move from "+ stCol + " to " + endCol);
            return;
        }
        moveDisksHanoiTower(nDisks-1, stCol, endCol, midCol);
        moveDisksHanoiTower(1, stCol, midCol, endCol);
        moveDisksHanoiTower(nDisks-1, midCol, stCol, endCol);
    }
    
    public static void main(String[] args) {
        System.out.println("Move all Disks from A to C:");
        moveDisksHanoiTower(3, "A", "B", "C");
    }
}
