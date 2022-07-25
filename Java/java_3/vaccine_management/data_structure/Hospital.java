/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structure;


/**
 *
 * @author ADMIN
 */
public abstract class Hospital {
    public String student_id, student;
    public String vaccine_id, vaccine;
    
    public Hospital() {
    }

    public Hospital(String student_id, String student, String vaccine_id, String vaccine) {
        this.student_id = student_id;
        this.student = student;
        this.vaccine_id = vaccine_id;
        this.vaccine = vaccine;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getVaccine_id() {
        return vaccine_id;
    }

    public void setVaccine_id(String vaccine_id) {
        this.vaccine_id = vaccine_id;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public abstract void add_item();
    
    public abstract void update_item();

    @Override
    public String toString() {
        return "Hospital{" + "student_id=" + student_id + ", student=" + student + ", vaccine_id=" + vaccine_id + ", vaccine=" + vaccine + '}';
    }
}
