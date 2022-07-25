/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack_FILO;

/**
 *
 * @author ADMIN
 */
public class Stack_Recode {
    public static void main(String[] args) throws Exception{
        //CSD_stack<Integer> st = new CSD_stack<>();
        Stack_lib<Integer> st = new Stack_lib<>();
        st.push(5);
        st.push(6);
        System.out.println(st.pop());
        System.out.println(st.peek());
    }
}
