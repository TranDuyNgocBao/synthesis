/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_6;

import java.util.Arrays;

/**
 *
 * @author ADMIN
 */
public class ItemList {
    private Item [] list;
    private int numOfItem;
    public static final int MAX = 100;

    public ItemList() {
        this.list = new Item[MAX];
        this.numOfItem = 0 ;
    }

    public ItemList(Item[] list, int numOfItem) {
        this.list = list;
        this.numOfItem = numOfItem;
    }

    public Item[] getList() {
        return list;
    }

    public void setList(Item[] list) {
        this.list = list;
    }

    public int getNumOfItem() {
        return numOfItem;
    }

    public void setNumOfItem(int numOfItem) {
        this.numOfItem = numOfItem;
    }
    
    public boolean addItem(Item item){
        boolean result = false;
        if(this.list != null && this.numOfItem < 100){
            this.list[numOfItem++] = item;
            result = true;
        }
        return result;
    }
    
    public void displayAll(){
        for(int i =0; i< numOfItem; i++){
            System.out.println("\n"+Utils.check_class(list[i]));
            list[i].output();
        }
    }
    
    public Item findItem(String creator){
        Item result = null;
        for (int i = 0; i < numOfItem; i++) {
            if(creator.equalsIgnoreCase(list[i].getCreator())){
                result = list[i];
                break;
            }
        }
        return result;
    }
    
    public boolean updateItem(int index){
        boolean result = false;
        if(index >=0 && index<numOfItem){
            list[index].input();
            result = true;
        }
        return result;
    }
    
    public boolean removeItem(int index){
        boolean result = false;
        if(index>=0 && index <numOfItem){
            for (int i = index; i < numOfItem-1; i++) {
                list[i]=list[i+1];
            }
            numOfItem--;
            result = true;
        }
        return result;
    }
    
    public void sortItem(){
        if(this.list !=null && numOfItem<100){
            for(int i =0; i<numOfItem-1; i++)
                for(int j=i+1; j<numOfItem; j++){
                    if(list[i].getValue()>list[j].getValue()){
                        Item tmp = list[i];
                        list[i] = list[j];
                        list[j] = tmp;
                    }
                }
        }else System.out.println("Fails");
    }
    
}
