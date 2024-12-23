
package hotel.managment.system;

import java.io.Serializable;


public class person implements Serializable {
     String name;
     int age;
     String gender;

    person(){
        
    }
    person(String name,int age,String gender){
    this.name=name;
    this.age=age;
    this.gender=gender;
  
    }

   
    
    @Override
    public String toString() {
        return "person{" + "name=" + name + ", age=" + age + ", gender=" + gender + '}';
    }
    
}
