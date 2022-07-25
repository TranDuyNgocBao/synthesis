/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package train_booking_system;

import station.Booking;
import station.Utils;
import station.Customer;
import station.Train;
import station.Gas_station;
import menu.I_Menu;
import menu.Menu;
import linked_list.LinkedListWritten;
import linked_list.Node;        

import linked_list.LinkedListWritten;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Lists {

    static ArrayList<String> tcodeList = new ArrayList<>();
    static ArrayList<String> ccodeList = new ArrayList<>();

    static LinkedListWritten<Train> llw = new LinkedListWritten<>();
    static LinkedListWritten<Customer> llc = new LinkedListWritten<>();
    static LinkedListWritten<Booking> llb = new LinkedListWritten<>();

    static String fileURL = "SE150440_BaoTDN_TrainList.txt";
    static String fileCus = "SE150440_BaoTDN_CustomerList.txt";

    static I_Menu menu = new Menu();

    public static void trainlist() throws IOException {
        int choice;
        boolean inFile_check = false;
        Gas_station tr = new Train();
        boolean check;
        int pos;

        do {
            System.out.println("");
            menu.train_list();
            choice = menu.getChoice(1, 10);

            switch (choice) {
                case 1:
                    if (!llw.isEmpty()) {
                        int ask;
                        do {
                            ask = Utils.getNumber("Do you want to keep old list or not(1-Yes || 2-No)? ");
                            if (ask == 1) {
                                break;
                            }
                            if (ask == 2) {
                                llw.clear();
                            }
                        } while (ask != 1 && ask != 2);
                    }
                    BufferedReader br = null;
                    try {
                        String line;
                        br = new BufferedReader(new FileReader(fileURL));
                        int linecount = 0;
                        while ((line = br.readLine()) != null) {
                            Train train = new Train();
                            if (++linecount < 3) {
                                continue;
                            }
                            line = line.replaceAll(" ", "");
                            line = line.replaceAll("\t", "");
                            line = line.replaceAll("\n", "");
                            int count = 0;
                            for (int i = 0; i < line.length(); i++) {
                                String tmp = "";
                                while (line.charAt(i) != '|') {
                                    tmp += line.charAt(i);
                                    if (i == line.length() - 1) {
                                        break;
                                    }
                                    i++;
                                }
                                count++;
                                switch (count) {
                                    case 1:
                                        train.tcode = tmp;
                                        check = true;
                                        if (!tcodeList.isEmpty()) {
                                            for (int j = 0; j < tcodeList.size(); j++) {
                                                String get = tcodeList.get(j);
                                                if (get.equals(tmp)) {
                                                    check = false;
                                                    break;
                                                }
                                            }
                                        }
                                        if (check) {
                                            tcodeList.add(tmp);
                                        } else {
                                            count = 8;
                                        }
                                        break;
                                    case 2:
                                        train.setTrain_name(tmp);
                                        break;
                                    case 3:
                                        train.setSeat(Integer.parseInt(tmp));
                                        break;
                                    case 4:
                                        train.booked = Integer.parseInt(tmp);
                                        break;
                                    case 5:
                                        train.setDepart_time(Double.parseDouble(tmp));
                                        break;
                                    case 6:
                                        train.setDepart_place(tmp);
                                        break;
                                    case 7:
                                        train.avai_seat = train.getSeat() - train.booked;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            if (count == 6) {
                                train.avai_seat = train.getSeat() - train.booked;
                            }
                            if (count <= 7) {
                                llw.addLast(train);
                            }
                        }
                    } catch (IOException e) {

                    } finally {
                        System.out.println("Loading completed");
                        if (br != null) {
                            br.close();
                        }
                    }
                    break;

                case 2:
                    check = true;
                    do {
                        check = true;
                        String tmp = Utils.getString("Train Code: ").trim();
                        for (int i = 0; i < tcodeList.size(); i++) {
                            String get = tcodeList.get(i);
                            if (get.equals(tmp)) {
                                check = false;
                                break;
                            }
                        }
                        if (check) {
                            tcodeList.add(tmp);
                            tr.tcode = tmp;
                            break;
                        } else {
                            System.out.println("Duplicated, Try again");
                        }
                    } while (true);
                    tr.add();
                    llw.addFirst((Train) tr);
                    System.out.println("Added successfully");
                    break;

                case 3:
                    System.out.println("Tcode\t|\tTrain_name\t|\tSeat\t|\tBooked\t|\tDepart_time\t|\tDepart_place\t|\tAvailable_seat");
                    for (int i = 0; i < 136; i++) {
                        System.out.print("-");
                    }
                    System.out.println("");

                    for (int j = 0; j < llw.size(); j++) {
                        System.out.println(llw.get(j).tostring());
                    }
                    break;

                case 4:
                    File f = new File(fileURL);
                    FileWriter fw = new FileWriter(f);
                    try {
                        String topic = "Tcode\t|\tTrain_name\t|\tSeat\t|\tBooked\t|\tDepart_time\t|\tDepart_place\t|\tAvailable_seat";
                        fw.write(topic);
                        fw.write("\n");

                        String border = "";
                        for (int i = 0; i < 136; i++) {
                            border += "-";
                        }
                        System.out.println("");
                        fw.write(border);
                        fw.write("\n");

                        for (int j = 0; j < llw.size(); j++) {
                            fw.write(llw.get(j).tostring());
                            fw.write("\n");
                        }
                        inFile_check = true;
                    } catch (IOException e) {
                        inFile_check = false;
                    } finally {
                        if (inFile_check) {
                            System.out.println("Write to File successfully");
                        }
                        if (fw != null) {
                            fw.close();
                        }
                    }
                    break;

                case 5:
                    LinkedListWritten<Train> searc = new LinkedListWritten<>();
                    searc.head = llw.search(Utils.getString("Enter xCode: "), 1);
                    if (searc.head == null) {
                        System.out.println("Cannot find");
                    } else {
                        System.out.println(searc.head.info.tostring());
                    }
                    break;

                case 6:
                    llw.dele(Utils.getString("Input tcode you want to delete: "), 1);
                    break;

                case 7:
                    llw.head = llw.mergeSort(llw.head);
                    System.out.println("Sorted successful");
                    break;

                case 8:
                    pos = 0;
                    do {
                        if (pos < 0 || pos > llw.size() - 1) {
                            System.out.println("Out of range, try again!");
                        }
                        pos = Utils.getNumber("Choose position: ");
                    } while (pos < 0 || pos > llw.size() - 1);

                    check = true;
                    do {
                        check = true;
                        String tmp = Utils.getString("Train Code: ").trim();
                        for (int i = 0; i < tcodeList.size(); i++) {
                            String get = tcodeList.get(i);
                            if (get.equals(tmp)) {
                                check = false;
                                break;
                            }
                        }
                        if (check) {
                            tcodeList.add(tmp);
                            tr.tcode = tmp;
                            break;
                        } else {
                            System.out.println("Duplicated, Try again");
                        }
                    } while (true);

                    tr.add();
                    llw.addPos(pos, (Train) tr);
                    break;

                case 9:
                    llw.delexCode(Utils.getString("Input the xCode to delete Note before: "));
                    break;

                case 10:
                    System.out.println("Return Gas Station");
                    break;
            }
        } while (choice != 10);
    }

    public static void customerList() throws IOException {
        int choice;
        boolean check, inFile_check = false;
        Gas_station cus = new Customer();

        do {
            System.out.println("");
            menu.customer_list();
            choice = menu.getChoice(1, 7);

            switch (choice) {
                case 1:
                    if (!llc.isEmpty()) {
                        int ask;
                        do {
                            ask = Utils.getNumber("Do you want to keep old list or not(1-Yes || 2-No)? ");
                            if (ask == 1) {
                                break;
                            }
                            if (ask == 2) {
                                llc.clear();
                            }
                        } while (ask != 1 && ask != 2);
                    }
                    BufferedReader br = null;
                    try {
                        String line;
                        br = new BufferedReader(new FileReader(fileCus));
                        int linecount = 0;
                        while ((line = br.readLine()) != null) {
                            Customer customer = new Customer();
                            if (++linecount < 3) {
                                continue;
                            }
                            line = line.replaceAll(" ", "");
                            line = line.replaceAll("\t", "");
                            line = line.replaceAll("\n", "");
                            int count = 0;
                            for (int i = 0; i < line.length(); i++) {
                                String tmp = "";
                                while (line.charAt(i) != '|') {
                                    tmp += line.charAt(i);
                                    if (i == line.length() - 1) {
                                        break;
                                    }
                                    i++;
                                }
                                count++;
                                switch (count) {
                                    case 1:
                                        customer.ccode = tmp;
                                        check = true;
                                        if (!ccodeList.isEmpty()) {
                                            for (int j = 0; j < ccodeList.size(); j++) {
                                                String get = ccodeList.get(j);
                                                if (get.equals(tmp)) {
                                                    check = false;
                                                    break;
                                                }
                                            }
                                        }
                                        if (check) {
                                            ccodeList.add(tmp);
                                        } else {
                                            count = 4;
                                        }
                                        break;
                                    case 2:
                                        customer.setCus_name(tmp);
                                        break;
                                    case 3:
                                        customer.setPhone(tmp);
                                        break;
                                    default:
                                        break;
                                }
                            }
                            if (count <= 3) {
                                llc.addLast(customer);
                            }
                        }
                    } catch (IOException e) {

                    } finally {
                        System.out.println("Loading completed");
                        if (br != null) {
                            br.close();
                        }
                    }
                    break;

                case 2:
                    check = true;
                    do {
                        check = true;
                        String tmp = Utils.getString("Customer Code: ").trim();
                        for (int i = 0; i < ccodeList.size(); i++) {
                            String get = ccodeList.get(i);
                            if (get.equals(tmp)) {
                                check = false;
                                break;
                            }
                        }
                        if (check) {
                            ccodeList.add(tmp);
                            cus.ccode = tmp;
                            break;
                        } else {
                            System.out.println("Duplicated, Try again");
                        }
                    } while (true);
                    cus.add();
                    llc.addLast((Customer) cus);
                    System.out.println("Added successfully");
                    break;

                case 3:
                    System.out.println("Customer Code\t|\tCustomer name\t|\tPhone Number");
                    for (int i = 0; i < 62; i++) {
                        System.out.print("-");
                    }
                    System.out.println("");

                    for (int j = 0; j < llc.size(); j++) {
                        System.out.println(llc.get(j).tostring());
                    }
                    break;

                case 4:
                    File f = new File(fileCus);
                    FileWriter fw = new FileWriter(f);
                    try {
                        String topic = "Customer Code\t|\tCustomer name\t|\tPhone Number";
                        fw.write(topic);
                        fw.write("\n");

                        String border = "";
                        for (int i = 0; i < 62; i++) {
                            border += "-";
                        }
                        System.out.println("");
                        fw.write(border);
                        fw.write("\n");

                        for (int j = 0; j < llc.size(); j++) {
                            fw.write(llc.get(j).tostring());
                            fw.write("\n");
                        }
                        inFile_check = true;
                    } catch (IOException e) {
                        inFile_check = false;
                    } finally {
                        if (inFile_check) {
                            System.out.println("Write to File successfully");
                        }
                        if (fw != null) {
                            fw.close();
                        }
                    }
                    break;

                case 5:
                    LinkedListWritten<Customer> searc = new LinkedListWritten<>();
                    searc.head = llc.search(Utils.getString("Enter xCode: "), 2);
                    if (searc.head == null) {
                        System.out.println("Cannot find");
                    } else {
                        System.out.println(searc.head.info.tostring());
                    }
                    break;

                case 6:
                    llc.dele(Utils.getString("Input tcode you want to delete: "), 2);
                    break;

                case 7:
                    System.out.println("Return Gas Station");
                    break;
            }
        } while (choice != 7);
    }

    public static void bookingList() {
        int choice;
        boolean check;
        Gas_station booking = new Booking();

        do {
            System.out.println("");
            menu.booking_list();
            choice = menu.getChoice(1, 4);

            switch (choice) {
                case 1:
                    if (llw.isEmpty() || llc.isEmpty()) {
                        System.out.println("Must input train and customer first");
                        return;
                    }
                    check = true;
                    do {
                        String trcode = Utils.getString("Enter train code: ");
                        String cuscode = Utils.getString("Enter customer code: ");
                        if (llw.search(trcode, 1) == null) {
                            System.out.println("Train code does not exist");
                            continue;
                        }
                        if (llc.search(cuscode, 2) == null) {
                            System.out.println("Customer code does not exist");
                            continue;
                        }
                        if (!llb.isEmpty()) {
                            for (int i = 0; i < llb.size(); i++) {
                                if (llb.get(i).tcode.compareTo(trcode) == 0 && llb.get(i).ccode.compareTo(cuscode) == 0) {
                                    System.out.println("Train code and Cuscode has been existed in booking list");
                                    continue;
                                }
                            }
                        }
                        booking.tcode = trcode;
                        booking.ccode = cuscode;

                        Train tr = new Train();
                        tr = (Train) llw.search(trcode, 1).info;
                        if (tr.avai_seat == 0) {
                            System.out.println("The train is exhausted");
                            check = false;
                        }

                        int bseat = Utils.getNumber("Enter number of seats to be booked: ");
                        if (bseat <= tr.avai_seat) {
                            booking.booked = bseat;
                            tr.avai_seat = tr.avai_seat - bseat;
                            llb.addLast((Booking) booking);
                            System.out.println("Booking successfully");
                            check = false;
                        }else System.out.println("Out of available");
                    } while (check);
                    break;

                case 2:
                    if (llb.isEmpty()) {
                        System.out.println("No booking available");
                        return;
                    }
                    System.out.println("Train Code\t|\tCustomer Code\t|\tSeats");
                    for (int i = 0; i < 62; i++) {
                        System.out.print("-");
                    }
                    System.out.println("");

                    for (int i = 0; i < llb.size(); i++) {
                        System.out.println(llb.get(i).tostring());
                    }
                    break;

                case 3:
                    if (llb.isEmpty()) {
                        System.out.println("No booking available");
                        return;
                    }
                    check = Utils.repeatQuiz("Press 1 to sort by Train code\nPress 2 to sort by Customer code: ");
                    if (check) {
                        Utils.book = true;
                        llb.head = llb.mergeSort(llb.head);
                        System.out.println("Sorted by Train code successfully");
                    } else {
                        Utils.book = false;
                        llb.head = llb.mergeSort(llb.head);
                        System.out.println("Sorted by Customer code successfully");
                    }
                    break;
                
                case 4:
                    System.out.println("Return Gas Station");
                    break;
            }
        } while (choice != 4);
    }
}
