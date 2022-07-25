/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food_management;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class FoodList extends ArrayList<FoodManagement> implements I_List {

    ID_list idList = new ID_list();

    @Override
    public void add() {
        boolean check = true;
        do {
            String check_id = Utils.getString("ID: ");
            Food fd = new Food();
            if (idList.isEmpty()) {
                idList.add(check_id);
                fd.setId(check_id);
                fd.addFood();
                this.add(fd);
                check = false;
            } else {
                boolean repeat = false;
                for (String string : idList) {
                    if (string.equalsIgnoreCase(check_id)) {
                        System.out.println("Duplicated ID, try again");
                        repeat = true;
                        break;
                    }
                }
                if (!repeat) {
                    idList.add(check_id);
                    fd.setId(check_id);
                    fd.addFood();
                    this.add(fd);
                    check = false;
                }
            }
        } while (check);
    }

    @Override
    public void searchByName() {
        System.out.println("");
        String name = Utils.getString("Search by Name: ");
        int i = 0;
        for (FoodManagement food : this) {
            if (food.getType().equalsIgnoreCase(name)) {
                System.out.println("Found:" + food.toString());
                i++;
            }
        }
        if (i == 0) {
            for (FoodManagement food : this) {
            if (food.getName().equalsIgnoreCase(name)) {
                System.out.println("Found:" + food.toString());
                i++;
            }
        }
        }
        if (i == 0) {
            System.out.println("Cannot find name of food");
        }
    }

    @Override
    public void removeByID() {
        System.out.println("");
        String id = Utils.getString("Remove by ID: ");
        int index = this.indexOf(new Food(id));
        if (index > -1) {
            if (Utils.repeatQuiz("Are you sure to remove this ID(1.Yes or 2.No)?")) {
                this.remove(index);
                idList.remove(id);
                System.out.println("Removed");
            } else {
                System.out.println("Continue");
            }
        } else {
            System.out.println("Cannot find that name");
        }
    }

    @Override
    public void printFoodList() {
        Collections.sort(this);
        for (FoodManagement food : this) {
            System.out.println(food.toString());
        }
    }
    
    @Override
    public void writeBinaryFile(String fileURL) throws IOException{
        Utils.writeDatFile(fileURL, this);
    }

    @Override
    public void readBinaryFile(String fileURL) {
        try {
            Utils.readDatFile(fileURL);
        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }

}
