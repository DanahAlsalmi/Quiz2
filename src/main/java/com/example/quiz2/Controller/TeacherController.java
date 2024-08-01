package com.example.quiz2.Controller;

import com.example.quiz2.Api.ApiResponse;
import com.example.quiz2.Model.Teacher;
import com.example.quiz2.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    // done
    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        return ResponseEntity.status(200).body(teacherService.getTeachers());
    }

    //done
    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully added teacher"));

    }

    //done
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable int id, @Valid @RequestBody Teacher teacher, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }
        boolean isUpdated = teacherService.updateTeacher(id, teacher);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Successfully updated teacher"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("Not found teacher"));
    }

    //done
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable int id){
        boolean isDeleted = teacherService.deleteTeacher(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Successfully deleted teacher"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("Not found teacher"));
    }

    //done
    @GetMapping("/search-id/{id}")
    public ResponseEntity searchTeacherById(@PathVariable int id){
        if(teacherService.searchTeacherById(id) != null){
            return ResponseEntity.status(200).body(teacherService.searchTeacherById(id));
        }
        return ResponseEntity.status(200).body(new ApiResponse("Not found teacher"));
    }

    //done
    @GetMapping("/search-salary/{salary}")
    public ResponseEntity searchTeacherBySalary(@PathVariable int salary){
        ArrayList<Teacher> teachers = teacherService.searchTeacherBySalary(salary);
        if(teachers.isEmpty()){
            return ResponseEntity.status(200).body(new ApiResponse("No one has this salary"));
        }
        return ResponseEntity.status(200).body(teachers);
    }

}
