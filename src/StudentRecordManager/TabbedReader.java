/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentRecordManager;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;



public class TabbedReader {
    //array list values for store each word in file
    private ArrayList<ArrayList<String>> values = new ArrayList<ArrayList<String>>();
    //can read files using method tabbedreader
    public TabbedReader(String location,int skip){
        Scanner scan;
        try{
            //scan variable for  scan the file
            scan =new Scanner(new File(location.trim()));
            try{
                String line="";
                String readline = scan.nextLine();
               // line cout to identify wich line is reading
                int lineCount=0;
                //do this while file has records(lines)
                while (scan.hasNextLine())
                {
                    // when read a line increase the line count
                    lineCount++;
                    //skip is a argument for this method.
                    //int skip is for skipping the table headings 
                    //if line==int skip stop that particular idration
                    if(lineCount==skip){
                        continue;
                    }
                   //else execute follows
                    line = scan.nextLine();
                    //split method for seperate each words
                    // in this programme words are separated by tab space
                    String[] splitted=line.split("\t");
                    //add each words to single array list
                    ArrayList<String> single = new ArrayList<String>();
                    for(int i=0;i<splitted.length;i++){
                        single.add(splitted[i]);
                    }
                    //add single array list to main values array list
                    values.add(single);
//                    System.out.println(line);
                    
                }
            
            }catch(Exception e){
                // if error occured get message from jvm and show it.
                System.out.println("Error: "+e.getMessage().toString());
               
            }
        }catch(Exception e){
            System.out.println("Cannot open "+location);
            System.out.println("Error: "+e.getMessage().toString());
         
        }
        //to identify how many records are read by each file
        System.out.println(values.size()+" records read from "+location);
    }
    //this method for return data in values
    public ArrayList<ArrayList<String>> getValues(){
        return this.values;
    }
}