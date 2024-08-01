package com.example.quiz2.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @NotNull(message = "Id should not be NULL")
    @Min(value = 2 , message = "Id must be 2 or more")
    @Positive(message = "ID should be positive")
    private int id;

    @NotEmpty(message = "Name should not be Empty")
    @Size(min = 2, max = 20 ,message = "The name should be between 2 - 20 Character")
    private String name;

    @NotEmpty(message = "Age should not be Empty")
    @Min(value = 18, message = "Minimum Age is 18")
    private String age;

    @NotEmpty(message = "major should not be Empty")
    @Size(min = 2, max = 30 ,message = "The major should be between 2 - 30 Character")
    private String major;
}
