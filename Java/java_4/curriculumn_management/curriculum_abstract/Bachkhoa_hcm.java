/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curriculum_abstract;

/**
 *
 * @author ADMIN
 */
public class Bachkhoa_hcm extends Curriculum{

    @Override
    public void output() {
        super.setFundamental_training("C");
        super.setAdvanced_training("System Design");
        super.setSpecialized_training("Network");
        System.out.println("Fundamental training: "+ super.getFundamental_training());
        System.out.println("Advanced training: "+ super.getAdvanced_training());
        System.out.println("Specialized training: "+ super.getSpecialized_training());
    }
    
}
