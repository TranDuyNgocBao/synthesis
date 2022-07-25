/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gopchung;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 * @param <T>
 */
class Utils<T extends Comparable> {

    static Scanner sc = new Scanner(System.in);
    
    public static boolean book;

    public static int getNumber(String str) {
        int result = 0;
        boolean check = true;
        do {
            try {
                System.out.print(str);
                result = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Re-enter a number");
            }
        } while (check);
        return result;
    }

    public static String getString(String str) {
        System.out.print(str);
        String result = sc.nextLine();
        return result;
    }

    public static String getFirstString(String str) {
        String result;
        str += ' ';
        int i;
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                break;
            }
        }
        result = str.substring(0, i);
        return result;
    }

    private static boolean checkYearOdd(int yy) {
        if (yy % 4 != 0) {
            return false;
        }
        if (yy % 100 == 0) {
            if (yy % 400 == 0) {
                return true;
            } else {
                return false;
            }
        }
        if (yy % 4 == 0) {
            return true;
        }
        return false;
    }

    private static boolean checkDate(int dd, int mm, int yyyy) {
        if (yyyy < 0 || dd < 1 || mm < 1 || mm > 12) {
            return false;
        }
        switch (mm) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (dd > 31) {
                    return false;
                }
                break;
            case 2:
                if (!checkYearOdd(yyyy) && dd > 28) {
                    return false;
                }
                if (checkYearOdd(yyyy) && dd > 29) {
                    return false;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (dd > 30) {
                    return false;
                }
                break;
        }
        return true;
    }

    private static boolean dateFormat(String inputDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            formatter.parse(inputDate);
        } catch (ParseException e) {
            return false;
        }
        String tmp = "";
        int day = 0, month = 0, year, count = 0;
        for (int i = 0; i < inputDate.length(); i++) {
            if (inputDate.charAt(i) != '/') {
                tmp += inputDate.charAt(i);
            } else {
                if (count == 0) {
                    day = Integer.parseInt(tmp);
                } else {
                    month = Integer.parseInt(tmp);
                }
                count++;
                tmp = "";
            }
        }
        year = Integer.parseInt(tmp);
        if (!checkDate(day, month, year)) {
            return false;
        }
        return true;
    }

    public static int compareDate(String str1, String str2) {
        String tmp1 = "", tmp2 = "";
        int day1 = 0, month1 = 0, year1, count = 0;
        int day2 = 0, month2 = 0, year2;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != '/') {
                tmp1 += str1.charAt(i);
                tmp2 += str2.charAt(i);
            } else {
                if (count == 0) {
                    day1 = Integer.parseInt(tmp1);
                    day2 = Integer.parseInt(tmp2);
                } else {
                    month1 = Integer.parseInt(tmp1);
                    month2 = Integer.parseInt(tmp2);
                }
                count++;
                tmp1 = "";
                tmp2 = "";
            }
        }
        year1 = Integer.parseInt(tmp1);
        year2 = Integer.parseInt(tmp2);
        if (year1 < year2) {
            return -1;
        } else if (year1 > year2) {
            return 1;
        }
        if (month1 < month2) {
            return -1;
        } else if (month1 > month2) {
            return 1;
        }
        if (day1 < day2) {
            return -1;
        } else if (day1 > day2) {
            return 1;
        }
        return 0;
    }

    public static String getDate(String str) {
        String result = "";
        boolean check = true;
        do {
            System.out.print(str);
            result = sc.nextLine();
            if (dateFormat(result) == true) {
                check = false;
            } else {
                System.out.println("Wrong date and format try again");
            }
        } while (check);
        return result;
    }

    public static boolean repeatQuiz(String str) {
        //System.out.println("");
        System.out.println(str);
        int choice = 0;
        while (choice != 1 && choice != 2) {
            choice = getNumber("Choose(1 or 2): ");
        }
        if (choice == 1) {
            return true;
        }
        return false;
    }

    public static double getDouble(String str) {
        double result = 0;
        boolean check = true;
        do {
            try {
                System.out.print(str);
                result = Double.parseDouble(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Re-enter a number");
            }
        } while (check);
        return result;
    }
    
    public static String getStrfromObj(Gas_station obj, int x){
        if(x == 1)return obj.tcode;
        if(x == 2)return obj.ccode;
        return "";
    }
}


class Train extends Gas_station {

