/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileEdit;

import java.util.Scanner;

/**
 *
 * @author Isuru
 */
public class EditType {
    public EditType(){
   // public static void main(String[] args) {
     boolean exit = false;
        while (!exit) {  
       Scanner sc= new Scanner(System.in);
        System.out.println("Enter '1' to Write new records:");
        System.out.println("Enter '2' to Delete records:");
        System.out.println("Enter '3' to Edit records:");
        String type=sc.next();
        
        switch(type){
            
            case"1":
            System.out.println("Enter file You want to Write records(student/lecture): ");
        String write=sc.next();
        if(write.equalsIgnoreCase("student")){
      Write tst= new Write("D:\\txts\\studentsdetails.txt","student");
        }
        else if(write.equalsIgnoreCase("lecture")){
       Write tst2= new Write("D:\\txts\\lecturer.txt","lecture");
       
        }
        else{ System.out.println("Enter valid file name(student/lecture): ");}
        
        break;
            
            
            
            case"2":
      
       
        
        System.out.println("Enter file You want to delet records(student/lecture): ");
        String delet=sc.next();
        if(delet.equalsIgnoreCase("student")){
      Delete tst= new Delete("D:\\txts\\studentsdetails.txt","student");
        }
        else if(delet.equalsIgnoreCase("lecture")){
       Delete tst2= new Delete("D:\\txts\\lecturer.txt","lecture");
       
        }
        else{ System.out.println("Enter valid file name(student/lecture): ");}
        
        break;
        
       
        
        
       case"3":{
       
      System.out.println("Enter file You want to edit records(student/lecture): ");
        String edit=sc.next();
        if(edit.equalsIgnoreCase("student")){
        Edit tst= new Edit("D:\\txts\\studentsdetails.txt","student");
        }
        else if(edit.equalsIgnoreCase("lecture")){
        Edit tst2= new Edit("D:\\txts\\lecturer.txt","lecture");
       
        }
        else{ System.out.println("Enter valid file name(student/lecture): ");}
       
       }
       break;
       default: System.out.println("Enter action type(Write 1/delete 2/ edit 3) ");
       
        
       
       
    }

   System.out.println("For write/delete/edit More Records press Y:");
            String reEnt = sc.next();
            if (reEnt.equalsIgnoreCase("y")) {
                exit = false;
            } else {
                exit = true;
                System.out.println("programe terminated.");
            }

        }
       
       
       
       }
   } 

