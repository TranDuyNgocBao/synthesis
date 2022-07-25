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
public abstract class Candidate implements Comparable<Candidate>{
    protected String id;
    protected String fName;
    protected String lName;
    protected String birthday;
    protected String address;
    protected String phone;
    protected String email;

    public Candidate() {
    }

    public Candidate(String id, String fName, String lName, String birthday, String address, String phone, String email) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

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
    
    protected abstract void creating();
    
    public abstract void updating();

    @Override
    public String toString() {
        return "\nCandidate{" + "id = " + id + ", fName = " + fName + ", lName = " + lName + 
                ", birthday = " + birthday + ", address = " + address + ", phone = " + phone + ", email = " + email + '}';
    }

    @Override
    public abstract int compareTo(Candidate o);

    @Override
    public boolean equals(Object obj) {
        return this.id.equals(((Candidate)obj).getId());
    }
}
