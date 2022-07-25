/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_function;

/**
 *
 * @author ADMIN
 */
public class Intern extends Candidate{
    private String major;
    private String semester;
    private String university;

    public Intern(String major, String semester, String university, String id, String fName, String lName, String birthday, String address, String phone, String email, int cType) {
        super(id, fName, lName, birthday, address, phone, email, cType);
        this.major = major;
        this.semester = semester;
        this.university = university;
    }

    public Intern() {
    }

    @Override
    public void creating() {
        super.creating();
        this.major = Utils.getStr("Major: ");
        this.semester = Utils.getStr("Semester: ");
        this.university = Utils.getStr("University: ");
    }

    @Override
    public void updating() {
        super.updating(); 
        this.major = Utils.updateStr(this.major, "New Major: ");
        this.semester = Utils.updateStr(this.semester, "New Semester: ");
        this.university = Utils.updateStr(this.university, "New University: ");
    }

    @Override
    public String toString() {
        return super.toString()+ "\nMajor: "+this.major + "\nSemester: "+this.semester
                + "\nUniversity: "+this.university;
    }

    @Override
    public int compareTo(Candidate o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
