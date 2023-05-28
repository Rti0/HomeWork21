package com.example.school_anagement_software.Controller;

import com.example.school_anagement_software.ApiResponse.ApiResponse;
import com.example.school_anagement_software.Model.Teacher;
import com.example.school_anagement_software.Repository.TeacherRepository;
import com.example.school_anagement_software.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    @GetMapping("/get")
    public ResponseEntity getAll(){
        List<Teacher>teachers=teacherService.getAll();
        return ResponseEntity.status(200).body(teachers);
    }
    @PostMapping("/add")
    public ResponseEntity add(@Valid @RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("customer added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@Valid @RequestBody Teacher teacher, @PathVariable Integer id){
        teacherService.updateTeacher(teacher,id);
        return ResponseEntity.status(200).body("Done Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
     teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Done deleted");

    }
    @GetMapping("/getDetails/{id}")
public ResponseEntity getDetails(@PathVariable  Integer id){
        teacherService.getDetails(id);
        return ResponseEntity.status(200).body(teacherService.getDetails(id));
}


}
