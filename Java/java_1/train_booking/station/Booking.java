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
public class Booking extends Gas_station{

    public Booking() {
    }

    public Booking(String tcode, String ccode, int booked) {
        super(tcode, ccode, booked);
    }

    @Override
    public String tostring() {
        return this.tcode +"\t\t|\t"+ this.ccode +"\t\t|\t"+ this.booked;
    }

    @Override
    public void add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
