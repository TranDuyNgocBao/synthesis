/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bracket_check;

/**
 *
 * @author ADMIN
 */
public class Bracket_Check {
    public boolean check_bracket(String str){
        Stack_lib<Character> list = new Stack_lib<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='(' || str.charAt(i)=='[' || str.charAt(i)=='{'){
                list.push(str.charAt(i));
                continue;
            }
            char check = str.charAt(i);
            switch(check){
                case ')':
                    if(list.pop() != '(')return false;
                    break;
                
                case ']':
                    if(list.pop() != '[')return false;
                    break;
                
                case '}':
                    if(list.pop() != '{')return false;
                    break;
            }
        }
        return list.isEmpty();
    }
}
