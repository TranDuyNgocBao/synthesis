/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidate;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class IDlist extends ArrayList implements I_IDlist{

    @Override
    public boolean idNOrepeated(int check) {
        boolean result = true;
        boolean tmp = true;
        System.out.println(this.size());
        if(this.size()>0){
            for (int i = 0; i < this.size(); i++) {
                if(Integer.parseInt((String) this.get(i)) == check){
                    tmp = false;
                    break;
                }
            }
            if(tmp ){
                String str = Integer.toString(check);
                this.add(str);
                result = false;
            }
        }else{
            String str = Integer.toString(check);
            this.add(str);
            result = false;
        }
        return result;
    }
    
}
