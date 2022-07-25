/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circular_list;

/**
 *
 * @author ADMIN
 */
public class CL_Use {
    public static void main(String[] args) {
        MyList cl = new MyList();
        int[] arr = {8, 7, 6, 4, 3, 2, 1};
        cl.addMany(arr);
        cl.addPos(4, 5);
        cl.remove(2);
        cl.toArray();
        System.out.println(cl.get(4));
        System.out.println(cl.indexOf(3));
    }
}
