/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentAttendance;

import FileEdit.EditType;
import StudentRecordManager.StudentRecord;
import java.util.Scanner;

/**
 *
 * @author Isuru
 */
public class MainMenuSelect {
     public static void main(String[] args) {
     
         boolean exit = false;
        while (!exit) {
      
       Scanner sc= new Scanner(System.in);
        System.out.println("Enter '1' to See attendance reports accordind to the units:");
        System.out.println("Enter '2' Enter/Delete/Edit records to files:");
        
        String type=sc.next();
        
        switch(type){
            
            case"1":
     StudentRecord srtd= new StudentRecord();
        break;
            case "2":
        EditType edit= new EditType();
        break;
            default: System.out.println("Enter valid action number (See Attendance report-1/ edit files-2)");
        }
        
            System.out.println("For See attendance/ edit files again Enter Y:");
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
