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
public abstract class Gas_station {
    public String tcode, ccode;
    public int booked;

    public Gas_station() {
    }

    public Gas_station(String tcode, String ccode, int booked) {
        this.tcode = tcode;
        this.ccode = ccode;
        this.booked = booked;
    }
    
    public Gas_station(String tcode) {
        this.tcode = tcode;
    }

    public Gas_station(int booked) {
        this.booked = booked;
    }
    
    public String getTcode() {
        return tcode;
    }

    public void setTcode(String tcode) {
        this.tcode = tcode;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }
    
    public abstract void add();

    public abstract String tostring();
}
