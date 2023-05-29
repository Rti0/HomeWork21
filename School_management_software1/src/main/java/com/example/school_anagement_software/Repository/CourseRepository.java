package com.example.school_anagement_software.Repository;

import com.example.school_anagement_software.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CourseRepository extends JpaRepository<Course,Integer> {
    Course findCourseById(Integer id);


}
