package com.example.crudtutorial.controller;


import com.example.crudtutorial.entity.Student;
import com.example.crudtutorial.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        try {
            return ResponseEntity.ok(studentService.updateStudent(id, updatedStudent));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    // 1. Find students by name (Containing search)
    @GetMapping("/searchByName/{name}")
    public List<Student> findByNameContaining(@PathVariable String name) {
        return studentService.findByNameContaining(name);
    }

    // 2. Find students older than a certain age
    @GetMapping("/olderThan/{age}")
    public List<Student> findByAgeGreaterThan(@PathVariable int age) {
        return studentService.findByAgeGreaterThan(age);
    }

    // 3. Count students by email domain
    @GetMapping("/countByDomain/{domain}")
    public long countStudentsByEmailDomain(@PathVariable String domain) {
        return studentService.countStudentsByEmailDomain(domain);
    }

    // 4. Find students with a specific email domain (Native Query)
    @GetMapping("/findByDomain/{domain}")
    public List<Student> findStudentsByEmailDomain(@PathVariable String domain) {
        return studentService.findStudentsByEmailDomain(domain);
    }

    // 5. Delete students by name
    @DeleteMapping("/deleteByName/{name}")
    public ResponseEntity<Void> deleteStudentsByName(@PathVariable String name) {
        studentService.deleteStudentsByName(name);
        return ResponseEntity.noContent().build();
    }
}
