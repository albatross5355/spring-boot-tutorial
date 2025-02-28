//package com.example.crudtutorial.onetoone;
//
//import com.example.crudtutorial.dto.StudentDTO;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/students")
//@RequiredArgsConstructor
//public class StudentController {
//
//    @Autowired
//    private StudentService studentService;
//
//    @PostMapping
//    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentDTO studentDTO) {
//        Student student = new Student(studentDTO.getName(), studentDTO.getEmail(), studentDTO.getAge());
//        if (studentDTO.getAddress() != null) {
//            Address address = new Address();
//            address.setStreet(studentDTO.getAddress().getStreet());
//            address.setCity(studentDTO.getAddress().getCity());
//            student.setAddress(address);
//        }
//        return ResponseEntity.ok(studentService.saveStudent(student));
//    }
//
////    @GetMapping
////    public ResponseEntity<Student> getStudent() {
////        Student student = new Student(studentDTO.getName(), studentDTO.getEmail(), studentDTO.getAge());
////        if (studentDTO.getAddress() != null) {
////            Address address = new Address();
////            address.setStreet(studentDTO.getAddress().getStreet());
////            address.setCity(studentDTO.getAddress().getCity());
////            student.setAddress(address);
////        }
////        return ResponseEntity.ok(studentService.saveStudent(student));
////    }
////    // Get student by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
//        Optional<Student> student = studentService.getStudentById(id);
//        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//}
