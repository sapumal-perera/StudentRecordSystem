/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentRecordManager.objects;



public class Attendance {
//declare private instance varibles 
    private String roomNo;
    private String studentId;
    private String unitId;
    private String lectureName;
    private String date;
    private int weekNo;

   
    // create geter and setter methods for access variables
    public String getRoomNo() {
        return roomNo;
    }

   
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

   
    public String getStudentId() {
        return studentId;
    }

    
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

   
    public String getUnitId() {
        return unitId;
    }

    
    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    
    public String getLectureName() {
        return lectureName;
    }

   
    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

  
    public String getDate() {
        return date;
    }

   
    public void setDate(String date) {
        this.date = date;
    }

    
    public int getWeekNo() {
        return weekNo;
    }

    
    public void setWeekNo(int weekNo) {
        this.weekNo = weekNo;
    }

}
