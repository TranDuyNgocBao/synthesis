/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid19_vaccine_management;

import data_structure.Hospital;
import data_structure.Injection;
import data_structure.Student_List;
import data_structure.Utils;
import data_structure.Vaccine_List;
import java.io.IOException;
import menu_list.I_Menu;
import menu_list.Menu;

/**
 *
 * @author ADMIN
 */
public class Vaccine_management {
    public static void main(String[] args) throws IOException {
        I_Menu menu = new Menu();
        menu.addItems("Managing the vaccination process of FPT university students".toUpperCase());
        menu.addItems("1. Show information all students have been injected");
        menu.addItems("2. Add student's vaccine injection information");
        menu.addItems("3. Updating information of students' vaccine injection");
        menu.addItems("4. Delete student vaccine injection information");
        menu.addItems("5. Search for injection information by studentID or by student name");
        menu.addItems("6. Store data to file");
        menu.addItems("7. Information Encryption");
        menu.addItems("Others except 0 to Quit");
        
        Student_List.writeStudent();
        Student_List.readStudent();
        Vaccine_List.writeVaccine();
        Vaccine_List.readVaccine();
        
//        Hospital thi = new Injection();
//        thi.add_item();

        int choice = 0;
        boolean check;
        I_operation_list op = new Operation_List();
        do{
            menu.showMenu();
            choice = menu.getChoice();
            switch(choice){
                case 1:
                    op.readInject();
                    break;
                case 2:
                    check = true;
                    do{
                        op.addin();
                        check = Utils.repeatQuiz("Do you want to continue or back to menu?(1:Yes / 2:No)");
                        op.writeInject();
                    }while(check);
                    break;
                case 3:
                    op.updatenew();
                    op.writeInject();
                    break;
                case 4:
                    op.deleteold();
                    op.writeInject();
                    break;
                case 5:
                    op.searchfor();
                    break;
                case 6:
                    op.showAll();
                    op.writeInject();
                    System.out.println("Write File successfully");
                    break;
                case 7:
                    op.infoEncrypt();
                    System.out.println("Encrypting successfully, open file \"injection_encrypt.txt\" to see result");
                    break;
                    
                default:
                    op.showAll();
                    System.out.println("QUIT");
                    break;
            }
        }while(choice>=0 && choice<=7);
    }
}
