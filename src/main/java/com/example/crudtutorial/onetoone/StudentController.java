package com.example.crudtutorial.onetoone;

import com.example.crudtutorial.dto.StudentDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentDTO studentDTO) {
        Student student = new Student(studentDTO.getName(), studentDTO.getEmail(), studentDTO.getAge());
        if (studentDTO.getAddress() != null) {
            Address address = new Address();
            address.setStreet(studentDTO.getAddress().getStreet());
            address.setCity(studentDTO.getAddress().getCity());
            student.setAddress(address);
        }
        return ResponseEntity.ok(studentService.saveStudent(student));
    }
}
