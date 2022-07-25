/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curriculum_interfaces;

/**
 *
 * @author ADMIN
 */
public class Specialized_training implements FPT, Tonducthang, Bachkhoa_hcm{

    @Override
    public void output_fpt() {
        System.out.println("Specialized training: "+ specialized_fpt);
    }

    @Override
    public void output_tonducthang() {
        System.out.println("Specialized training: "+ specialized_tdt);
    }

    @Override
    public void output_bkhcm() {
        System.out.println("Specialized training: "+ specialized_bkhcm);
    }
    
}
