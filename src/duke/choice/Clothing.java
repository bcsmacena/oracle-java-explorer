/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duke.choice;

/**
 *
 * @author lpi1
 */



public class Clothing implements Comparable<Clothing> {
    private String description;
    private String size = "M";
    private double price;
    public final static double MIN_PRICE = 10.0;
    public final static double TAX_RATE = 0.2;

    @Override
    public String toString() {
        return getDescription() + ", " + getSize() + ", " + getPrice();
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price * (1 + TAX_RATE);
    }

    public Clothing(String description, double price, String size) {
        this.description = description;
        this.price = price;
        this.size = size;
    }

    public void setPrice(double price) {
        this.price = (price < MIN_PRICE) ? MIN_PRICE : price;
    }
    
    @Override
    public int compareTo(Clothing c){
        return this.description.compareTo(c.description);
    }
}
