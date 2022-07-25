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
public class Freshercandidate extends Candidate{

    public Freshercandidate() {
        super(0, "0");
    }
    
    private int Graduation_date(int a){
        a = super.getN();
        return a;
    }
    
    private String Graduation_rank(String str){
        str = super.getString();
        return str;
    }
    
    private String Education(String str){
        super.setString("1");
        str = super.getString();
        return str;
    }
}
