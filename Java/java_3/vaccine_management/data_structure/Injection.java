/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structure;

import covid19_vaccine_management.I_operation_list;
import covid19_vaccine_management.Operation_List;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class Injection extends Hospital implements Serializable {

    private String injection_id;
    private String ijt_place1, ijt_date1;
    private String ijt_place2, ijt_date2;
    private String authentication;

    public Injection() {
    }

    public Injection(String injection_id, String ijt_place1, String ijt_date1,
            String ijt_place2, String ijt_date2, String student_id,
            String student, String vaccine_id, String vaccine, String authentication) {
        super(student_id, student, vaccine_id, vaccine);
        this.injection_id = injection_id;
        this.ijt_place1 = ijt_place1;
        this.ijt_date1 = ijt_date1;
        this.ijt_place2 = ijt_place2;
        this.ijt_date2 = ijt_date2;
        this.authentication = authentication;
    }

    public String getInjection_id() {
        return injection_id;
    }

    public void setInjection_id(String injection_id) {
        this.injection_id = injection_id;
    }

    public String getIjt_place1() {
        return ijt_place1;
    }

    public void setIjt_place1(String ijt_place1) {
        this.ijt_place1 = ijt_place1;
    }

    public String getIjt_date1() {
        return ijt_date1;
    }

    public void setIjt_date1(String ijt_date1) {
        this.ijt_date1 = ijt_date1;
    }

    public String getIjt_place2() {
        return ijt_place2;
    }

    public void setIjt_place2(String ijt_place2) {
        this.ijt_place2 = ijt_place2;
    }

    public String getIjt_date2() {
        return ijt_date2;
    }

    public void setIjt_date2(String ijt_date2) {
        this.ijt_date2 = ijt_date2;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    @Override
    public void add_item() {
        do {
            boolean check;
            String tmp1, tmp2;
            boolean ch = true;
            do {
                tmp1 = Utils.getString("Student id: ");
                if (tmp1.equalsIgnoreCase("Unwritten")) {
                    ch = false;
                    System.out.println("ID is empty, try again");
                    continue;
                }
                ch = true;
                for (int i = 0; i < Utils.st_id.size(); i++) {
                    if (Utils.st_id.get(i).equalsIgnoreCase(tmp1)) {
                        System.out.println("Duplicated ID, try to another ID or Updating to edit this ID");
                        System.out.println("ID used: " + Utils.st_id.toString());
                        Utils.duplicate = true;
                        return;
//                        ch = false;
//                        break;
                    }
                }
                if (ch) {
                    break;
                }
            } while (true);

            tmp2 = Utils.getString("Student name: ");
            check = false;
            for (Map.Entry<String, String> en : Student_List.stlist.entrySet()) {
                String key = en.getKey().trim();
                String val = en.getValue().trim();
                if (key.equalsIgnoreCase(tmp1) && val.equalsIgnoreCase(tmp2)) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.out.println("Student is not existed, try again");
                System.out.println(Student_List.stlist.toString());
                continue;
            } else {
                this.student_id = tmp1;
                if (ch) {
                    Utils.st_id.add(tmp1);
                }
                this.student = tmp2.toUpperCase();
            }

            do {
                tmp1 = Utils.getString("Vaccine id(this vaccine will be used for 2 injections): ");
                if (tmp1.equalsIgnoreCase("Unwritten")) {
                    System.out.println("Vaccine cannot be empty");
                    continue;
                }
                check = false;
                for (Map.Entry<String, String> en : Vaccine_List.vclist.entrySet()) {
                    String key = en.getKey();
                    if (key.equalsIgnoreCase(tmp1)) {
                        check = true;
                        tmp2 = en.getValue();
                        break;
                    }
                }
                if (!check) {
                    System.out.println("Vaccine is not existed, try again");
                    continue;
                } else {
                    this.vaccine_id = tmp1;
                    this.vaccine = tmp2;
                    break;
                }
            } while (true);
            if (check) {
                break;
            }
        } while (true);

        do {
            String tmp = Utils.getString("Injection ID: ");
            boolean check = true;
            if (tmp.equalsIgnoreCase("Unwritten")) {
                System.out.println("Injection ID cannot be empty, try again");
                continue;
            } else {
                for (int i = 0; i < Utils.ijt_id.size(); i++) {
                    if (Utils.ijt_id.get(i).equalsIgnoreCase(tmp)) {
                        System.out.println("Duplicated ID, try again");
                        check = false;
                        System.out.print("Used Injection id: " + Utils.ijt_id.toString() + "\n");
                        break;
                    }
                }
            }
            if (check) {
                    this.setInjection_id(tmp);
                    Utils.ijt_id.add(tmp);
                    break;
                }
        } while (true);

        ijt_place1 = Utils.getString("1st Injection Place: ");
        if (ijt_place1.equalsIgnoreCase("Unwritten")) {
            ijt_date1 = ijt_date2 = ijt_place2 = "Unwritten";
        } else {
            do {
                ijt_date1 = Utils.getDate("1st Injection Date(dd/mm/yyyy): ");
            } while (ijt_date1.equalsIgnoreCase("Unwritten"));

            ijt_place2 = Utils.getString("2nd Injection Place: ");
            if (ijt_place2.equalsIgnoreCase("Unwritten")) {
                ijt_date2 = "Unwritten";
            } else {
                do {
                    ijt_date2 = Utils.getDate("2nd Injection Date(dd/mm/yyyy): ");
                    if (Utils.compareDate(ijt_date1, ijt_date2) >= 0) {
                        ijt_date2 = "Unwritten";
                        System.out.println("Invalid 2nd injection Date (must be 4-12 weeks after first injection)");
                    }
                    int days = 0;
                    try {
                        days = Utils.countDays(ijt_date1, ijt_date2);
                    } catch (ParseException ex) {
                        System.out.println("False");
                    }
                    if (days < 28 || days > 84) {
                        ijt_date2 = "Unwritten";
                        System.out.println("Invalid 2nd injection Date (must be 4-12 weeks after first injection)");
                    }
                } while (ijt_date2.equalsIgnoreCase("Unwritten"));
            }
        }

        if ("Unwritten".equalsIgnoreCase(ijt_place1)) {
            authentication = "Not vaccinated yet";
        } else if ("Unwritten".equalsIgnoreCase(ijt_place2)) {
            authentication = "Having Only One dose of the vaccine";
        } else {
            authentication = "Having enough Two doses of the vaccine";
        }
    }

    @Override
    public String toString() {
        return this.student_id + "      |" + this.student + "      |"
                + this.vaccine_id.toUpperCase() + "      |" + this.vaccine + "      |" + this.injection_id + "      |"
                + this.ijt_place1 + "      |" + this.ijt_date1 + "      |"
                + this.ijt_place2 + "      |" + this.ijt_date2 + "      |" + authentication;

    }

    @Override
    public void update_item() {
        String tmp = this.ijt_place1;
        if (tmp.equalsIgnoreCase("Unwritten")) {

            this.ijt_place1 = Utils.updateStr("Update 1st injection place: ", this.ijt_place1);
            if (!tmp.equalsIgnoreCase(this.ijt_place1)) {
                do {
                    this.ijt_date1 = Utils.getDate("Update 1st injection date(dd/mm/yyyy): ");
                } while (this.ijt_date1.equalsIgnoreCase("Unwritten"));
            } else {
                this.ijt_place1 = tmp;
            }
        }
        if (!ijt_place1.equalsIgnoreCase("Unwritten")) {
            tmp = this.ijt_place2;
            if (tmp.equalsIgnoreCase("Unwritten")) {
                System.out.println("Student had injected the 1st dose");
                this.ijt_place2 = Utils.updateStr("Update 2nd injection place: ", this.ijt_place2);

                if (!tmp.equalsIgnoreCase(this.ijt_place2)) {
                    do {
                        this.ijt_date2 = Utils.getDate("Update 2nd injection date(dd/mm/yyyy): ");
                        if (Utils.compareDate(this.ijt_date1, this.ijt_date2) >= 0) {
                            this.ijt_date2 = "Unwritten";
                            System.out.println("Invalid 2nd injection Date (must be 4-12 weeks after first injection)");
                        }
                        int days = 0;
                        try {
                            days = Utils.countDays(this.ijt_date1, this.ijt_date2);
                        } catch (ParseException ex) {
                            System.out.println("False");
                        }
                        if (days < 28 || days > 84) {
                            this.ijt_date2 = "Unwritten";
                            System.out.println("Invalid 2nd injection Date (must be 4-12 weeks after first injection)");
                        }
                    } while (this.ijt_date2.equalsIgnoreCase("Unwritten"));
                } else {
                    this.ijt_place2 = tmp;
                }
            } else {
                System.out.println("Student had enough 2 dose, not need to update");
            }
        } else {
            System.out.println("Need to add 1st dose first");
        }

        if ("Unwritten".equalsIgnoreCase(this.ijt_place1)) {
            this.authentication = "Not vaccinated yet";
        } else if ("Unwritten".equalsIgnoreCase(this.ijt_place2)) {
            this.authentication = "Having Only One dose of the vaccine";
        } else {
            this.authentication = "Having enough Two doses of the vaccine";
        }
    }
}
