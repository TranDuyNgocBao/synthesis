/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bracket_check;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class UsingMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bracket_Check bc = new Bracket_Check();
        System.out.println(bc.check_bracket(sc.nextLine()));
    }
}
