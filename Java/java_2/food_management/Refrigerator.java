/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food_management;

import java.io.IOException;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Refrigerator {

    public static void main(String[] args) throws IOException, InterruptedException {
        //Menu lua chon
        I_Menu menu = new Menu();
        menu.addItems("Welcome to Food Management - @ 2021 by <SE150440 - Tran Duy Ngoc Bao >");
        menu.addItems("Select the options below:");
        menu.addItems("1. Add a new food");
        menu.addItems("2. Search a food by name");
        menu.addItems("3. Remove the food by ID");
        menu.addItems("4. Print the food list in the descending order of expired date");
        menu.addItems("5. Quit");

        //Choice
        int choice;
        I_List list = new FoodList();
        do {
            System.out.println("**********************************************************************************");
            menu.showMenu();
            System.out.println("");
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    do {
                        System.out.println("");
                        list.add();
                        System.out.println("");
                    } while (Utils.repeatQuiz("Press 1 to continue or 2 to get back menu: "));
                    break;
                case 2:
                   do {
                        list.searchByName();
                        System.out.println("");
                    } while (Utils.repeatQuiz("Press 1 to continue or 2 to get back menu: "));
                   break;
                case 3:
                    do {
                        list.removeByID();
                        System.out.println("");
                    } while (Utils.repeatQuiz("Press 1 to continue or 2 to get back menu: "));
                   break;
                case 4:
                    System.out.println("Food Management:");
                    list.printFoodList();
                    break;
                case 5:
                    choice = 6;
                    String file = "SE150440_BaoTDN_Prj01.dat";
                    list.writeBinaryFile(file);
                    list.readBinaryFile(file);
                    System.out.println("\nSAVE TO BINARY FILE and QUIT");
                    break;
            }
        } while (choice < 6);
    }
}