    private String train_name;
    private int seat;
    private double depart_time;
    private String depart_place;
    public int avai_seat;

    public Train() {
    }

    public Train(String train_name, int seat, double depart_time, String depart_place, int avai_seat, String tcode, String ccode, int booked) {
        super(tcode, ccode, booked);
        this.train_name = train_name;
        this.seat = seat;
        this.depart_time = depart_time;
        this.depart_place = depart_place;
        this.avai_seat = avai_seat;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getDepart_time() {
        return depart_time;
    }

    public void setDepart_time(double depart_time) {
        this.depart_time = depart_time;
    }

    public String getDepart_place() {
        return depart_place;
    }

    public void setDepart_place(String depart_place) {
        this.depart_place = depart_place;
    }

    public int getAvai_seat() {
        return avai_seat;
    }

    public void setAvai_seat(int avai_seat) {
        this.avai_seat = avai_seat;
    }

    @Override
    public void add() {
        this.train_name = Utils.getString("Train Name: ");
        this.seat = Utils.getNumber("Seat: ");
        do {
            int bkd = Utils.getNumber("Booked: ");
            if (bkd > this.seat) {
                System.out.println("Out of Seats, try again");
                continue;
            }
            this.booked = bkd;
            break;
        } while (true);
        this.avai_seat = this.seat - this.booked;
        this.depart_time = Utils.getDouble("Depart Time: ");
        this.depart_place = Utils.getString("Depart Place: ");
    }

    @Override
    public String tostring() {
        return tcode + "\t| \t" + train_name + "\t\t|\t" + seat + "\t| \t" + booked + "\t| \t" + depart_time + "\t\t| \t" + depart_place + "\t\t| \t" + this.avai_seat;
    }
}


class Node<T> {
    T info;
    Node<T> next;

    public Node() {
    }

    public Node(T info) {
        this.info = info;
        this.next = null;
    }

    public Node(T info, Node<T> next) {
        this.info = info;
        this.next = next;
    }

}


public class Main implements I_Menu {

    @Override
    public void train_list() {
        System.out.println("1.  Load data from file");
        System.out.println("2.  Input and add to the head");
        System.out.println("3.  Display data");
        System.out.println("4.  Save train list to file");
        System.out.println("5.  Search by tcode");
        System.out.println("6.  Delete by tcode");
        System.out.println("7.  Sort by tcode");
        System.out.println("8.  Add after position k");
        System.out.println("9.  Delete the node before the node having tcode = xCode");
        System.out.println("10. Back to Gas Station");
    }

    @Override
    public void customer_list() {
        System.out.println("1. Load data from file");
        System.out.println("2. Input and add to the end");
        System.out.println("3. Display data");
        System.out.println("4. Save customer list to file");
        System.out.println("5. Search by ccode");
        System.out.println("6. Delete by ccode");
        System.out.println("7. Back to Gas Station");
    }

    @Override
    public void booking_list() {
        System.out.println("1. Input data");
        System.out.println("2. Display data width available seats");
        System.out.println("3. Sort by tcode + ccode");
        System.out.println("4. Back to Gas Station");
    }

    @Override
    public void menu_list() {
        System.out.println("WELCOME TO GAS STATION");
        System.out.println("1. Train List");
        System.out.println("2. Customer List");
        System.out.println("3. Booking List");
        System.out.println("4. Quit");
    }

    @Override
    public int getChoice(int from, int end) {
        int choice = 0;
        do{
            choice = Utils.getNumber("Choice from " + from + " to " + end + ": ");
        }while(choice < from || choice > end);
        return choice;
    }

}


class Lists {

    static ArrayList<String> tcodeList = new ArrayList<>();
    static ArrayList<String> ccodeList = new ArrayList<>();

    static LinkedListWritten<Train> llw = new LinkedListWritten<>();
    static LinkedListWritten<Customer> llc = new LinkedListWritten<>();
    static LinkedListWritten<Booking> llb = new LinkedListWritten<>();

    static String fileURL = "SE150440_BaoTDN_TrainList.txt";
    static String fileCus = "SE150440_BaoTDN_CustomerList.txt";

    static I_Menu menu = new Main();

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
                            llb.addLast((Booking) booking);
                            System.out.println("Booking successfully");
                            check = false;
                        }
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


class LinkedListWritten<T> {

    Node<T> head, tail;
    private int length = 0;

