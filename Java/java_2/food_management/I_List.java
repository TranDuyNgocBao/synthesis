/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food_management;

import java.io.IOException;

/**
 *
 * @author ADMIN
 */
public interface I_List {
    void add();
    void searchByName();
    void removeByID();
    void printFoodList();
    void writeBinaryFile(String fileURL)throws IOException;
    void readBinaryFile(String fileURL);
}
