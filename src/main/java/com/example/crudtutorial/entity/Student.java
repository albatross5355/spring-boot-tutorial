package com.example.crudtutorial.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int age;
}
//1.javax validations
//2. swagger
//3. ExceptionalHandler
// Logging
// Liquibase
//security


