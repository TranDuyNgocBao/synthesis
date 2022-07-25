/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal.v1;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class AnimalsList extends ArrayList<Animals> {

    public void showNoLeg() {
        for (Animals cd : this) {
            if (cd instanceof No_Legged) {
                System.out.println(cd.toString());
            }
        }
    }
    
    public void showTwoLeg() {
        for (Animals cd : this) {
            if (cd instanceof Two_Legged) {
                System.out.println(cd.toString());
            }
        }
    }

    public void showAll() {
        for (Animals cd : this) {
            System.out.println(cd.toString());
        }
    }
}
