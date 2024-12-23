
package hotel.managment.system;

import java.io.*;



public class Room implements Serializable  {
     int roomnum;
     String quality;
     double price;
    
    
    Room(int roomnum,String quality,double price){
    this.roomnum=roomnum;
    this.quality=quality;
    this.price=price; 
    }

    
    
    @Override
    public String toString() {
        return "Room no:" + roomnum + " Quality: " + quality + " price: " + price + '}';
    }
    
       
        
                
        
    
    
}