    public LinkedListWritten() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
        length = 0;
    }

    void tostring() {
        if (isEmpty()) {
            System.out.println(" Empty");
        } else {
            Node<T> p = head;
            while (p != null) {
                System.out.print(" " + p.info);
                p = p.next;
            }
            System.out.println("");
        }
    }

    int size() {
        return length;
    }

    void addLast(T data) {
        if (isEmpty()) {
            head = tail = new Node(data, null);
        } else {
            Node<T> tmp = new Node(data, null);
            tail.next = tmp;
            tail = tmp;
        }
        length++;
    }

    void addFirst(T data) {
        if (isEmpty()) {
            head = tail = new Node(data, null);
        } else {
            Node<T> tmp = new Node(data, null);
            tmp.next = head;
            head = tmp;
        }
        length++;
    }

    void addMany(T[] arr) {
        for (T arr1 : arr) {
            addLast(arr1);
        }
    }

    void addPos(int index, T data) {
        if (length == 0 && index != 0) {
            System.out.println("False");
        } else if (index < 0 || index > length) {
            System.out.println("False");
        } else if (index == 0) {
            addFirst(data);
        } else if (index == length) {
            addLast(data);
        } else {
            Node<T> p = head;
            int i = 0;
            while (p != null) {
                if (i == index) {
                    Node<T> tmp = new Node(data);
                    tmp.next = p.next;
                    p.next = tmp;
                    break;
                }
                i++;
                p = p.next;
            }
            length++;
        }
    }

    T get(int index) {
        Node<T> p = head;
        int i = 0;
        while (p != null) {
            if (i == index) {
                return p.info;
            }
            i++;
            p = p.next;
        }
        return null;
    }

    void removeFirst() {
        if (isEmpty()) {
            System.out.println(" False");
        } else {
            head = head.next;
            length--;
        }
    }

    void removeLast() {
        if (isEmpty()) {
            System.out.println(" False");
        } else {
            Node<T> p = head;
            while (p != null) {
                if (p.next == tail) {
                    p.next = null;
                    length--;
                    break;
                }
                p = p.next;
            }
        }
    }

    void remove(int index) {
        if (isEmpty()) {
            System.out.println(" False");
        } else if (index < 0 || index > length - 1) {
            System.out.println(" False");
        } else if (index == 0) {
            removeFirst();
        } else if (index == length - 1) {
            removeLast();
        } else {
            Node<T> p = head;
            int i = 0;
            while (p != null) {
                if (i + 1 == index) {
                    p.next = p.next.next;
                    length--;
                    break;
                }
                i++;
                p = p.next;
            }
        }
    }

    Node<T> search(String val, int choice) {
        if (isEmpty()) {
            return null;
        } else {
            Node<T> p = head;
            while (p != null) {
                String searc = Utils.getStrfromObj((Gas_station) p.info, choice);
                if (searc.equals(val)) {
                    return p;
                }
                p = p.next;
            }
        }
        return null;
    }

    void dele(String xCode, int choice) {
        if (isEmpty()) {
            System.out.println("Cannot find xCode");
        } else {
            Node<T> p = head;
            int i = 0;
            while (p != null) {
                String searc = Utils.getStrfromObj((Gas_station) p.info, choice);
                if (searc.equals(xCode)) {
                    if (!Utils.repeatQuiz("Do you really want to delete? (1-yes || 2-no)")) {
                        System.out.println("Stop deleting");
                        return;
                    }
                    remove(i);
                    System.out.println("Deleted");
                    return;
                }
                i++;
                p = p.next;
            }
        }
        System.out.println("Cannot find XCode");
    }

    void delexCode(String xCode) {
        if (size() <= 1) {
            System.out.println("False");
        } else {
            Node<T> p = head;
            int i = 0;
            while (p != null) {
                String searc = "";
                if (p.next != null) {
                    searc = Utils.getStrfromObj((Train) p.next.info, 1);
                }
                if (searc.equals(xCode)) {
                    if (!Utils.repeatQuiz("Do you really want to delete? (1-yes || 2-no)")) {
                        System.out.println("Stop deleting");
                        return;
                    }
                    remove(i);
                    System.out.println("Deleted");
                    return;
                }
                i++;
                p = p.next;
            }
        }
        System.out.println("Cannot find XCode");
    }

