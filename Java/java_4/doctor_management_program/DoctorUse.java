/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor_management_program;

/**
 *
 * @author ADMIN
 */
public class DoctorUse {
    public static void main(String[] args) {
        I_Menu menu = new Menu();
        menu.addItem("1. Add new doctor");
        menu.addItem("2. Update a doctor");
        menu.addItem("3. Remove a doctor");
        menu.addItem("4. Search a doctor");
        menu.addItem("5. Output");
        menu.addItem("Others: Quit");
        int choice;
        I_List list = new DoctorList();
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    list.add();
                    break;
                case 2:
                    list.update();
                    break;
                case 3:
                    list.delete();
                    break;
                case 4:
                    list.search();
                    break;
                case 5:
                    list.output();
                    break;
            }
        } while (choice >= 0 && choice <= 5);
    }
}
