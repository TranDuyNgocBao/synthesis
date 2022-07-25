/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_6;

/**
 *
 * @author ADMIN
 */
public class UsingList {

    public static void main(String[] args) {
        int choice;
        ItemList il = new ItemList();
        do {
            Utils.menu();

            System.out.print("Choice: ");
            choice = Utils.getNumber();
            switch (choice) {
                case 1:
                    Item vs = new Vase();
                    System.out.println("Vase");
                    vs.input();
                    boolean rs1 = il.addItem(vs);
                    if (rs1) {
                        System.out.println("Added successfully");
                    } else {
                        System.out.println("Fails");
                    }
                    break;
                case 2:
                    Item st = new Statue();
                    System.out.println("Statue");
                    st.input();
                    boolean rs2 = il.addItem(st);
                    if (rs2) {
                        System.out.println("Added successfully");
                    } else {
                        System.out.println("Fails");
                    }
                    break;
                case 3:
                    Item pt = new Painting();
                    System.out.println("Painting");
                    pt.input();
                    boolean rs3 = il.addItem(pt);
                    if (rs3) {
                        System.out.println("Added successfully");
                    } else {
                        System.out.println("Fails");
                    }
                    break;
                case 4:
                    il.displayAll();
                    break;
                case 5:
                    System.out.print("Input Creator to find: ");
                    String cr = Utils.getStr();
                    il.findItem(cr).output();
                    break;
                case 6:
                    System.out.print("Input Index to update: ");
                    boolean rs6 = il.updateItem(Utils.getNumber());
                    if (rs6) {
                        System.out.println("Updated successfully");
                    } else {
                        System.out.println("Fails");
                    }
                    break;
                case 7:
                    System.out.print("Input index to remove: ");
                    boolean rs7 = il.removeItem(Utils.getNumber());
                    if (rs7) {
                        System.out.println("Removed successfully");
                    } else {
                        System.out.println("Fails");
                    }
                    break;
                case 8:
                    System.out.println("Value of List is sorted");
                    il.sortItem();
                    break;
                case 9:
                    System.out.println("EXIT");
                    break;
                default:
                    System.out.println("Press wrong functional button");
                    break;
            }
        } while (choice != 9);
    }
}
