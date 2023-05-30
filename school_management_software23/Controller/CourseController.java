package com.example.school_anagement_software.Controller;

import com.example.school_anagement_software.Model.Course;
import com.example.school_anagement_software.Service.CourseService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;


    @GetMapping("/getCourse")
    public ResponseEntity getAllCourses(){
        List<Course> courseList=courseService.getAllCourses();
        return ResponseEntity.status(200).body(courseList);
    }

   @PostMapping("/AddCourse")
    public ResponseEntity addNewCourse(@PathVariable Course course ){
    courseService.addNewCourse(course);
       return ResponseEntity.status(200).body("Done Add");
   }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@Valid @RequestBody Course course, @PathVariable Integer id){
      courseService.updateCourse(course, id);
        return ResponseEntity.status(200).body("Done Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
   courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("Done deleted");

    }

    @PutMapping("/assign/{teacher_id}/{course_id}")
    public ResponseEntity assignTeacherToCourse(@PathVariable Integer teacher_id,@PathVariable Integer course_id){
        courseService.assignTeacherToCourse(teacher_id, course_id);
        return ResponseEntity.status(200).body("Done assign");
    }

    @GetMapping("/teacher-course/{course_id}")
    public ResponseEntity teacherNameForClass(@PathVariable Integer course_id ){
        courseService.teacherNameForClass(course_id);
        return ResponseEntity.status(200).body(courseService.teacherNameForClass(course_id));
    }

}

