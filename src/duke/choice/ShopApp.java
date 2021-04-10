/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duke.choice;

import java.util.Arrays;

import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;
import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 *
 * @author lpi1
 */
public class ShopApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        double total;
        
        System.out.println("Welcome to Duke Choice Shop!");
        Customer c1 = new Customer("Pinky", 3);

        System.out.println(c1.getName());
        
        System.out.println("Min Price " + Clothing.MIN_PRICE);

        Clothing item1 = new Clothing("Blue Jacket", 20.9, "M");
        Clothing item2 = new Clothing("Orange T-Shirt", 10.5, "S");
        Clothing item3 = new Clothing("Green Scarf", 5, "S");
        Clothing item4 = new Clothing("Blue T-Shirt", 10.5, "S");
        
        Clothing[] items = {item1, item2, item3, item4};
        
        try{
            ItemList list = new ItemList(items);
            Routing routing = Routing.builder()
                    .get("/items", list).build();
            ServerConfiguration config = ServerConfiguration.builder()
                    .bindAddress(InetAddress.getLocalHost())
                    .port(8888).build();
            WebServer ws = WebServer.create(config, routing);
            ws.start();
        } catch (UnknownHostException ex){
            ex.printStackTrace();
        }
        
        
        
        c1.addItems(items);
        
        System.out.println("Customer is " + c1.getName() + ", Size: " + c1.getSize());
        
        for(Clothing item: c1.getItems()) { 
            System.out.println(item);
        }
        
        total = c1.getTotalClothingCost();
        
        System.out.println("Total: " + total);
        
        int average = 0;
        int count = 0;
        
        for(Clothing item: c1.getItems()){
            count++;
            average += item.getPrice();
           
        }
        
        try {
            average = (count == 0) ? 0 : average/count;
            average /= count;
            System.out.println("Average price " + average + ", Count " + count);
        } catch (ArithmeticException e){
            System.out.println("Don't divide by 0");
        }
        
        Arrays.sort(c1.getItems());
        
        for(Clothing item: c1.getItems()) { 
            System.out.println(item);
        }
    }
    
   
    
    
    
}
