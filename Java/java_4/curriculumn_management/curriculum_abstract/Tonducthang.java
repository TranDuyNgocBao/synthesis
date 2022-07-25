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
public class Tonducthang extends Curriculum{

    @Override
    public void output() {
        super.setFundamental_training("Python");
        super.setAdvanced_training("System Analyzing");
        super.setSpecialized_training("Data");
        System.out.println("Fundamental training: "+ super.getFundamental_training());
        System.out.println("Advanced training: "+ super.getAdvanced_training());
        System.out.println("Specialized training: "+ super.getSpecialized_training()); 
    }
    
}
