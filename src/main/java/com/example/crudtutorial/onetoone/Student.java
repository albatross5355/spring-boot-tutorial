//package com.example.crudtutorial.onetoone;
//
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Student {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//    private String email;
//    private int age;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JsonManagedReference
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
//    private Address address;
//
//       public Student(String name, String email, int age) {
//        this.name = name;
//        this.email = email;
//        this.age = age;
//    }
//    public void setAddress(Address address) {
//        this.address = address;
//        address.setStudent(this);  // Maintain bidirectional consistency
//    }
//}
//
