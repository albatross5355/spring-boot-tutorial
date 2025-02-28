package com.example.crudtutorial.onetomany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;  // ENUM for Current/Permanent

    /*
    Bidirectional Mapping
     */
    @ManyToOne
    @JoinColumn(name = "student_id")  // Foreign Key in Address table
    @JsonBackReference  // Prevents infinite recursion
    private Student student;
}
