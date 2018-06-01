/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileEdit;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Isuru
 */
public class Edit {

    public Edit(String locat, String type) {
      
boolean exit = false;
        while (!exit) {
        System.out.println("file"+type);
        String[] test = new String[12];
        String location = locat;
        ArrayList<String> single = new ArrayList<String>();
        Scanner scan;
        try {

            scan = new Scanner(new File(location.trim()));
            try {
                String line = "";

                int lineCount = 0;

                while (scan.hasNextLine()) {

                    lineCount++;

                    line = scan.nextLine();

                    System.out.println(lineCount);

                    System.out.println(line);

                }

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage().toString());
                System.out.println(e.getCause().toString());
            }
        } catch (Exception e) {
            System.out.println("Cannot open " + location);
            System.out.println("Error: " + e.getMessage().toString());
            System.out.println(e.getCause().toString());
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////    
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the Record line want to edit");
        int erase = sc.nextInt();
        boolean ers = false;

        try {

            scan = new Scanner(new File(location.trim()));
            try {
                String line = "";

                int lineCount = 0;

                while (scan.hasNextLine()) {

                    lineCount++;

                    line = scan.nextLine();

                    if (erase == lineCount) {
                       Write wr = new Write(locat,type);
                        switch (type) {
                            case "student":
                                System.out.println("Enter data without spaces");
                                System.out.println("press Enter to skip the record");

                                System.out.println("");

                                System.out.println("Enter student id:");
                                sc.nextLine();
                                String stId = sc.nextLine();
                                if (stId.equals("")) {
                                    System.out.println("you didnt enter student ID for this record");
                                    stId = "";
                                }
                                single.add(stId);
                                System.out.println("Enter first name:");

                                String fName = sc.nextLine();
                                if (fName.equals("")) {
                                    System.out.println("you didnt enter student First name for this record");
                                    fName = "";
                                }
                                single.add(fName);
                                System.out.println("Enter last name:");
                                String lName = sc.nextLine();
                                if (lName.equals("")) {
                                    System.out.println("you didnt enter student last Name for this record");
                                    lName = "";
                                }
                                single.add(lName);
                                
                                break;
                            //UnitID	UnitName	RoomNo	RoomName	LecturerName	RoomCapacity	NoOfStudentEnrolled   
                            case "lectures":
                                ers = true;
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

                                single.add(unitId);
                                System.out.println("Enter unit name:");

                                String unitName = sc.nextLine();
                                if (unitName.equals("")) {
                                    System.out.println("you didnt enter unit Name for this record");
                                    unitName = "";
                                }

                                single.add(unitName);
                                System.out.println("Enter room No:");
                                String roomNo = sc.nextLine();
                                if (roomNo.equals("")) {
                                    System.out.println("you didnt enter Room No for this record");
                                    roomNo = "";
                                }
                                single.add(roomNo);
                                System.out.println("Enter room Name:");
                                String roomName = sc.nextLine();
                                if (roomName.equals("")) {
                                    System.out.println("you didnt enter Room Name for this record");
                                    roomName = "";
                                }
                                single.add(roomName);
                                System.out.println("Enter lectute Name:");
                                String lecName = sc.nextLine();
                                if (lecName.equals("")) {
                                    System.out.println("you didnt enter lectute Name for this record");
                                    lecName = "";
                                }
                                single.add(lecName);
                                System.out.println("Enter Room capasity:");
                                String roomCap = sc.nextLine();
                                if (roomCap.equals("")) {
                                    System.out.println("you didnt enter Room capasity for this record:");
                                    roomCap = "";
                                }
                                single.add(roomCap);
                                System.out.println("Enter Number of student Enrolled:");
                                String nSe = sc.nextLine();
                                if (nSe.equals("")) {
                                    System.out.println("you didnt enter Number of student  for this record");
                                    nSe = "";
                                    single.add(nSe);
                              
                                } break;
                        
                            default:  System.out.println("enter valid file name");
                        
                        }

                        continue;

                    }
                    System.out.println(lineCount);

                    System.out.println(line);
                    String[] splitted = line.split("\t");

                    for (int i = 0; i < splitted.length; i++) {
                        single.add(splitted[i]);
                    }

                }

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage().toString());
                System.out.println(e.getCause().toString());
            }
        } catch (Exception e) {
            System.out.println("Cannot open " + location);
            System.out.println("Error: " + e.getMessage().toString());
            System.out.println(e.getCause().toString());
        }
        try (FileWriter f = new FileWriter(location.trim())) {
            //data write to file

            switch (type) {
                case "student": {
                    int t = 0;
                    for (String x : single) {
                        f.write(x + "\t");
                        t++;
                        if (t % 3 == 0) {
                            f.write("\r\n");
                        }
                    }
                }
                break;
                case "lecture": {
                    int t = 0;
                    for (String x : single) {
                        f.write(x + "\t");
                        t++;
                        if (t % 7 == 0) {
                            f.write("\r\n");
                        }
                    }
                }
                break;

            }

            System.out.println("Record edited");

        } catch (Exception e) {
            System.out.println("Error with file writing" + e.getMessage().toString());
        }
System.out.println("For Edit More records press Y:");
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
