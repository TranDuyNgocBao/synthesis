/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import algorithm.MonkeyBananaSolution;
import interfere.State;
import interfere.Utils;

/**
 *
 * @author ADMIN
 */
public class BotPlay {

    static CurrentPos monkey_pos = new CurrentPos();

    static public void botplay(int[][] a) throws InterruptedException {
        // Khởi tạo
        MonkeyBananaSolution mbs = new MonkeyBananaSolution(a);
        Utils.createMap();
        System.out.println("Room:");
        mbs.showMap();
        monkey_pos.positionNode = mbs.get_position(1);
        monkey_pos.type = 1;
        State sta = new State();
        int step = 0;

        do {
            Utils.delay_output();
            if (!sta.hasBanana && !sta.hasStick && !sta.hasChair) {
                System.out.print((step++) + ": ");
                System.out.println("Monkey has two empty hands");
                // kiểm tra đường đi ngắn nhất
                if (mbs.shortestDis(1, 2) + mbs.shortestDis(2, 3) + mbs.shortestDis(3, 4) 
                        <= mbs.shortestDis(1, 3) + mbs.shortestDis(3, 2) + mbs.shortestDis(2, 4)) {
                    System.out.print((step++) + ": ");
                    mbs.fastWay(monkey_pos.type, 2);
                    mbs.replace_type(monkey_pos.positionNode, 0);
                    mbs.replace_type(mbs.get_position(2), 1);
                    monkey_pos.positionNode = mbs.get_position(1);
                    mbs.showMap();

                    if (sta.pickup(true)) {
                        System.out.print((step++) + ": ");
                        System.out.println("Monkey picked up the Stick");
                        sta.hasStick = true;
                    }
                } else {
                    System.out.print((step++) + ": ");
                    mbs.fastWay(monkey_pos.type, 3);
                    mbs.replace_type(monkey_pos.positionNode, 0);
                    mbs.replace_type(mbs.get_position(3), 1);
                    monkey_pos.positionNode = mbs.get_position(1);
                    mbs.showMap();
                    sta.hasChair = true;

                    if (sta.pushChair(true)) {
                        System.out.print((step++) + ": ");
                        System.out.println("Monkey pushed the Chair");
                    }
                }
            } else if (!sta.hasBanana && !sta.hasStick) {
                System.out.println("\nMonkey has Chair and goes to get Stick");
                System.out.print((step++) + ": ");
                mbs.fastWay(monkey_pos.type, 2);
                mbs.replace_type(monkey_pos.positionNode, 0);
                mbs.replace_type(mbs.get_position(2), 1);
                monkey_pos.positionNode = mbs.get_position(1);
                mbs.showMap();

                if (sta.pickup(true)) {
                    System.out.print((step++) + ": ");
                    System.out.println("Monkey picked up the Stick");
                    sta.hasStick = true;
                }
            } else if (!sta.hasBanana && !sta.hasChair) {
                System.out.println("\nMonkey has Stick and goes to get Chair");
                System.out.print((step++) + ": ");
                mbs.fastWay(monkey_pos.type, 3);
                mbs.replace_type(monkey_pos.positionNode, 0);
                mbs.replace_type(mbs.get_position(3), 1);
                monkey_pos.positionNode = mbs.get_position(1);
                mbs.showMap();
                sta.hasChair = true;

                if (sta.pushChair(true)) {
                    System.out.print((step++) + ": ");
                    System.out.println("Monkey pushed the Chair");
                }
            } else if (!sta.hasBanana) {
                System.out.println("\nMonkey has chair and stick, monkey goes to get Banana");
                if (sta.isPush()) {
                    System.out.print((step++) + ": ");
                    mbs.fastWay(monkey_pos.type, 4);
                    mbs.replace_type(monkey_pos.positionNode, 0);
                    mbs.replace_type(mbs.get_position(4), 1);
                    monkey_pos.positionNode = mbs.get_position(1);
                    mbs.showMap();
                    
                    if(!sta.isClimb()){
                        if(sta.climbChair(true)){
                            System.out.print((step++) + ": ");
                            System.out.println("Monkey climbed the Chair");
                        }
                    }
                    
                    System.out.print((step++) + ": ");
                    if(sta.useStick(true)){
                        sta.hasBanana = true;
                    }
                }
            }
            
            if(sta.hasBanana){
                System.out.println();
                Utils.delay_output();
                System.out.println("Monket got his BANANA");
                System.out.println("Congratulation");
                break;
            }
        } while (true);
    }
}
