/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letter_and_character_count;

import static java.util.Arrays.fill;
import java.util.StringTokenizer;

/**
 *
 * @author ADMIN
 */
public class StringArray {

    private String str;
    private String[] arr;

    public StringArray(String str) {
        this.str = str;
    }

    public StringArray(String str, String[] arr) {
        this.str = str;
        this.arr = arr;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String[] getArr() {
        return arr;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public void countLetters() {
        StringTokenizer st = new StringTokenizer(str);
        arr = str.split("\\s");
        System.out.print("{  ");
        while (st.hasMoreTokens()) {
            int count = 0;
            boolean check = false;
            String tmp = st.nextToken();
            for (int i = 0; i < arr.length; i++) {
                if ((tmp.equals(arr[i])) && (!" ".equals(arr[i]))) {
                    count++;
                    arr[i] = " ";
                    check = true;
                }
            }
            if (check) {
                System.out.print(tmp + "=" + count + "  ");
            }
        }
        System.out.println("}");
    }

    public void countCharacter() {
        boolean[] check = new boolean[300];
        fill(check, true);
        check[(int) ' '] = false;
        System.out.print("{  ");
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int count = 0;
            boolean ch = true;
            for (int j = 0; j < str.length(); j++) {
                if ((c == str.charAt(j)) && (check[(int) c] == true)) {
                    count++;
                    ch = false;
                }
            }
            if (ch == false) {
                check[(int) c] = false;
                System.out.print(c + "=" + count+ "  ");
            }
        }
        System.out.println("}");
    }
}
