/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidate;

/**
 *
 * @author ADMIN
 */
public class Experience extends Candidate{
    private int expYear ;
    private String proSkill;

    public Experience() {
    }

    public Experience(int expYear, String proSkill, String id, String fName, String lName, String birthday, String address, String phone, String email) {
        super(id, fName, lName, birthday, address, phone, email);
        this.expYear = expYear;
        this.proSkill = proSkill;
    }
    
     public Experience(String id) {
         this.id = id;
    }

    public int getExpYear() {
        return expYear;
    }

    public void setExpYear(int expYear) {
        this.expYear = expYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    protected void creating() {
        System.out.println("Creating Experience");
        this.id = Utils.getStr("Id: ");
        this.fName = Utils.getStr("First name: ");
        this.lName = Utils.getStr("Last name: ");
        this.birthday = Utils.getStr("Birthday: ");
        this.email = Utils.getStr("Email: ");
        this.phone = Utils.getStr("Phone: ");
        this.address = Utils.getStr("Address: ");
        this.proSkill = Utils.getStr("Profesional skills: ");
        this.expYear = Utils.getInt("Experienced years: ");
    }

    @Override
    public void updating() {
        System.out.println("Updating Experience");
        this.id = Utils.updateStr(this.id,"Id: ");
        this.fName = Utils.updateStr(this.fName,"First name: ");
        this.lName = Utils.updateStr(this.lName, "Last name: ");
        this.birthday = Utils.updateStr(this.birthday,"Birthday: ");
        this.email = Utils.updateStr(this.email,"Email: ");
        this.phone = Utils.updateStr(this.phone,"Phone: ");
        this.address = Utils.updateStr(this.address,"Address: ");
        this.proSkill = Utils.updateStr(this.proSkill,"Profesional skills: ");
        this.expYear = Utils.updateInt(this.expYear,"Experienced years: ");
    }

    @Override
    public String toString() {
        return super.toString() + "\nExperience{" + "expYear = " + expYear + ", proSkill = " + proSkill + '}';
    }

    @Override
    public int compareTo(Candidate o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
