package com.example.crudtutorial.controller;



import com.example.crudtutorial.dto.StudentDTO;
import com.example.crudtutorial.entity.Student;
import com.example.crudtutorial.service.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@Tag(name = "Student API", description = "Manage student data")

@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Get all students
    @GetMapping
    @Operation(summary = "Get all students", description = "Fetch a list of all students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create new student
    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentDTO studentDTO) {
        Student student = new Student(studentDTO.getName(), studentDTO.getEmail(), studentDTO.getAge());
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    // Update student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @Valid @RequestBody StudentDTO studentDTO) {
        try {
            Student updatedStudent = new Student(studentDTO.getName(), studentDTO.getEmail(), studentDTO.getAge());
            return ResponseEntity.ok(studentService.updateStudent(id, updatedStudent));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}



