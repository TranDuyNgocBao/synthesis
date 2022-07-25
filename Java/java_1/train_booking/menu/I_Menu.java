/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

/**
 *
 * @author ADMIN
 */
public interface I_Menu {
    void train_list();
    void customer_list();
    void booking_list();
    void menu_list();
    int getChoice(int from, int end);
}
