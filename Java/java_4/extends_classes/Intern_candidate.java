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
public class Intern_candidate extends Candidate{

    public Intern_candidate() {
        super(0);
    }
    
    private String Majors(String str){
        super.setString("1");
        str = super.getString();
        return str;
    }
    
    private int Semester(int a){
        super.setN(3);
        a = super.getN();
        return a;
    }
    
    private String Universityname(String str){
        super.setString("2");
        str = super.getString();
        return str;
    }
}
