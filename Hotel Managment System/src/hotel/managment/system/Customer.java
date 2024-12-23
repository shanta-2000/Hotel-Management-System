/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.managment.system;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Customer extends person implements Serializable  {
     int formno;
     String address;
     String email;
     int phn;
     int nid;
     Room r;

   

   

    Customer(int formno,String name,int age,String gender,String address,int nid,String email,int phn,Room r){
        super(name,age,gender);
        this.address=address;
        this.nid=nid;
        this.email=email;
        this.formno=formno;
        this.phn=phn;
        this.r=r;
        
    }

    @Override
    public String toString() {
        return "Form no: " + formno +"   Name: " + name + "   Age: " + age+ "   Gender: " + gender + "   Address: " + address + "   Email: " + email + "   Phone no: " + phn + "   NID: " + nid + "  Room: " + r ;
    }
    
    
}
