/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structure;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class Student extends Hospital implements Serializable{
    private String student_id, student;

    public Student() {
    }

    public Student(String student_id, String student) {
        this.student_id = student_id;
        this.student = student;
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
    
    @Override
    public void add_item() {
        
    }

    @Override
    public String toString() {
        return student_id + "," + student + "\n";
    }

    @Override
    public void update_item() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
