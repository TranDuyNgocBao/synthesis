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
public class Fresher extends Candidate{
    private String gradate;
    private String rankgra;
    private String university;

    public Fresher(String gradate, String rankgra, String university, String id, String fName, String lName, String birthday, String address, String phone, String email, int cType) {
        super(id, fName, lName, birthday, address, phone, email, cType);
        this.gradate = gradate;
        this.rankgra = rankgra;
        this.university = university;
    }

    public Fresher() {
    }

    @Override
    public void creating() {
        super.creating();
        this.gradate = Utils.getStr("Graduated time: ");
        this.rankgra = Utils.getStr("Rank of Graduation: ");
        this.university = Utils.getStr("University: ");
    }

    @Override
    public void updating() {
        super.updating();
        this.gradate = Utils.updateStr(this.gradate, "New Graduated time: ");
        this.rankgra = Utils.updateStr(this.rankgra, "New Rank of Graduation: ");
        this.university = Utils.updateStr(this.university, "New University: ");
    }

    @Override
    public String toString() {
        return super.toString() + "\nGraduated time: "+this.gradate + "\nRank of Graduation: "+this.rankgra
                + "\nUniversity: "+this.university; 
    }

    @Override
    public int compareTo(Candidate o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
