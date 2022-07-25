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
public class Vaccine_List {

    static String fileVaccine = "vaccine.dat";
    static Map<String, String> vclist = new HashMap<String, String>();

    public static void writeVaccine() throws FileNotFoundException, IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(fileVaccine);
            oos = new ObjectOutputStream(fos);

            List<Vaccine> list = new ArrayList<>();
            list.add(new Vaccine("Covid-001", "AstraZeneca"));
            list.add(new Vaccine("Covid-002", "SPUTNIK V"));
            list.add(new Vaccine("Covid-003", "Vero Cell"));
            list.add(new Vaccine("Covid-004", "Pfizer"));
            list.add(new Vaccine("Covid-005", "Moderna"));
            for (Vaccine vc : list) {
                oos.writeObject(vc);
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
    
    public static void readVaccine() throws FileNotFoundException, IOException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(fileVaccine);
            ois = new ObjectInputStream(fis);
            
            while(fis.available()>0){
                String tmp = ois.readObject().toString();
                String key, value;
                key = tmp.substring(0, tmp.indexOf(","));
                value = tmp.substring(tmp.indexOf(",")+1);
                vclist.put(key, value);
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
