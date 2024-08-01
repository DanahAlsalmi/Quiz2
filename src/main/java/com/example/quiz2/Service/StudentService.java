package com.example.quiz2.Service;

import com.example.quiz2.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {


    ArrayList<Student> students = new ArrayList<>();

    //Get all student - done
    public ArrayList<Student> getStudents() {
        return students;
    }

    //Add Student - done
    public void addStudents(Student student) {
        students.add(student);
    }

    //Update Student - done
    public boolean updateStudent(int id,Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.set(i, student);
                return true;
            }
        }
        return false;
    }

    //Delete Student - done
    public boolean deleteStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    // Name
    public Student searchStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    //Major
    public ArrayList<Student> searchStudentByMajor(String major) {
        ArrayList<Student> majors = new ArrayList<>();
        for (Student student : students) {
            if (student.getMajor().equalsIgnoreCase(major)) {
                majors.add(student);
            }
        }
        return majors;
    }
}
