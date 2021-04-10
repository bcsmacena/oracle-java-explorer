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
public class Customer {
    private String name;
    private String size;
    private Clothing[] items;
    
    public void addItems(Clothing[] someItems) {
        items = someItems;
    }
    
    public Clothing[] getItems(){
        return items;
    }
    
    public double getTotalClothingCost(){
        double total = 0.0
                ;
        for(Clothing item: items) { 
          //  if(this.getSize().equals(item.getSize())) {
                total += item.getPrice();
         }
        //}
        return total;
    }

    public Customer(String name, int measurement) {
        this.name = name;
        setSize(measurement);
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    
    public void setSize(int size) {
        switch(size){
            case 1: case 2: case 3: 
                this.size = "S";
                break;
            case 4: case 5: case 6: 
                this.size = "M";
                break;
            case 7: case 8: case 9: 
                this.size = "L";
                break;
            default: this.size = "X";
        }
    }
    
}
