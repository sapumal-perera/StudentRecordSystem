/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentRecordManager;

import StudentRecordManager.objects.Attendance;
import StudentRecordManager.objects.Lecture;
import StudentRecordManager.objects.Student;
import java.util.ArrayList;

public class LectureRecords {

    // araay list to store particullar class object values
    private ArrayList<Lecture> al_lec = new ArrayList<Lecture>();
    private ArrayList<Student> al_stu = new ArrayList<Student>();
    private ArrayList<Attendance> al_att = new ArrayList<Attendance>();

    //this method is for find attendance from attendance clss
    public ArrayList<Attendance> findAttendance(String unitID) {
        ArrayList<Attendance> present_students = new ArrayList<Attendance>();
        for (Attendance at : al_att) {
            if (at.getUnitId().trim().equalsIgnoreCase(unitID)) {
                present_students.add(at);
            }
        }
        return present_students;
    }
//this method is for find present students from student class

    public ArrayList<Student> findPresentStudents(String unitID) {
       ArrayList<Student> present_students = new ArrayList<Student>();

       for (Attendance at : al_att) {
          if (at.getUnitId().trim().equalsIgnoreCase(unitID)) {
               present_students.add(getStudentByID(at.getStudentId()));
           }
        }
       return present_students;
   }

    //this method for get studend by student ID from student class
    public Student getStudentByID(String ID) {
        for (Student st : al_stu) {
            if (st.getStudentNo().trim().equalsIgnoreCase(ID)) {
                return st;
            }
        }
        return null;
    }

    //this method is for find each studens attend the particular unit
    public boolean getStudentPresent(String UnitID, String StudentID) {
        for (Student st : findPresentStudents(UnitID)) {
            if (st.getStudentNo().trim().equalsIgnoreCase(StudentID)) {
                return true;
            }
        }
        return false;
    }

    //this method for get data that reades from file reader(tabbedReader) and set those values to class objects 
    public void convertToArrayList(ArrayList<ArrayList<String>> al, String type) {
  

        String[][] array_2d = new String[al.size()][];
        for (int i = 0; i < al.size(); i++) {
            ArrayList<String> row = al.get(i);
            array_2d[i] = row.toArray(new String[row.size()]);
        }

        for (int i = 0; i < array_2d.length; i++) {
            // switsh statement to ajust array size according to table columns and set data
            switch (type) {
                case "Lecture":
                    Lecture lecture = new Lecture();
                    //UnitID	UnitName	RoomNo	RoomName	LecturerName	RoomCapacity	NoOfStudentEnrolled
                    lecture.setUnitId(array_2d[i][0].trim());
                    lecture.setUnitName(array_2d[i][1].trim());
                    lecture.setRoomNo(array_2d[i][2].trim());
                    lecture.setRoomName(array_2d[i][3].trim());
                    lecture.setLectureName(array_2d[i][4].trim());
                    lecture.setRoomCapacity(Integer.parseInt(array_2d[i][5].trim()));
                    lecture.setStudentCount(Integer.parseInt(array_2d[i][6].trim()));

                    al_lec.add(lecture);
                    break;
                case "Student":
                    Student student = new Student();
                    //Student No.	Last Name	First Name
                    student.setStudentNo(array_2d[i][0].trim());
                    student.setLastName(array_2d[i][1].trim());
                    student.setFirstName(array_2d[i][2].trim());

                    al_stu.add(student);
                    break;
                case "Attendance":
                    //Room_No	Student_ID	Unit_ID	Lecturer_Name	Date	Week_No
                    Attendance attendance = new Attendance();
                    attendance.setRoomNo(array_2d[i][0].trim());
                    attendance.setStudentId(array_2d[i][1].trim());
                    attendance.setUnitId(array_2d[i][2].trim());
                    attendance.setLectureName(array_2d[i][3].trim());
                    attendance.setDate(array_2d[i][4].trim());
                    attendance.setWeekNo(Integer.parseInt(array_2d[i][5].trim()));

                    al_att.add(attendance);
                    break;
            }

        }
    }

    public ArrayList<Lecture> getAl_lec() {
        return al_lec;
    }

    public void setAl_lec(ArrayList<Lecture> al_lec) {
        this.al_lec = al_lec;
    }

    public ArrayList<Student> getAl_stu() {
        return al_stu;
    }

    public void setAl_stu(ArrayList<Student> al_stu) {
        this.al_stu = al_stu;
    }

    public ArrayList<Attendance> getAl_att() {
        return al_att;
    }

    public void setAl_att(ArrayList<Attendance> al_att) {
        this.al_att = al_att;
    }
}
