/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package train_booking_system;

import menu.I_Menu;
import menu.Menu;
import java.io.IOException;

/**
 *
 * @author ADMIN
 */
public class Management {
    public static void main(String[] args) throws IOException {
        I_Menu menu = new Menu();
        int choice;
        do {
            System.out.println("");
            menu.menu_list();
            choice = menu.getChoice(1, 4);
            if(choice == 1)Lists.trainlist();
            if(choice == 2)Lists.customerList();
            if(choice == 3)Lists.bookingList();
            if(choice == 4)System.out.println("QUIT");
        } while (choice != 4);
    }
}
