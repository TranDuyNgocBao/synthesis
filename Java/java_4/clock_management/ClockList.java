package clock.management;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hoa Doan
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ClockList extends ArrayList implements I_List {

    Scanner sc = new Scanner(System.in);
    
    private String getStr(String str){
        String result;
        System.out.print(str);
        result = sc.nextLine();
        return result;
    }
    
    private int getInt(String str){
        int result = -1;
        boolean check = true;
        do {            
            try {
                System.out.print(str);
                result = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Need an Integer");
            }
        } while (check);
        return result;
    }
    
    private String updateStr(String oldValue, String str){
        String result = oldValue;
        System.out.print(str);
        String tmp = sc.nextLine();
        if(!tmp.isEmpty())result = tmp;
        return result;
    }
    
    private int updateInt(int oldValue, String str){
        int result = oldValue;
        int tmp;
        tmp = getInt(str);
        if(tmp > -1)result = tmp;
        return result;
    }

    @Override
    public int find(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add() {
        Clock cd = new Clock();
        String str = getStr("Code: ");
        cd.setCode(str);
        str = getStr("Make: ");
        cd.setMake(str);

        int num = getInt("Size: ");
        cd.setSize(num);
        num = getInt("Price: ");
        cd.setPrice(num);

        this.add(cd);
        System.out.println("Added successfully");
    }

    @Override
    public void remove() {
        System.out.print("Code remove: ");
        String code = sc.nextLine();
        int index = this.indexOf(new Clock(code));
        if (index > -1 && index < this.size()) {
            this.remove(index);
            System.out.println("Removed successfully");
        }else{
            System.out.println("Not found");
        }
    }

    @Override
    public void update() {
        System.out.print("Code update: ");
        String code = sc.nextLine();
        int index = this.indexOf(new Clock(code));
        Clock cd ;
        if (index > -1 && index < this.size()) {
            cd = (Clock) this.get(index);
            cd.setCode(updateStr(cd.getCode(), "New code: "));
            cd.setMake(updateStr(cd.getMake(), "New make: "));
            cd.setSize(updateInt(cd.getSize(), "New size ('-1' if not updating): "));
            cd.setPrice(updateInt(cd.getPrice(), "New price ('-1' if not updating): "));
            this.set(index, cd);
            System.out.println("Updated successfully");
        }else System.out.println("Not found");
    }

    @Override
    public void sort() {
        Collections.sort(this);
    }

    @Override
    public void output() {
        System.out.println("");
        this.forEach(cd -> {
            System.out.println(((Clock) cd).toString());
        });
    }

}
