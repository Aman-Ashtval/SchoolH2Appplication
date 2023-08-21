package com.example.school.repository;
import com.example.school.model.Student;
import java.util.ArrayList;
public interface StudentRepository{

    ArrayList<Student> getStudents();
    Student addStudent(Student student);
    Student getStudentById(Integer studentId);

    Student updateStudent(Integer studentId, Student student);

    void deleteStudent(Integer studentId);
    
    String addMultipleStudents(ArrayList<Student> studentList);
}