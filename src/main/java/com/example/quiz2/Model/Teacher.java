package com.example.quiz2.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {

    @NotNull(message = "Id Should not be NULL")
    @Min(value = 2, message = "Id must be 2 or more")
    @Positive(message = "ID should be positive")
    private int id;

    @NotEmpty(message = "Name should not be Empty")
    @Size(min = 2, max = 20 ,message = "The name should be between 2 - 20 Character")
    private String name;

    @NotNull(message = "Salary Should not be NULL")
    @Min(5000)
    @Positive(message = "The salary should be positive ")
    private int salary;


}
