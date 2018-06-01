/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentRecordManager.objects;



public class Student {

    //declare private instance variables
    private String studentNo;
    private String firstName;
    private String lastName;

    
    // create geter and setter methods for access variables
    public String getStudentNo() {
        return studentNo;
    }

    
    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    
    public String getFirstName() {
        return firstName;
    }

   
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    public String getLastName() {
        return lastName;
    }

    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
