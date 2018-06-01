/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentRecordManager;

import StudentRecordManager.objects.Attendance;
import StudentRecordManager.objects.Lecture;
import StudentRecordManager.objects.Student;



/**
 *
 * @author Isuru
 */
public class StudentRecord {
 
   public StudentRecord(){
    String LONGLINE = "---------------------------------";
    
    /**
     * @param args the command line arguments
     */ 
    //public static void main(String[] args) {
        // TODO code application logic here
        
        //read files using tabbedreader class
        TabbedReader tr_student = new TabbedReader("D:\\txts\\studentsdetails.txt",1);
        TabbedReader tr_lecture = new TabbedReader("D:\\txts\\lecturer.txt",1);
        TabbedReader tr_attendance = new TabbedReader("D:\\txts\\attendancelog.txt",1);
        //create new lecture record object
        //pass values to array and to the particullar class object
        LectureRecords lr = new LectureRecords();
        lr.convertToArrayList(tr_lecture.getValues(),"Lecture" );
        lr.convertToArrayList(tr_student.getValues(), "Student");
        lr.convertToArrayList(tr_attendance.getValues(), "Attendance");
        //print attendance report 
        
        for (Lecture lec : lr.getAl_lec()) {
             System.out.println(LONGLINE); 
             //get data according to the unitID
             System.out.println("Unit : \t"+lec.getUnitId());   
             System.out.println("Unit Name : \t"+lec.getUnitName());
             System.out.println("Room : \t"+lec.getRoomNo());
             System.out.println("Name : \t"+lec.getRoomName());
             System.out.println("Lecture :\t"+lec.getLectureName());

             for(Attendance at: lr.findAttendance(lec.getUnitId())){
                System.out.println("Week# : \t"+String.format("%02d", at.getWeekNo()));
                System.out.println("Date : \t"+at.getDate());
                break;
             }
             System.out.println();
             //student attendance table
             System.out.format("%-14s%-14s%-14s%-14s\n","Student No","Last Name","First Name","Present");
             System.out.println();
             for(Student st : lr.getAl_stu()){
                 //Student No. Last Name First Name Present
                  System.out.format("%-14s%-14s%-14s",st.getStudentNo(),st.getLastName(),st.getFirstName());
              
                 if(lr.getStudentPresent(lec.getUnitId(), st.getStudentNo())){
                     System.out.print("  Y");
                 }else{
                     System.out.print("  N");
                 }
                 System.out.println();
             }
             
             System.out.println();
             System.out.println("Lecturer confirmed attendance :\tYes/No");
             System.out.println("Students Enrolled :\t"+lec.getStudentCount());
             System.out.println("Attendance :\t"+lr.findAttendance(lec.getUnitId()).size());
             System.out.println("Room capacity :\t"+lec.getRoomCapacity());
             System.out.println("Percentage occupancy :\t"+String.format("%.2f", (100.0*lr.findAttendance(lec.getUnitId()).size()/lec.getRoomCapacity()))+"%");
//end of the report for the unit
             System.out.println(LONGLINE);
        }
    }
}
