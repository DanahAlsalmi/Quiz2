package com.example.quiz2.Controller;

import com.example.quiz2.Api.ApiResponse;
import com.example.quiz2.Model.Student;
import com.example.quiz2.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    //done
    @GetMapping("/get")
    public ResponseEntity getStudent(){
        return ResponseEntity.status(200).body(studentService.getStudents());
    }

    //done
    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.addStudents(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added successfully"));
    }

    //done
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id, @Valid @RequestBody Student student, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated= studentService.updateStudent(id,student);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Student updated successfully"));
        }
        return ResponseEntity.status(404).body(new ApiResponse("Student not found"));
    }

    //done
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id){
        boolean isDeleted= studentService.deleteStudent(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Student deleted successfully"));
        }
        return ResponseEntity.status(404).body(new ApiResponse("Student not found"));
    }

    //done
    @GetMapping("/search-name/{name}")
    public ResponseEntity searchStudentByName(@PathVariable String name){
        if(studentService.searchStudentByName(name)==null){
            return ResponseEntity.status(400).body(new ApiResponse("Student name not found"));
        }
        return ResponseEntity.status(200).body(studentService.searchStudentByName(name));
    }

    //done
    @GetMapping("/search-major/{major}")
    public ResponseEntity searchStudentByMajor(@PathVariable String major){
        ArrayList<Student> students = studentService.searchStudentByMajor(major);
        if(students.isEmpty()){
            return ResponseEntity.status(400).body(new ApiResponse("Student major not found"));
        }
        return ResponseEntity.status(200).body(studentService.searchStudentByMajor(major));
    }
}
