/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidate;

/**
 *
 * @author ADMIN
 */
public class UsingCandidate {

    public static void main(String[] args) {
        CandidateList list = new CandidateList();
        int choice = 0;
        try {
            do {
                Utils.menu();
                choice = Utils.getInt("Choice: ");
                Candidate cd;
                int index;
                String id;

                switch (choice) {
                    case 1:
                        cd = new Experience();
                        cd.creating();
                        index = list.indexOf(cd);
                        if (index == -1) {
                            list.add(cd);
                            System.out.println("Success");
                        } else {
                            System.out.println("Duplicate");
                        }
                        break;
                    case 2:
                        id = Utils.getStr("Find ID: ");
                        index = list.indexOf(new Experience(id));
                        if (index > -1) {
                            System.out.println("Found: " + list.get(index).toString());
                        } else {
                            System.out.println("Not found");
                        }
                        break;
                    case 3:
                        index = Utils.getInt("Find Index: ");
                        if (index > -1 && index < list.size()) {
                            System.out.println("Found: " + list.get(index).toString());
                        } else {
                            System.out.println("Not found");
                        }
                        break;
                    case 4:
                        id = Utils.getStr("Update ID: ");
                        index = list.indexOf(new Experience(id));
                        if (index > -1) {
                            cd = list.get(index);
                            cd.updating();
                            list.set(index, cd);
                        } else {
                            System.out.println("Not found");
                        }
                        break;
                    case 5:
                        index = Utils.getInt("Update index: ");
                        if (index > -1 && index < list.size()) {
                            cd = list.get(index);
                            cd.updating();
                            list.set(index, cd);
                        } else {
                            System.out.println("Not found");
                        }
                        break;
                    case 6:
                        id = Utils.getStr("Remove ID: ");
                        index = list.indexOf(new Experience(id));
                        if (index > -1) {
                            list.remove(index);
                        } else {
                            System.out.println("Not found");
                        }
                        break;
                    case 7:
                        index = Utils.getInt("Remove index: ");
                        if (index > -1 && index < list.size()) {
                            list.remove(index);
                        } else {
                            System.out.println("Not found");
                        }
                        break;
                    case 8:
                        System.out.println("Experience list:");
                        list.showExperience();
                        break;
                    case 9:
                        System.out.println("Candidate list: ");
                        list.showAll();
                        break;
                    case 10:
                        System.out.println("QUIT");
                        break;
                }
            } while (choice != 10);
        } catch (Exception e) {
        }
    }
}
