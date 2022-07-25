/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid19_vaccine_management;

import data_structure.Hospital;
import data_structure.Injection;
import data_structure.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class Operation_List extends ArrayList<Hospital> implements I_operation_list {

    @Override
    public void addin() {
        Hospital inject = new Injection();
        Utils.duplicate = false;
        inject.add_item();
        if (!Utils.duplicate) {
            this.add((Injection)inject);
        }
    }

    @Override
    public void updatenew() {
        String injectionID = Utils.getString("Enter Injection ID for updating: ");
        int index = 0;
        for (Hospital inj : this) {
            if (((Injection) inj).getInjection_id().equalsIgnoreCase(injectionID)) {
                ((Injection) inj).update_item();
                System.out.println("Updated succesfully");
                break;
            } else {
                index++;
            }
        }
        if (index >= this.size()) {
            System.out.println("Cannot find Injection ID");
        }
    }

    @Override
    public void showAll() {
        System.out.println("Student ID  |Student   |Vaccine ID   |Vaccine   |Injection ID   |1st Injection Place   |1st Injection Date   |2nd Injection Place   |2nd Injection Date   |Vaccination confirmation");
        System.out.println("");
        this.forEach(aThi -> {
            System.out.println(aThi.toString());
            System.out.println("");
        });
    }

    @Override
    public void deleteold() {
        String injectionID = Utils.getString("Enter Injection ID for Deleting: ");
        int index = 0;
        for (Hospital inj : this) {
            if (((Injection) inj).getInjection_id().equalsIgnoreCase(injectionID)) {
                break;
            } else {
                index++;
            }
        }
        if (index >= this.size()) {
            System.out.println("Cannot find Injection ID");
        } else {
            if (Utils.repeatQuiz("Do you really want to delete (1-Yes/2-No)?: ")) {
                Utils.ijt_id.remove(index);
                Utils.st_id.remove(index);
                this.remove(index);
                System.out.println("Deleting Successfully");
            } else {
                System.out.println("Deleting Fail");
            }
        }
    }

    @Override
    public void searchfor() {
        if (Utils.repeatQuiz("Press 1. Search by Student ID\nPress 2. Search by Student Name")) {
            String studentID = Utils.getString("Enter Student ID for Searching: ");
            for (Hospital inj : this) {
                if (((Injection) inj).student_id.equalsIgnoreCase(studentID)) {
                    System.out.println(inj.toString());
                    return;
                }
            }
            System.out.println("Cannot find Student ID");
        } else {
            String studentName = Utils.getString("Enter Student Name for Searching: ");
            studentName = studentName.toUpperCase();
            int ch = 0;
            for (Hospital std : this) {
                if (((Injection) std).student.contains(studentName)) {
                    System.out.println(std.toString());
                    ch++;
                }
            }
            if (ch == 0) {
                System.out.println("Cannot find Student Name");
            }
        }
    }

    @Override
    public void readInject() {

        FileReader fr = null;
        try {
            File f = new File(Utils.fileInjection);
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            //Injection inj = new Injection();
            this.clear();
            Utils.ijt_id.clear();
            Utils.st_id.clear();
            try {
                System.out.println("Student ID  |Student   |Vaccine ID   |Vaccine   |Injection ID   |1st Injection Place   |1st Injection Date   |2nd Injection Place   |2nd Injection Date   |Vaccination confirmation");
                System.out.println("");
                String line = "";
                while ((line = br.readLine()) != null) {
                    Injection inj = new Injection();
                    System.out.println(line);
                    System.out.println("");
                    line = line.trim();
                    line = line.replaceAll("\t", ",");
                    line = line + ',';
                    char[] arr = line.toCharArray();
                    int count = 0;
                    String sub = "";
                    for (int i = 0; i < arr.length; i++) {
                        while (arr[i] != ',' && arr[i] != '|') {
                            sub += arr[i];
                            i++;
                            continue;
                        }
                        count++;
                        sub = sub.trim();
                        switch (count) {
                            case 1:
                                inj.student_id = sub;
                                Utils.st_id.add(sub);
                                sub = "";
                                break;
                            case 2:
                                inj.student = sub;
                                sub = "";
                                break;
                            case 3:
                                inj.vaccine_id = sub;
                                sub = "";
                                break;
                            case 4:
                                inj.vaccine = sub;
                                sub = "";
                                break;
                            case 5:
                                inj.setInjection_id(sub);
                                Utils.ijt_id.add(sub);
                                sub = "";
                                break;
                            case 6:
                                inj.setIjt_place1(sub);
                                sub = "";
                                break;
                            case 7:
                                inj.setIjt_date1(sub);
                                sub = "";
                                break;
                            case 8:
                                inj.setIjt_place2(sub);
                                sub = "";
                                break;
                            case 9:
                                inj.setIjt_date2(sub);
                                sub = "";
                                break;
                            case 10:
                                inj.setAuthentication(sub);
                                sub = "";
                                break;
                        }
                        while (arr[i] == ',' || arr[i] == '|') {
                            if (i < arr.length - 1) {
                                i++;
                            } else {
                                break;
                            }
                            continue;
                        }
                        if (i < arr.length - 1) {
                            i--;
                        }
                    }
                    this.add(inj);

                }
            } catch (Exception e) {
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Operation_List.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (fr != null) {
                    try {
                        fr.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Operation_List.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Operation_List.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(Operation_List.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void writeInject() {
        FileWriter fw = null;
        try {
            File f = new File(Utils.fileInjection);
            fw = new FileWriter(f);
            try {
                List<Injection> list = new ArrayList<>();
                this.forEach(inj -> {
                    list.add((Injection) inj);
                });

                for (Injection inj : list) {
                    fw.write(inj.toString());
                    fw.write("\n");
                }
            } catch (IOException e) {
            } finally {
                if (fw != null) {
                    try {
                        fw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Operation_List.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Operation_List.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Operation_List.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void infoEncrypt() {
        FileWriter fw = null;
        try {
            File f = new File(Utils.encryptInjection);
            fw = new FileWriter(f);
            try {
                List<Injection> list = new ArrayList<>();
                this.forEach(inj -> {
                    list.add((Injection) inj);
                });

                for (Injection inj : list) {
                    String text = inj.toString();
                    byte [] md5InBytes = Utils.digest(text.getBytes(Utils.UTF_8));
                    text = Utils.bytesToHex(md5InBytes);
                    fw.write(text);
                    fw.write("\n");
                }
            } catch (IOException e) {
            } finally {
                if (fw != null) {
                    try {
                        fw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Operation_List.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Operation_List.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Operation_List.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}























//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
//        try {
//            fis = new FileInputStream(Utils.fileInjection);
//            ois = new ObjectInputStream(fis);
//
//            System.out.println("Student ID  |Student   |Vaccine ID   |Vaccine   |Injection ID   |1st Injection Place   |1st Injection Date   |2nd Injection Place   |2nd Injection Date   |Vaccination confirmation");
//            System.out.println("");
//            while (fis.available() > 0) {
//                String tmp = ois.readUTF();
//                System.out.println(tmp);
//                System.out.println("");
//                tmp = tmp.trim();
//                tmp = tmp.replaceAll("\t", ",");
//                tmp = tmp + ',';
//                char[] arr = tmp.toCharArray();
//                int count = 0;
//                String sub = "";
//                for (int i = 0; i < arr.length; i++) {
//                    while (arr[i] != ',' && arr[i] != '|') {
//                        sub += arr[i];
//                        i++;
//                        continue;
//                    }
//                    count++;
//                    sub = sub.trim();
//                    switch (count) {
//                        case 1:
//                            inj.student_id = sub;
//                            Utils.st_id.add(sub);
//                            sub = "";
//                            break;
//                        case 2:
//                            inj.student = sub;
//                            sub = "";
//                            break;
//                        case 3:
//                            inj.vaccine_id = sub;
//                            sub = "";
//                            break;
//                        case 4:
//                            inj.vaccine = sub;
//                            sub = "";
//                            break;
//                        case 5:
//                            inj.setInjection_id(sub);
//                            Utils.ijt_id.add(sub);
//                            sub = "";
//                            break;
//                        case 6:
//                            inj.setIjt_place1(sub);
//                            sub = "";
//                            break;
//                        case 7:
//                            inj.setIjt_date1(sub);
//                            sub = "";
//                            break;
//                        case 8:
//                            inj.setIjt_place2(sub);
//                            sub = "";
//                            break;
//                        case 9:
//                            inj.setIjt_date2(sub);
//                            sub = "";
//                            break;
//                        case 10:
//                            inj.setAuthentication(sub);
//                            sub = "";
//                            break;
//                    }
//                    while (arr[i] == ',' || arr[i] == '|') {
//                        if (i < arr.length - 1) {
//                            i++;
//                        } else {
//                            break;
//                        }
//                        continue;
//                    }
//                    if (i < arr.length - 1) {
//                        i--;
//                    }
//                }
//                this.add(inj);
//            }
//
//        } catch (IOException e) {
//        } finally {
//            if (ois != null) {
//                try {
//                    ois.close();
//                } catch (IOException ex) {
//                    Logger.getLogger(Operation_List.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if (fis != null) {
//                try {
//                    fis.close();
//                } catch (IOException ex) {
//                    Logger.getLogger(Operation_List.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        try {
//            fos = new FileOutputStream(Utils.fileInjection);
//            oos = new ObjectOutputStream(fos);
//
//            
//            List<Injection> list = new ArrayList<>();
//            this.forEach(inj -> {
//                list.add((Injection) inj);
//            });
//
//            for (Injection inj : list) {
//                oos.writeUTF(inj.toString());
//                oos.flush();
//            }
//        } catch (IOException e) {
//        } finally {
//            if (oos != null) {
//                try {
//                    oos.close();
//                } catch (IOException ex) {
//                    System.out.println("false");
//                }
//            }
//            if (fos != null) {
//                try {
//                    fos.close();
//                } catch (IOException ex) {
//                    System.out.println("false");
//                }
//            }
