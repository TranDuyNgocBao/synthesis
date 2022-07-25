/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import interfere.State;
import interfere.Utils;
import algorithm.MonkeyBananaSolution;
import java.util.Scanner;

/**
 *
 * 
 */
public class UserPlay {

    static public void userPlay(int[][] a) {
        State state = new State();
        MonkeyBananaSolution mbs = new MonkeyBananaSolution(a);
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
            System.out.print("Enter way: ");
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
            } else {
                System.out.println("Only a-Left\n     w-Up\n     s-Down\n     d-Right");
            }
            Utils.showMap(a);
        } while (state.hasBanana == false);
        System.out.println("Congratulation! Monkey gets his BANANA");
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
            if (state.pickup()) {
                state.hasStick = true;
                System.out.println("Monkey picked up the Stick");
                return true;
            } else {
                return false;
            }
        } else if (obj == 3) {
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
                if (state.climbChair()) {
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
                        return false;
                    }
                }
            } else if (state.hasStick && !state.hasChair) {
                state.useStick();
                state.pushChair();
                return false;

            } else if (!state.hasStick && !state.hasChair) {
                state.useStick();
                state.pushChair();
                return false;
            }
        }
        return true;
    }
}
