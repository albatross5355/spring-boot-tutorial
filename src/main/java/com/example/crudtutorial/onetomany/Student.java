package com.example.crudtutorial.onetomany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "student_id") // Foreign Key in Address table
//    private List<Address> addresses;


    /*
    Bidirectional mapping
     */
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference  // To prevent infinite recursion
    private List<Address> addresses;

       public Student(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public void addAddress(Address address) {
        addresses.add(address);
        address.setStudent(this);
    }

    /**
     * Removes an address and maintains bidirectional consistency
     */
    public void removeAddress(Address address) {
        addresses.remove(address);
        address.setStudent(null);
    }
}
