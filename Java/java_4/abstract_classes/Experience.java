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
public class Experience extends Candidate{
    private int expYear =0;
    private String proSkill;

    public Experience(int expYear, String proSkill, String id, String fName, String lName, String birthday, String address, String phone, String email, int cType) {
        super(id, fName, lName, birthday, address, phone, email, cType);
        this.expYear = expYear;
        this.proSkill = proSkill;
    }

    public Experience() {
    }

    @Override
    public String toString() {
        return (super.toString() + "\nYear of Experience: "+this.expYear 
                +"\nProfessional Skils: "+this.proSkill);
    }

    @Override
    public void creating() {
        super.creating();
        this.expYear = Utils.getType("Year of Experience: ");
        this.proSkill=Utils.getStr("Professional Skills: ");
    }

    @Override
    public void updating() {
        super.updating();
        this.expYear = Utils.updateNum(this.expYear, "Year of Experience New: ");
        this.proSkill=Utils.updateStr(this.proSkill,"New Professional Skills: ");
    }

    @Override
    public int compareTo(Candidate o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
