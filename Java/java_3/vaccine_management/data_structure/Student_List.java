/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public class Student_List {

    static String fileStudent = "student.dat";
    static Map<String, String> stlist = new HashMap<String, String>();

    public static void writeStudent() throws FileNotFoundException, IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(fileStudent);
            oos = new ObjectOutputStream(fos);
            
            List<Student> list = new ArrayList<>();
            list.add(new Student("Se150000", "Nguyen Van A"));
            list.add(new Student("Se150001", "Tran Linh B"));
            list.add(new Student("Se150002", "Ho Hoai C"));
            list.add(new Student("Se150003", "Le Van D"));
            list.add(new Student("Se150004", "Dinh Hong E"));
            list.add(new Student("Se150005", "Tran Thi A"));
            list.add(new Student("Se150006", "Ho Hoai C"));
            list.add(new Student("Se150007", "Vu Quoc F"));
            list.add(new Student("Se150008", "Ly Thien G"));
            list.add(new Student("Se150009", "Hoang Van T"));
            
            for (Student st : list) {
                oos.writeObject(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                oos.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }

    public static void readStudent() throws FileNotFoundException, IOException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(fileStudent);
            ois = new ObjectInputStream(fis);
            
            while(fis.available()>0){
                String tmp = ois.readObject().toString();
                String key, value;
                key = tmp.substring(0, tmp.indexOf(","));
                value = tmp.substring(tmp.indexOf(",")+1);
                stlist.put(key, value);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                ois.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
    }
}
