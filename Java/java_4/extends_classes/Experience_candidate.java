/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author ADMIN
 */
public class Experience_candidate extends Candidate {

    public Experience_candidate() {
        super(0, "0");
    }
    
    private int ExplnYear(int a){
        a = super.getN();
        return a;
    }
    
    private String ProSkill(String str){
        str = super.getString();
        return str;
    }
}
