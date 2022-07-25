/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidate;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class CandidateList extends ArrayList<Candidate>{

    public void showExperience(){
            for (Candidate cd : this) {
                if(cd instanceof Experience)System.out.println("Experience: "+cd.toString());
            }
}
    public void showAll(){
        this.forEach(cd -> {
            System.out.println("Candidate: "+cd.toString());
        });
}
}
