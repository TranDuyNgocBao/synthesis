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
public class FPT extends Curriculum{

    @Override
    public void output() {
        super.setFundamental_training("Java");
        super.setAdvanced_training("System Architecture");
        super.setSpecialized_training("Mobile");
        System.out.println("Fundamental training: "+ super.getFundamental_training());
        System.out.println("Advanced training: "+ super.getAdvanced_training());
        System.out.println("Specialized training: "+ super.getSpecialized_training());        
    }
    
}
