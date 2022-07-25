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
public class Vaccine extends Hospital implements Serializable{
    private String vaccine_id, vaccine;
    
    public Vaccine() {
    }

    public Vaccine(String vaccine_id, String vaccine) {
        this.vaccine_id = vaccine_id;
        this.vaccine = vaccine;
    }
    
    @Override
    public void add_item() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return vaccine_id + "," + vaccine;
    }

    @Override
    public void update_item() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
