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
public abstract class Curriculum {
    private String fundamental_training = "";
    private String advanced_training = "";
    private String specialized_training = "";

    public String getAdvanced_training() {
        return advanced_training;
    }

    public void setAdvanced_training(String advanced_training) {
        this.advanced_training = advanced_training;
    }

    public String getFundamental_training() {
        return fundamental_training;
    }

    public void setFundamental_training(String fundamental_training) {
        this.fundamental_training = fundamental_training;
    }

    public String getSpecialized_training() {
        return specialized_training;
    }

    public void setSpecialized_training(String specialized_training) {
        this.specialized_training = specialized_training;
    }
    
    public abstract void output();
}
