/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import algorithm.MonkeyBananaSolution;
import interfere.State;
import interfere.Utils;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class UserWithInstruction {

    static MonkeyBananaSolution mbs;
    
    static public void userPlaywithIns(int[][] a) {
        State state = new State();
        mbs = new MonkeyBananaSolution(a);
        Utils.createMap();
        System.out.println("Room: ");
        Utils.showMap(a);
        int pos[] = posObj(1, mbs);
        int x = pos[0];
        int y = pos[1];
        int step = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println(step + ". Monkey does not have banana");
        System.out.println("Press a-Left_w-Up_s-Down_d-Right");

        do {
            System.out.print("Enter way (Enter \"h\" to get HINT): ");
            String way = sc.next();

            if (way.equals("a")) {
                System.out.println(++step + ". ");
                if (checkValid(x, y - 1, mbs)) {
                    if (checkState(state, a[x][y - 1])) {
                        a[x][y] = 0;
                        y = y - 1;
                        a[x][y] = 1;
                    } else {
                        if (checkValid(x, y - 2, mbs)) {
                            a[x][y] = 0;
                            y = y - 2;
                            a[x][y] = 1;
                        }
                    }
                } else {
                    System.out.println("Out of range");
                }
            } else if (way.equals("d")) {
                System.out.println(++step + ". ");
                if (checkValid(x, y + 1, mbs)) {
                    if (checkState(state, a[x][y + 1])) {
                        a[x][y] = 0;
                        y = y + 1;
                        a[x][y] = 1;
                    } else {
                        if (checkValid(x, y + 2, mbs)) {
                            a[x][y] = 0;
                            y = y + 2;
                            a[x][y] = 1;
                        }
                    }
                } else {
                    System.out.println("Out of range");
                }
            } else if (way.equals("w")) {
                System.out.println(++step + ". ");
                if (checkValid(x - 1, y, mbs)) {
                    if (checkState(state, a[x - 1][y])) {
                        a[x][y] = 0;
                        x = x - 1;
                        a[x][y] = 1;
                    } else {
                        if (checkValid(x - 2, y, mbs)) {
                            a[x][y] = 0;
                            x = x - 2;
                            a[x][y] = 1;
                        }
                    }
                } else {
                    System.out.println("Out of range");
                }
            } else if (way.equals("s")) {
                System.out.println(++step + ". ");
                if (checkValid(x + 1, y, mbs)) {
                    if (checkState(state, a[x + 1][y])) {
                        a[x][y] = 0;
                        x = x + 1;
                        a[x][y] = 1;
                    } else {
                        if (checkValid(x + 2, y, mbs)) {
                            a[x][y] = 0;
                            x = x + 2;
                            a[x][y] = 1;
                        }
                    }
                } else {
                    System.out.println("Out of range");
                }
            } else if (way.equals("h")) {
                getInstruction(state, mbs);
            } else {
                System.out.println("Only a-Left\n     w-Up\n     s-Down\n     d-Right\n     h-Hide");
            }
            Utils.showMap(a);
        } while (state.hasBanana == false);
        System.out.println("CONGRATULATION! Monkey gets his BANANA");
        System.out.println("Total step: " + step);
    }

    static private int[] posObj(int obj, MonkeyBananaSolution mbs) {
        int[] pos = new int[2];
        for (int i = 0; i < mbs.getRow(); i++) {
            for (int j = 0; j < mbs.getCol(); j++) {
                if (Utils.a[i][j] == obj) {
                    pos[0] = i;
                    pos[1] = j;
                    break;
                }
            }
        }
        return pos;
    }

    static private boolean checkValid(int x, int y, MonkeyBananaSolution mbs) {
        if (x >= 0 && x < mbs.getRow()
                && y >= 0 && y < mbs.getCol()) {
            return true;
        } else {
            return false;
        }
    }

    static private boolean checkState(State state, int obj) {
        if (obj == 2) {
            System.out.println("INS: Monkey needs to pick up the Stick to get BaNaNa Later");
            if (state.pickup()) {
                state.hasStick = true;
                System.out.println("Monkey picked up the Stick");
                return true;
            } else {
                return false;
            }
        } else if (obj == 3) {
            System.out.println("INS: Monkey needs to push the Chair to use it Later");
            state.hasChair = true;
            if (state.pushChair()) {
                System.out.println("Monkey pushed the Chair");
                return true;
            } else {
                state.hasChair = false;
                return false;
            }
        } else if (obj == 4) {
            if (state.hasStick && state.hasChair) {
                System.out.println("INS: Monkey needs climbing the Chair to reach BANANA");
                if (state.climbChair()) {
                    System.out.println("INS: Monkey needs waving the Stick to get BANANA");
                    if (state.useStick()) {
                        state.hasBanana = true;
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    state.useStick();
                    return false;
                }
            } else if (!state.hasStick && state.hasChair) {
                if (state.climbChair()) {
                    if (state.useStick() == false) {
                        state.pushChair();
                        System.out.println("Monkey needs to pick up Stick to reach the BaNaNa");
                        mbs.fastWay(1, 2);
                        return false;
                    }
                }
            } else if (state.hasStick && !state.hasChair) {
                state.useStick();
                state.pushChair();
                System.out.println("Monkey needs to get the Chair to climb and reach the BaNaNa");
                mbs.fastWay(1, 3);
                return false;

            } else if (!state.hasStick && !state.hasChair) {
                state.useStick();
                state.pushChair();
                System.out.println("Monkeys needs to get Stick and Chair First");
                mbs.fastWay(1, 2);
                mbs.fastWay(1, 3);
                return false;
            }
        }
        return true;
    }
    
    static private void getInstruction(State state, MonkeyBananaSolution mbs){
        if(!state.hasChair && !state.hasStick){
            System.out.println("Monkey needs to find a Stick and a Chair to get Banana");
            System.out.print("Get Stick: ");
            mbs.fastWay(1, 2);
            System.out.print("Get Chair: ");
            mbs.fastWay(1, 3);
        }else if(!state.hasChair){
            System.out.println("Monkey needs to find a Chair to get Banana");
            System.out.print("Get Chair: ");
            mbs.fastWay(1, 3);
        }else if(!state.hasStick){
            System.out.println("Monkey needs to find a Stick to get Banana");
            System.out.print("Get Stick: ");
            mbs.fastWay(1, 2);
        }else if(!state.hasBanana){
            System.out.println("Monkey needs to find Banana's location");
            System.out.print("Get BANANA: ");
            mbs.fastWay(1, 4);
        }
    }
}
