/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentRecordManager.objects;


public class Lecture {
//declare private instance varibles 
    private String unitId;
    private String unitName;
    private String roomNo;
    private String roomName;
    private String lectureName;
    private int roomCapacity;
    private int studentCount;

   // create geter and setter methods for access variables
    public String getUnitId() {
        return unitId;
    }

    
    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    
    public String getUnitName() {
        return unitName;
    }

   
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    
    public String getRoomNo() {
        return roomNo;
    }

    
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    
    public String getRoomName() {
        return roomName;
    }

   
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    
    public String getLectureName() {
        return lectureName;
    }

   
    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    
    public int getRoomCapacity() {
        return roomCapacity;
    }

    
    public void setRoomCapacity(int roomCapasity) {
        this.roomCapacity = roomCapasity;
    }

   
    public int getStudentCount() {
        return studentCount;
    }

    
    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }
    
    
}
