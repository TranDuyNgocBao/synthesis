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
public class AccessClass {

    public static void main(String[] args) {
        Candidate candidate = new Candidate();
        Experience_candidate exc = new Experience_candidate();
        Freshercandidate frc = new Freshercandidate();
        Intern_candidate inc = new Intern_candidate();

        candidate.setN(0);
        int n = candidate.getN();

        if (n == 0) {
            int candidateld = exc.Candidateld(n);
            String firstname = exc.FirstName("");
            String lastname = exc.LastName(firstname);
            String birthdate = exc.BirthDate(lastname);
            String address = exc.Address(lastname);
            int phone = exc.Phone(n);
            String email = exc.Email(address);
            int candidatetype = exc.Candidatetype(n);
            exc.creating();
            exc.updating();
            exc.deleting();
            exc.searching();
            n++;
        }
        if (n == 1) {
            int candidateld = frc.Candidateld(n);
            String firstname = frc.FirstName("");
            String lastname = frc.LastName(firstname);
            String birthdate = frc.BirthDate(lastname);
            String address = frc.Address(lastname);
            int phone = frc.Phone(n);
            String email = frc.Email(address);
            int candidatetype = frc.Candidatetype(n);
            frc.creating();
            frc.updating();
            frc.deleting();
            frc.searching();
            n++;
        }

        if (n == 2) {
            int candidateld = inc.Candidateld(n);
            String firstname = inc.FirstName("");
            String lastname = inc.LastName(firstname);
            String birthdate = inc.BirthDate(lastname);
            String address = inc.Address(lastname);
            int phone = inc.Phone(n);
            String email = inc.Email(address);
            int candidatetype = inc.Candidatetype(n);
            inc.creating();
            inc.updating();
            inc.deleting();
            inc.searching();
        }
    }
}
