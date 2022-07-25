/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_function;

/**
 *
 * @author ADMIN
 */
public class UsingClass {
    public static void main(String[] args) {
        Candidate cdd = new Candidate() {
            @Override
            public int compareTo(Candidate o) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        Experience exp = new Experience();
        Fresher frc = new Fresher();
        Intern inc = new Intern();
        
        cdd.inType();
        int n = cdd.getcType();
        switch (n) {
            case 0:
                System.out.println("Creating Experience Information");
                exp.creating();
                System.out.println("What else could be changed");
                exp.updating();
                System.out.println("\nEXPERIENCE INFORMATION");
                System.out.println(exp.toString());
                break;
            case 1:
                System.out.println("Creating Fresher Candidate");
                frc.creating();
                System.out.println("What else could be changed");
                frc.updating();
                System.out.println("\nFRESHER CANDIDATE");
                System.out.println(frc.toString());
                break;
            case 2:
                System.out.println("Creating Intern Candidate");
                inc.creating();
                System.out.println("What else could be changed");
                inc.updating();
                System.out.println("\nINTERN CANDIDATE");
                System.out.println(inc.toString());
                break;
            default:
                System.out.println("This type of candidate does not exist");
                break;
        }
    }
}
