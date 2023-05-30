package com.example.school_anagement_software.Controller;

import com.example.school_anagement_software.Model.Student;
import com.example.school_anagement_software.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        List<Student> students =studentService.getAll();
        return ResponseEntity.status(200).body(students);
    }

    @PostMapping("/add")
    public ResponseEntity add(@Valid @RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("Done added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@Valid @RequestBody Student student, @PathVariable Integer id){
      studentService.updateStudent(student,id);
        return ResponseEntity.status(200).body("Done Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
      studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("Done deleted");

    }
    @PutMapping("/{course_id}/assign/{student_id}")
    public ResponseEntity assign(@PathVariable Integer course_id,@PathVariable Integer student_id){
        studentService.assignCourseToStudent(course_id, student_id);
        return ResponseEntity.status(200).body("Assign Done");
    }
    @PutMapping("/change/{student_id}/{major}")
    public ResponseEntity changeMajor(@PathVariable Integer student_id,@PathVariable String major){
        studentService.changeMajor(student_id,major);
        return ResponseEntity.status(200).body("Change Done");
    }

    @GetMapping("/get-students-course/{course_id}")
    public ResponseEntity getStudentByCourse(@PathVariable Integer course_id){
       Set<Student> students= studentService.getAllStudentByCourse(course_id);
        return ResponseEntity.status(200).body(students);
    }





}
