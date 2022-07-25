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
public interface I_Menu {
    void addItem(String str);
    void showMenu();
    int getChoice();
}
