package com.example.crudtutorial.onetoone;

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
    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    @JsonBackReference
    private Student student; // Bidirectional reference
//
//    @OneToOne(mappedBy = "address")
//    private Student student;
}
