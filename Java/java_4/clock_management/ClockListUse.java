    package clock.management;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hoa Doan
 */
public class ClockListUse {

    public static void main(String args[]) {
        I_Menu menu = new Menu();
        menu.addItem("1. Add new clock");
        menu.addItem("2. Remove a clock");
        menu.addItem("3. Update a clock");
        menu.addItem("4. Sort list and Output");
        menu.addItem("Others: Quit");
        int choice;
        I_List list = new ClockList();
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    list.add();
                    break;
                case 2:
                    list.remove();
                    break;
                case 3:
                    list.update();
                    break;
                case 4:
                    list.sort();
                    list.output();
                    break;
            }
        } while (choice >= 0 && choice <= 4);
    }
}
