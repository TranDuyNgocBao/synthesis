/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author ADMIN
 */
public class Array {
    protected final int n = Utils.input_("Input length of array (length>=0): ");
    protected int[] a = new int[n];

    public int getN() {
        return n;
    }

    public int[] getA() {
        return a;
    }

    public Array() {
    }
    
    public void array_in(){
        
        for(int i = 0; i<this.n; i++){
            a[i] = Utils.input_("Element " + (i+1)+ ": ");
        }
    }
    
    public void array_out(){
        for(int i =0; i<this.n; i++){
            System.out.print(a[i]+", ");
        }
    }
    
    public void sort_a(){
        for(int i = 0; i<this.n -1; i++){
            for(int j= i+1; j<this.n; j++){
                if(a[i] > a[j]){
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }
    
    public String check_a(int ch){
        boolean check = false;
        for(int i = 0; i<this.n; i++){
            if(a[i] == ch){
                check =true;
                ch = i;
                break;
            }
        }
        if(check)return ("Value exists in array: a["+ ch+ "] = " + a[ch]);
        else return ("Cannot find Value");
    }
}
    
    