package com.example.quiz2.Service;

import com.example.quiz2.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher> teachers = new ArrayList<>();
    //Get - done
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    // Add teachers - done
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    //Update teacher - done
    public boolean updateTeacher(int id ,Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.set(i, teacher);
                return true;
            }
        }
        return false;
    }

    //Delete teacher - done
    public boolean deleteTeacher(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

    //Search by id
    public Teacher searchTeacherById(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                return teachers.get(i);
            }
        }
        return null;
    }

    // salary
    public ArrayList<Teacher> searchTeacherBySalary(int salary) {
        ArrayList<Teacher> salaries = new ArrayList<>();
        for (Teacher teacher : teachers) {
            if (teacher.getSalary() == salary ||teacher.getSalary() >= salary) {
                salaries.add(teacher);
            }
        }
        return salaries;
    }
}
