/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monkey_banana;

import interfere.Utils;
import menu_list.I_Menu;
import menu_list.Menu;
import snake_game.GameFrame;
import users.BotPlay;
import users.UserPlay;
import users.UserWithInstruction;

/**
 *
 * @author ADMIN
 */
public class Findway {

    public static void main(String[] args) throws InterruptedException {
        I_Menu menu = new Menu();
        menu.addItems("Welcome to MONKEY and BANANA");
        menu.addItems("GAME START");
        menu.addItems("1. Play");
        menu.addItems("2. Play with Instruction");
        menu.addItems("3. Bot Play");
        menu.addItems("4. Graphic Model");

//        menu.showMenu();
//        int choice = menu.getChoice();
        switch (4) {
            case 1:
                UserPlay.userPlay(Utils.getArray());
                break;
            case 2:
                UserWithInstruction.userPlaywithIns(Utils.getArray());
                break;
            case 3:
                BotPlay.botplay(Utils.getArray());
                break;
            case 4:
                new GameFrame();
                break;
        }
    }
}
