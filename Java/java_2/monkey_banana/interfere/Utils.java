/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfere;

import algorithm.Queue_lib;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ADMIN
 */
public class Utils {
    public static int a[][];
    static int row;
    static int col;
    static ArrayList<Integer> listNum;
    static Scanner sc = new Scanner(System.in);

    /*a[][] = {{0, 1, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 4, 0},
                                {2, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 3, 0}};*/
    public static Map<Integer, String> map;
    
    public static int[][] getArray(){
        a = new int[14][14];
        row = a[0].length;
        col = a.length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                a[i][j] = 0;
            }
        }
        
        return a;
    }

    public static void showMap(int m[][]) {
        for (int i = 0; i < m[0].length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (a[i][j] == 0) {
                    System.out.print(m[i][j] + "\t");
                } else {
                    System.out.print(Utils.map.get(m[i][j]) + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void createMap() {
        int size = row * col - 1;
        listNum = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
            listNum.add(i);
        }

        int count = 0;
        while (count < 4) {
            count++;
            int loca = numRandlistNum();
            int incre = 0;
            for (int i = 0; i < row; i++) {
                int k = 0;
                for (int j = 0; j < col; j++) {
                    if (loca == incre) {
                        a[i][j] = count;
                        k = j;
                    }
                    incre++;
                }
                if (loca < incre && a[i][k] != 0) {
                    break;
                }
            }
        }
    }

    private static int numRandlistNum() {
        Random Rand = new Random();
        int result = 0;
        do {
            result = Rand.nextInt(row * col - 1);
            for (int i = 0; i < listNum.size(); i++) {
                if(listNum.get(i) == result){
                    listNum.remove(i);
                    return result;
                }
            }
            if(listNum.size() == 0)break;
        } while (true);
        return result;
    }
    
    public static String getString(String str){
        System.out.print(str);
        String result;
        try {
            result = sc.nextLine();
            if (result.isEmpty()) {
                throw new Exception();
            }
        } catch (Exception e) {
            return "";
        }
        return result;
    }
    
    public static boolean askQuiz(String str, String yes, String no){
        System.out.println(str);
        do {            
            String gerAns = getString("Choice: ").trim();
            if(yes.equalsIgnoreCase(gerAns)){
                return true;
            }
            if(no.equalsIgnoreCase(gerAns)){
                break;
            }
        } while (true);
        return false;
    }
    
    public static int getNumber(String str) {
        int result = 0;
        boolean check = true;
        do {
            try {
                System.out.print(str);
                result = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Re-enter a number");
            }
        } while (check);
        return result;
    }
    
    public static void delay_output() throws InterruptedException{
        int count = 0;
        String cal = "Calculating";
        String point = ".";
        System.out.print(cal);
        while(count++ < 1){
            for (int i = 0; i < 20; i++) {
                System.out.print(point);
                TimeUnit.MILLISECONDS.sleep(300);
            }
        }
        System.out.println();
    }
}
