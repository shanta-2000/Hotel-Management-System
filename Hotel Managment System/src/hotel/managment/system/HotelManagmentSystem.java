
package hotel.managment.system;

import java.io.*;

import java.util.*;

public class HotelManagmentSystem implements Serializable {
    
    
    public static int checkadmin(String u,int p){
      char []fixu=new char[]{'s','h','a','n','t','a'};
      for(int i=0;i<7;i++){
      char c=u.charAt(i);
        if(c==fixu[i]&& p==1234){
           return 1;
           }
        else {
            System.out.println("YOU ARE NOT ADMIN");
            break;
            }
        } return 0;
    }
    public static int  availabilityofroom(int rn){
        for(int i=0;i<rlist.size();i++){
            if(rn==rlist.get(i).roomnum){
                System.out.println("Room is not available");
                return 0;
            }else
                break;
        }return 1;
    }
    
   
    
    public static ArrayList<Employee> elist= new ArrayList<Employee>();
    public static ArrayList<Room> rlist= new ArrayList<Room>();
    public static ArrayList<Customer> clist= new ArrayList<Customer>();
    
    
    
    
    public static void main(String[] args) throws Exception{
        
      
        File roomfile=new File("Rooms.txt");
        File cusfile = new File("Customer.txt");
        File emfile = new File("Employee.txt");
        ObjectOutputStream oos=null;
        ObjectInputStream ois=null;
        ListIterator li=null;
        
        
        if(emfile.isFile()){
            try{
            ois = new ObjectInputStream(new FileInputStream(emfile));
            elist=(ArrayList<Employee>)ois.readObject();
            ois.close();}
            catch(IOException ex){
                System.out.println(ex);
            }
        }
        
        if(cusfile.isFile()){
            try{
            ois = new ObjectInputStream(new FileInputStream(cusfile));
            clist=(ArrayList<Customer>)ois.readObject();
            ois.close();
            }
            catch(IOException ex){
                System.out.println(ex);
            }
            
        }
        if(roomfile.isFile()){
            try{
            ois = new ObjectInputStream(new FileInputStream(roomfile));
            rlist=(ArrayList<Room>)ois.readObject();
            ois.close();
            }
            catch(IOException ex){
                System.out.println(ex);
            }
            
        }
        
        
        Scanner inp= new Scanner(System.in);
       
        System.out.println("         \n\n\t        **********************************************************************************************************************");
        System.out.println("         \t*                                              WELCOME                                                               *");
        System.out.println("         \t*                                                 To                                                                 *");
        System.out.println("         \t*                                       HOTEL  MANAGMENT  SYSTEM                                                     *");
        System.out.println("         \t**********************************************************************************************************************");
        System.out.println("");
        System.out.println("\n\n\t\t\t\t\t\tPRESS 1 TO CONTINUE");
        System.out.println("\t\t\t\t\t\tPRESS 0 TO EXIT");
        System.out.print("\nENTER YOUR OPTION: ");
        int i=inp.nextInt();
        int run=-1;
   
        if(i==1){
        
            System.out.println("                          .................................................................................................");
            System.out.println("                          \t\t\t\tHOTEL MANAGEMENT SYSTEM DASHBOARD ");
            System.out.println("                          .................................................................................................");
            System.out.println("\t\t\t\t\t\t\t\tCONTINUE AS");
            System.out.println("\n\t\t\t\t\t\t\t\t1.ADMIN");
            System.out.println("\n\t\t\t\t\t\t\t\t2.RECEPTIONIST");
            System.out.print("\nENTER YOUR CHOICE: ");
            int d=inp.nextInt();
            switch(d){
                case 1:
                    { 
                        System.out.print("\t\t\t\t LOG IN \nUSER NAME: ");
                        String u=inp.next();
                        System.out.print("PASSWORD: ");
                        int p=inp.nextInt();
                        checkadmin(u,p);
                        if(checkadmin(u,p)==1){
                        do{
                        System.out.println("\t\t\t\t\t\t....................................");
                        System.out.println("\t\t\t\t\t\t\t\tWELCOME");
                        System.out.println("\t\t\t\t\t\t....................................");
                        System.out.println("\n\t\t\t\t\t\t1.ADD AN EMPLOYEE");
                        System.out.println("\t\t\t\t\t\t2.ADD A ROOM");
                        System.out.println("\t\t\t\t\t\t3.REMOVE AN EMPLOYEE");
                        System.out.println("\t\t\t\t\t\t4.ALL EMPLOYEE INFORMATION");
                        System.out.print("\nTAKE YOUR CHOICE: ");
                        int choice=inp.nextInt();
                        
                            
                        switch(choice)
                        {
                       
                            case 1: 
                                   System.out.println("HOW MANY EMPLOYEE YOU WANT TO ADD?");
                                   int num=inp.nextInt();
                                   for(int j=0;j<num;j++){
                                   System.out.println("Enter Employees name:");
                                   String n=inp.next();
                                   System.out.println("Enter Employee age:");
                                   int ag=inp.nextInt();
                                   System.out.println("Enter Emplyee gender: "); 
                                   String g=inp.next();
                                   System.out.println("Enter Emplyee id: "); 
                                   int id=inp.nextInt();
                                   System.out.println("Enter phone number: ");
                                   int ph=inp.nextInt();
                                   System.out.println("Enter salary: ");
                                   double s=inp.nextDouble();
                                   System.out.println("Enter employee profession: ");
                                   String pro=inp.next();
                                   elist.add(new Employee(n,ag,g,id,ph,s,pro));
                                   
                                   System.out.println("SUCESSFULLY ADDED THE EMPLOYEE");     
                                   
                                   }try{
                                    oos=new ObjectOutputStream(new FileOutputStream(emfile));
                                    oos.writeObject(elist);
                                    oos.close();
                                   }catch(IOException ex){
                                       System.out.println(ex);
                                   }
                                    break;
                            case 2: System.out.println("HOW MANY ROOM YOU WANT TO ADD?");
                                   int n=inp.nextInt();
                                   for(int j=0;j<n;j++){
                                   System.out.println("Enter Room no:");
                                   int no=inp.nextInt();
                                   System.out.println("Enter Room Quality:");
                                   String q=inp.next();
                                   System.out.println("Enter Price: ");
                                   double pr=inp.nextDouble();
                                   
                                   rlist.add(new Room(no,q,pr));
                                   
                                   System.out.println("SUCESSFULLY ADDED THE ROOM");     
                                   
                                   }try{
                                    oos=new ObjectOutputStream(new FileOutputStream(roomfile));
                                    oos.writeObject(rlist);
                                    oos.close();
                                   }catch(IOException ex){
                                       System.out.println(ex);
                                   }
                                    break;
                            
                            case 3:if(emfile.isFile()){
                                    try{
                                      ois = new ObjectInputStream(new FileInputStream(emfile));
                                      elist=(ArrayList<Employee>)ois.readObject();
                                      ois.close();
                                      
                                     
                                      System.out.println("Enter employee id: ");
                                      int id=inp.nextInt();
                                      
                                      li = elist.listIterator();
                                      while(li.hasNext())
                                      {
                                      Employee e=(Employee)li.next();
                                      if(e.id==id)
                                      {
                                          li.remove();
                                          System.out.println("Remove Successfully...............");
                                      } 
                                      }oos=new ObjectOutputStream(new FileOutputStream(emfile));
                                       oos.writeObject(elist);
                                       oos.close();
                                    }catch(IOException | ClassNotFoundException e){
                                              System.out.println(e);
                                              }
                                      
                            }
                                   break;
                            case 4:
                                 li = elist.listIterator();
                                 while(li.hasNext()){
                                 System.out.println("........................................................................................................................");
                                 System.out.println(li.next());
                                 System.out.println("........................................................................................................................");
                                 }
                                  break;
                            }
                        }while(run!=0);
                        
                        }
                    }break;

                case 2: do
                {
                       System.out.println("\n\n\t1.NEW CUSTOMER FORM");
                       System.out.println("\t2.ROOMS");
                       System.out.println("\t3.ALL CUSTOMER INFORMATION");
                       System.out.println("\t4.SEARCH A CUSTOMER");
                       System.out.println("\t5.CHECKOUT");
                       System.out.println("\t6.MANAGER INFORMATION");
                       System.out.println("\nENTER YOUR OPTION:");
                       int input=inp.nextInt();
                
                       if(input==1)
                       {    System.out.println("HOW MANY CUSTOMER YOU WANT TO ADD?");
                                   int num=inp.nextInt();
                                   for(int j=0;j<num;j++){

                           System.out.println("Enter form no: ");
                           int fn=inp.nextInt();
                           System.out.println("Enter Customer name: ");
                           String n= inp.next();
                           System.out.println("Enter Customer age:");
                           int ag=inp.nextInt();
                           System.out.println("Enter Customer gender: "); 
                           String g=inp.next();
                           System.out.println("Enter Customer address: ");  
                           String addr= inp.next();
                           System.out.println("Enter Customer Email: ");  
                           String mail= inp.next();
                           System.out.println("Enter Customer NID no:");
                           int id=inp.nextInt();
                           System.out.println("Enter phone number: ");
                           int ph=inp.nextInt();
                           System.out.println("Enter Room quality: ");
                           String q=inp.next();
                           if("luxury".equals(q))
                           {
                            System.out.println("There is 3 rooms(1001,1002,1003)");
                            System.out.println("Price: 50000TK");
                           }
                           else if("single".equals(q))
                           {
                            System.out.println("There is 3 rooms(2001,2002,2003)");
                            System.out.println("Price: 10000TK");
                           }
                           else if("double".equals(q))
                           {
                            System.out.println("There is 3 rooms(3001,3002,3003)");
                            System.out.println("Price: 25000TK");
                           }
                           if(roomfile.isFile()){
                           try{
                           ois = new ObjectInputStream(new FileInputStream(roomfile));
                           rlist=(ArrayList<Room>)ois.readObject();
                           ois.close();
                           }
                           catch(IOException ex){
                                 System.out.println(ex);
                           }
            
                          }
                           System.out.println("Enter Room number: ");
                           int r=inp.nextInt();
                           if(availabilityofroom(r)==0){
                               System.out.println("Enter room number again");
                               int p=inp.nextInt();
                               r=p;
                           } 
                           
                            System.out.println("Enter the price: ");
                            double pr=inp.nextDouble();
                            Room r1= new Room(r,q,pr);
                            rlist.add(r1);
                            clist.add(new Customer(fn,n,ag,g,addr,id,mail,ph,r1));
                            System.out.println("SUCESSFULLY ADDED THE CUSTOMER");
                            }try
                            {
                             oos=new ObjectOutputStream(new FileOutputStream(cusfile));
                             oos.writeObject(clist);
                             oos.close();
                             }catch(IOException ex){
                                System.out.println(ex);
                             }
                        }
                        if(input==2)
                        {   
                                 li = rlist.listIterator();
                                 while(li.hasNext()){
                                 System.out.println("........................................................................................................................");
                                 System.out.println(li.next());
                                 System.out.println("........................................................................................................................");
                                 }
                        }
                            
                        if(input==3)
                        {
                                 li = clist.listIterator();
                                 while(li.hasNext()){
                                 System.out.println("..........................................................................................................................................................................");
                                 System.out.println(li.next());
                                 System.out.println("..........................................................................................................................................................................");
                                 }
                        }
                        if(input==4)
                        {   
                            if(cusfile.isFile()){
                                    try{
                                      ois = new ObjectInputStream(new FileInputStream(cusfile));
                                      clist=(ArrayList<Customer>)ois.readObject();
                                      ois.close();
                                      
                                     
                                      System.out.println("Enter customer form no: ");
                                      int cusid=inp.nextInt();
                                      System.out.println("................................................................................................................................................................");
                                      
                                      li = clist.listIterator();
                                      while(li.hasNext())
                                      {
                                      Customer c=(Customer)li.next();
                                      if(c.formno==cusid)
                                      {
                                      System.out.println(c);
                                      System.out.println(".................................................................................................................................................................");
                                      }else {
                                          System.out.println("Customer is not found");
                                          break;
                                      } 
                                      }oos=new ObjectOutputStream(new FileOutputStream(cusfile));
                                       oos.writeObject(clist);
                                       oos.close();
                                    }catch(IOException | ClassNotFoundException e){
                                              System.out.println(e);
                                              }
                                      
                            }
                        }
                        if(input==5)
                        {if(cusfile.isFile()){
                                    try{
                                      ois = new ObjectInputStream(new FileInputStream(cusfile));
                                      clist=(ArrayList<Customer>)ois.readObject();
                                      ois.close();
                                      
                                     
                                      System.out.println("Enter room no: ");
                                      int n=inp.nextInt();
                                      
                                      li = clist.listIterator();
                                      while(li.hasNext())
                                      {
                                      Customer c=(Customer)li.next();
                                      if(c.r.roomnum==n)
                                      {
                                      li.remove();
                                          System.out.println("Checkout Successful.......");
                                      } 
                                      }
                                      
                                    }catch(IOException | ClassNotFoundException e){
                                              System.out.println(e);
                                              }
                                      
                            }
                        }
                        
                        if(input==6)
                        {
                            File m=new File("/C:/Users/User/OneDrive/Documents/NetBeansProjects/Hotel Managment System/src/manager.txt");
                            Scanner sc=new Scanner(m);
                            while(sc.hasNextLine()){
                                System.out.println(sc.nextLine());
                            }
                        }
                    
                }while(run!=0);
                
            }
        }
        
    }
}
    

       


   
