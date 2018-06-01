/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileEdit;

import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Isuru
 */
public class Write {

    public Write(String locat, String type) {
        //this variable for decide exit or re enter data
        boolean exit = false;
        while (!exit) {
            Scanner sc = new Scanner(System.in);
            //user have to choose the file to enter the records
            /// System.out.println("Which file do you want enter records (student/lectures)? ");
            // String type = sc.next();
            //switch statement to open file and create file write writer according to users choice
            switch (type) {
                case "student":
// get data for records from user
                    System.out.println("Enter data without spaces");
                    System.out.println("press Enter to Start the record Enter");

                   System.out.println("");
                    sc.nextLine();
                    System.out.println("Enter student id:");
                         
                    String stId = sc.nextLine();
                    if (stId.equals("")) {
                        System.out.println("you didnt enter student ID for this record");
                        stId = "";
                    }
                    System.out.println("Enter first name:");

                    String fName = sc.nextLine();
                    if (fName.equals("")) {
                        System.out.println("you didnt enter student First name for this record");
                        fName = "";
                    }
                    System.out.println("Enter last name:");
                    String lName = sc.nextLine();
                    if (lName.equals("")) {
                        System.out.println("you didnt enter student last Name for this record");
                        lName = "";
                    }
// create file writer object
                    try (FileWriter f = new FileWriter("D:\\txts\\studentsdetails.txt", true)) {
                        //data write to file
                        f.write("\t\r\n" + stId);
                        f.write("\t" + fName);
                        f.write("\t" + lName);
                        System.out.println("Record created");
                    } catch (Exception e) {
                        System.out.println("Error with file writing" + e.getMessage().toString());
                    }
                    break;
                case "lectures":
                    //get data from user
                    System.out.println("Enter data without spaces");
                    System.out.println(" press Enter to skip the record");
                    System.out.println("");
                    sc.nextLine();
//UnitID	UnitName	RoomNo	RoomName	LecturerName	RoomCapacity	
                    System.out.println("Enter unit ID:");
                    String unitId = sc.nextLine();
                    if (unitId.equals("")) {
                        System.out.println("you didnt enterUnit ID for this record");
                        unitId = "";
                    }
                    System.out.println("Enter unit name:");

                    String unitName = sc.nextLine();
                    if (unitName.equals("")) {
                        System.out.println("you didnt enter unit Name for this record");
                        unitName = "";
                    }
                    System.out.println("Enter room No:");
                    String roomNo = sc.nextLine();
                    if (roomNo.equals("")) {
                        System.out.println("you didnt enter Room No for this record");
                        roomNo = "";
                    }
                    System.out.println("Enter room Name:");
                    String roomName = sc.nextLine();
                    if (roomNo.equals("")) {
                        System.out.println("you didnt enter Room Name for this record");
                        roomNo = "";
                    }
                    System.out.println("Enter lectute Name:");
                    String lecName = sc.nextLine();
                    if (lecName.equals("")) {
                        System.out.println("you didnt enter lectute Name for this record");
                        lecName = "";
                    }
                    System.out.println("Enter Room capasity:");
                    String roomCap = sc.next();
                    if (roomCap.equals("0")) {
                        System.out.println("you didnt enter Room capasity for this record:");
                        roomCap = "";
                    }
                    System.out.println("Enter Number of student Enrolled:");
                    String nSe = sc.nextLine();
                    if (nSe.equals("")) {
                        System.out.println("you didnt enter Number of student  for this record");
                        nSe = "";
                    }
//create file writer object
                    try (FileWriter f = new FileWriter("D:\\txts\\lecturer.txt", true)) {
                        //data write to file
                        f.write("\t\r\n" + unitId);
                        f.write("\t" + unitName);
                        f.write("\t" + roomNo);
                        f.write("\t" + roomName);
                        f.write("\t" + lecName);
                        f.write("\t" + roomCap);
                        f.write("\t" + nSe);
                        System.out.println("Record created");

                    } catch (Exception e) {
                        System.out.println("Error with file writing" + e.getMessage().toString());

                    }
                    break;

                default: {
                    System.out.println("please enter valid file name");
                }
            }
            //decide re enter data or not
            System.out.println("For enter More records press Y:");
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
