/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor_management_program;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author ADMIN
 */
public class DoctorList extends HashMap implements I_List{

    @Override
    public void add() {
        Doctor cd = new Doctor();
//        cd.setCode(Utils.getStr("Code: "));
//        cd.setName(Utils.getStr("Name: "));
//        cd.setSpecialization(Utils.getStr("Specialization: "));
//        cd.setAvailability(Utils.getNumber("Availability: "));
        
        this.put(Utils.getStr("Code: "), Utils.getStr("Name: "));
        System.out.println("Added");
    }

    @Override
    public void update() {
        String code = Utils.getStr("Code update: ");
        if(this.get(code) != null){
            this.replace(code, Utils.getStr("New Name: "));
        }else System.out.println("No key found");
    }

    @Override
    public void delete() {
        String code = Utils.getStr("Code delete: ");
        if(this.get(code) != null){
            this.remove(code);
        }else System.out.println("No key found");
    }

    @Override
    public void search() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void output() {
        Iterator it = this.keySet().iterator();
        while (it.hasNext()) {
            String key = (String)(it.next());
            String value = (String)(this.get(key));
            System.out.println(key + ", " + value);
        }
    }
    
}
