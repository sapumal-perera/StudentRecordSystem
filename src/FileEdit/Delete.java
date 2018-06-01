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
public class Delete {
    
public Delete(String locat,String type){
    boolean exit = false;
     while (!exit) {
       // String[] test = new String[12];
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
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the Record line want to erase");
        int erase = sc.nextInt();
        boolean ers = false;
        location = locat;

        try {

            scan = new Scanner(new File(location.trim()));
            try {
                String line = "";

                int lineCount = 0;

                while (scan.hasNextLine()) {

                    lineCount++;

                    line = scan.nextLine();
                   
                    if (erase == lineCount) {
                        ers = true;
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
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try (FileWriter f = new FileWriter(location.trim())) {
            //data write to file
          switch(type){
              case "student":  {   int t=0;
                for(String x:single){
                f.write(x+"\t");
                t++;
                if(t%3==0){
                f.write("\r\n");
                }
                }}
              break;
              case "lecture":  {   
                  int t=0;
                for(String x:single){
                f.write(x+"\t");
                t++;
                if(t%7==0){
                f.write("\r\n");
                }
                 }}
              break;
      
}

            System.out.println("Record deleted");
        } catch (Exception e) {
            System.out.println("Error with file writing" + e.getMessage().toString());
        }
 System.out.println("For delete More records press Y:");
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

