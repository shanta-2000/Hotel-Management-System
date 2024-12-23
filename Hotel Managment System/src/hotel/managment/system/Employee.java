

package hotel.managment.system;

import java.io.*;




public class Employee extends person implements Serializable{
      int id;
     int phonenum;
      double salary;
      String job;

    Employee(String name,int age,String gender,int id,int phonenum,double salary,String job){
     
        super(name,age,gender);
        this.id=id;
        this.phonenum=phonenum;
        this.salary=salary;
        this.job=job;
    }

  
    

    @Override
    public String toString() {
        return "Name: " + name + "   Age: " +age + "   Gender: " + gender + "   ID:" + id + "   Phone no: " + phonenum + "   Salary: " + salary + "   Job: " + job;
    }
  
    
}
