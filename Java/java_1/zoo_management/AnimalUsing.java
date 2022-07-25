/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
    Document   : admin
    Created on : July 11, 2021, 3:00:00 PM
    Author     : hd
 */
package animal.v1;

/**
 *
 * @author hd
 */
public class AnimalUsing {

    public static void main(String[] args) {
        System.out.println("Animal V1.");
        // your code here
        I_Menu menu = new Menu();
        menu.addItem("1. Add 0-legged animal");
        menu.addItem("2. Add 2-legged animal");
        menu.addItem("3. Update animal");
        menu.addItem("4. Delete animal");
        menu.addItem("5. Search animal by Name");
        menu.addItem("6. Search animal by Type");
        menu.addItem("7. Show all");
        menu.addItem("Others: Quit");
        AnimalsList list = new AnimalsList();
        int choice;
        do {
            menu.showMenu();
            choice = menu.getChoice();
            Animals cd;
            int index;
            String id;
            switch (choice) {
                case 1:
                    cd = new No_Legged();
                    cd.inputAnimal();
                    index = list.indexOf(cd);
                    if (index == -1) {
                        list.add(cd);
                        System.out.println("Success");
                    } else {
                        System.out.println("Duplicate");
                    }
                    break;
                case 2:
                    cd = new Two_Legged();
                    cd.inputAnimal();
                    index = list.indexOf(cd);
                    if (index == -1) {
                        list.add(cd);
                        System.out.println("Success");
                    } else {
                        System.out.println("Duplicate");
                    }
                    break;
                case 3:
                    id = Utils.getStr("Update Name: ");
                    index = list.indexOf(new No_Legged(id));
                    if (index > -1) {
                        cd = list.get(index);
                        cd.updating();
                        list.set(index, cd);
                        System.out.println("Updated!");
                    } else {
                        System.out.println("Not found");
                    }
                    break;
                case 4:
                    id = Utils.getStr("Remove Name: ");
                    index = list.indexOf(new No_Legged(id));
                    if (index > -1) {
                        list.remove(index);
                        System.out.println("Removed!");
                    } else {
                        System.out.println("Not found");
                    }
                    break;
                case 5:
                    id = Utils.getStr("Search Name: ");
                    index = list.indexOf(new No_Legged(id));
                    if (index > -1) {
                        System.out.println("Found:\n" + list.get(index).toString());
                    } else {
                        System.out.println("Not found");
                    }
                    break;
                case 6:
                    int type = Utils.getNumber("Type(\"0\" or \"2\"): ");
                    if(type == 0){
                        System.out.println("No-legged: ");
                        list.showNoLeg();
                    }else if(type == 2){
                        System.out.println("Two-legged: ");
                        list.showTwoLeg();
                    }else System.out.println("No type found");
                    break;
                case 7:
                    System.out.println("Animals: ");
                    list.showAll();
                    break;
            }
        } while (choice >= 0 && choice <= 7);
    }
}
