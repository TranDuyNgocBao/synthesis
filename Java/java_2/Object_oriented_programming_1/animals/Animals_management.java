/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animals;

/**
 *
 * @author ADMIN
 */
public class Animals_management {

    public static void main(String[] args) {
        I_Menu menu = new Menu();
        menu.addItems("1. Add animals in group of 0-legged");
        menu.addItems("2. Add animals in group of 2-legged");
        menu.addItems("3. Update animals by ID");
        menu.addItems("4. Delete animals by ID");
        menu.addItems("5. Search by Name");
        menu.addItems("6. Show by Type");
        menu.addItems("7. Show all");

        int choice;
        I_List list = new AnimalsList();
        do {
            menu.showMenu();
            System.out.println("");
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    list.add(0);
                    break;
                case 2:
                    list.add(2);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Quit!");
                    break;
            }
        }while((choice>=1) &&(choice<=7));
    }
}
