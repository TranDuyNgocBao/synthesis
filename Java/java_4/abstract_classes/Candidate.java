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
public abstract class Candidate implements Comparable<Candidate>{
    protected String id;
    protected String fName;
    protected String lName;
    protected String birthday;
    protected String address;
    protected String phone;
    protected String email;
    protected int cType;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public abstract int compareTo(Candidate o);

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getcType() {
        return cType;
    }

    public void setcType(int cType) {
        this.cType = cType;
    }

    public Candidate(String id, String fName, String lName, String birthday, String address, String phone, String email, int cType) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.cType = cType;
    }

    public Candidate() {
    }
    
    public void inType(){
        this.cType = Utils.getType("Candidate type: ");
    }
    
    public void creating(){
        this.id = Utils.getStr("ID: ");
        this.fName = Utils.getStr("First Name: ");
        this.lName = Utils.getStr("Last Name: ");
        this.birthday = Utils.getStr("Birthday: ");
        this.address = Utils.getStr("Address: ");
        this.phone = Utils.getStr("Phone: ");
        this.email = Utils.getStr("Email: ");
    }
    
    public void updating(){
        this.id = Utils.updateStr(this.id, "New ID: ");
        this.fName = Utils.updateStr(this.fName, "New First Name: ");
        this.lName = Utils.updateStr(this.lName, "New Last Name: ");
        this.birthday = Utils.updateStr(this.birthday, "New Birthday: ");
        this.address = Utils.updateStr(this.address, "New Address: ");
        this.phone = Utils.updateStr(this.phone, "New Phone: ");
        this.email = Utils.updateStr(this.email, "New Email: ");
    }

    @Override
    public String toString() {
        return ("Candidate Type: "+this.cType+ "\nID: "+this.id +"\nFirst Name: "+this.fName +"\nLast name: "+this.lName
                + "\nBirthday: "+this.birthday +"\nAddress: "+this.address
                + "\nPhone: "+this.phone +"\nEmail: "+this.email);
    }
    
    
}
