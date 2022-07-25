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
public class Clock implements Comparable{

    private String code, make;
    private int size, price;
    // change properties to private.
    // create getter, setter, 
    // Create constructor have parameters( need remove init value of properties

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Clock() {   
    }
    
    public Clock(String code) {
        this.code = code;
    }

    public Clock(String code, String make, int size, int price) {
        this.code = code;
        this.make = make;
        this.size = size;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        return this.code.equals(((Clock)obj).getCode());
    }

    @Override
    public String toString() {
        return "Clock{" + "code=" + code + ", make=" + make + ", size=" + size + ", price=" + price + '}';
    }

    @Override
    public int compareTo(Object o) {
        int comparePrice = ((Clock)o).getPrice();
        return this.price-comparePrice;
    }   
}
