/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import station.Utils;

/**
 *
 * @author ADMIN
 */
public class Menu implements I_Menu {

    @Override
    public void train_list() {
        System.out.println("1.  Load data from file");
        System.out.println("2.  Input and add to the head");
        System.out.println("3.  Display data");
        System.out.println("4.  Save train list to file");
        System.out.println("5.  Search by tcode");
        System.out.println("6.  Delete by tcode");
        System.out.println("7.  Sort by tcode");
        System.out.println("8.  Add after position k");
        System.out.println("9.  Delete the node before the node having tcode = xCode");
        System.out.println("10. Back to Gas Station");
    }

    @Override
    public void customer_list() {
        System.out.println("1. Load data from file");
        System.out.println("2. Input and add to the end");
        System.out.println("3. Display data");
        System.out.println("4. Save customer list to file");
        System.out.println("5. Search by ccode");
        System.out.println("6. Delete by ccode");
        System.out.println("7. Back to Gas Station");
    }

    @Override
    public void booking_list() {
        System.out.println("1. Input data");
        System.out.println("2. Display data width available seats");
        System.out.println("3. Sort by tcode + ccode");
        System.out.println("4. Back to Gas Station");
    }

    @Override
    public void menu_list() {
        System.out.println("WELCOME TO GAS STATION");
        System.out.println("1. Train List");
        System.out.println("2. Customer List");
        System.out.println("3. Booking List");
        System.out.println("4. Quit");
    }

    @Override
    public int getChoice(int from, int end) {
        int choice = 0;
        do{
            choice = Utils.getNumber("Choice from " + from + " to " + end + ": ");
        }while(choice < from || choice > end);
        return choice;
    }

}
