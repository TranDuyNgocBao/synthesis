/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package station;

/**
 *
 * @author ADMIN
 */
public class Customer extends Gas_station{
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
