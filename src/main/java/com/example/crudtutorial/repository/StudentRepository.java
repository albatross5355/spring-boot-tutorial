package com.example.crudtutorial.repository;


import com.example.crudtutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // 1. Find students by name (case insensitive containing)
    List<Student> findByNameContainingIgnoreCase(String name);

    // 2. Find students older than a certain age
    List<Student> findByAgeGreaterThan(int age);

    // 3. Count students by email domain
    @Query("SELECT COUNT(s) FROM Student s WHERE s.email LIKE %:domain%")
    long countStudentsByEmailDomain(@Param("domain") String domain);

    // 4. Find students with a specific email domain (Using Native Query)
    @Query(value = "SELECT * FROM Student WHERE email LIKE %:domain%", nativeQuery = true)
    List<Student> findStudentsByEmailDomain(@Param("domain") String domain);

    // 5. Delete students by name
    @Modifying
    @Query(value ="DELETE from Student s WHERE s.name =:name")
    void deleteByName(@Param("name")String name);
//This will work without any condition
//    void deleteByName(String name);
}

