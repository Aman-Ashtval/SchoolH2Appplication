package com.example.school.model;

public class Student{
    private Integer studentId;
    private String studentName;
    private String gender;
    private int standard;

    public Student(Integer studentId, String studentName, String gender, int standard){
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
        this.standard = standard;
    }

    public void setStudentId(Integer studentId){
        this.studentId = studentId;
    }
    public int getStudentId(){
        return this.studentId;
    }

    public void setStudentName(String studentName){
        this.studentName = studentName;
    }
    public String getStudentName(){
        return this.studentName;
    }

    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return this.gender;
    }

    public void setStandard(int standard){
        this.standard = standard;
    }
    public int getStandard(){
        return this.standard;
    }
}