    Node<T> mergeSort(Node<T> p) {
        if (p == null || p.next == null) {
            return p;
        }

        // get middle of the list
        Node<T> middle = getMiddle(p);
        Node<T> nextInfoMiddle = middle.next;

        middle.next = null;

        Node<T> left = mergeSort(p);

        Node<T> right = mergeSort(nextInfoMiddle);

        Node<T> sortedList = sortedMerge(left, right);

        return sortedList;
    }

    private Node<T> getMiddle(Node<T> head) {
        if (head == null) {
            return head;
        }

        Node<T> slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node<T> sortedMerge(Node<T> a, Node<T> b) {
        Node<T> result = null;

        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        Train num1, num2;
        if (a.info instanceof Train || b.info instanceof Train) {
            num1 = (Train) a.info;
            num2 = (Train) b.info;
            if (num1.tcode.compareTo(num2.tcode) <= 0) {
                result = a;
                result.next = sortedMerge(a.next, b);
            } else {
                result = b;
                result.next = sortedMerge(a, b.next);
            }
        }
        
        Customer num3, num4;
        if (a.info instanceof Customer || b.info instanceof Customer) {
            num3 = (Customer) a.info;
            num4 = (Customer) b.info;
            if (num3.ccode.compareTo(num4.ccode) <= 0) {
                result = a;
                result.next = sortedMerge(a.next, b);
            } else {
                result = b;
                result.next = sortedMerge(a, b.next);
            }
        }
        
        Booking num5, num6;
        if (a.info instanceof Booking || b.info instanceof Booking) {
            num5 = (Booking) a.info;
            num6 = (Booking) b.info;
            
            if(Utils.book == true){
                if (num5.tcode.compareTo(num6.tcode) <= 0) {
                result = a;
                result.next = sortedMerge(a.next, b);
            } else {
                result = b;
                result.next = sortedMerge(a, b.next);
            }
            }else{
                if (num5.ccode.compareTo(num6.ccode) <= 0) {
                result = a;
                result.next = sortedMerge(a.next, b);
            } else {
                result = b;
                result.next = sortedMerge(a, b.next);
            }
            }
        }
        return result;
    }
}


interface I_Menu {
    void train_list();
    void customer_list();
    void booking_list();
    void menu_list();
    int getChoice(int from, int end);
}


abstract class Gas_station {
    String tcode, ccode;
    int booked;

    public Gas_station() {
    }

    public Gas_station(String tcode, String ccode, int booked) {
        this.tcode = tcode;
        this.ccode = ccode;
        this.booked = booked;
    }
    
    public Gas_station(String tcode) {
        this.tcode = tcode;
    }

    public Gas_station(int booked) {
        this.booked = booked;
    }
    
    public String getTcode() {
        return tcode;
    }

    public void setTcode(String tcode) {
        this.tcode = tcode;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }
    
    public abstract void add();

    public abstract String tostring();
}


class Customer extends Gas_station{
    private String cus_name, phone;

    public Customer() {
    }

    public Customer(String cus_name, String phone, String tcode, String ccode, int booked) {
        super(tcode, ccode, booked);
        this.cus_name = cus_name;
        this.phone = phone;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    public void add(){
        this.cus_name = Utils.getString("Customer Name: ");
        String regex = "^\\d+";
        int check = 0;
        do{
            if(check == 1)System.out.println("Numbers Only");
            this.phone = Utils.getString("Phone number: ");
            check = 1;
        }while(!this.phone.matches(regex));
    }

    @Override
    public String tostring() {
        return this.ccode + "\t\t|\t" + cus_name + "\t\t|\t" + phone;
    }
    
}


class Booking extends Gas_station{

    public Booking() {
    }

    public Booking(String tcode, String ccode, int booked) {
        super(tcode, ccode, booked);
    }

    @Override
    public String tostring() {
        return this.tcode +"\t\t|\t"+ this.ccode +"\t\t|\t"+ this.booked;
    }

    @Override
    public void add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

class Management {
    public static void main(String[] args) throws IOException {
        I_Menu menu = new Main();
        int choice;
        do {
            System.out.println("");
            menu.menu_list();
            choice = menu.getChoice(1, 4);
            if(choice == 1)Lists.trainlist();
            if(choice == 2)Lists.customerList();
            if(choice == 3)Lists.bookingList();
            if(choice == 4)System.out.println("QUIT");
        } while (choice != 4);
    }
}
