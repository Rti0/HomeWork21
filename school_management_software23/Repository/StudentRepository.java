package com.example.school_anagement_software.Repository;

import com.example.school_anagement_software.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findStudentById(Integer id);
}
