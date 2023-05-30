package com.example.school_anagement_software.Service;

import com.example.school_anagement_software.ApiException.ApiException;
import com.example.school_anagement_software.Model.Course;
import com.example.school_anagement_software.Model.Student;
import com.example.school_anagement_software.Repository.CourseRepository;
import com.example.school_anagement_software.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    //All CRUD

    public List<Student>getAll(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Student student, Integer id){
        Student old=studentRepository.findStudentById(id);
        if (old==null){
            throw new ApiException("Not updated");

        }
        old.setId(student.getId());
        old.setName(student.getName());
        old.setAge(student.getAge());
        old.setMajor(student.getMajor());
        studentRepository.save(old);
    }


    public void deleteStudent(Integer id){
        Student student=studentRepository.findStudentById(id);
        if (student==null){
            throw new ApiException("Not Deleted");
        }
        studentRepository.delete(student);
    }

    public void assignCourseToStudent(Integer course_id, Integer student_id){
        Course course=courseRepository.findCourseById(course_id);
        Student student=studentRepository.findStudentById(student_id);

        if (course==null||student==null){
            throw new ApiException("Data Wrong");
        }
        course.getStudents().add(student);
        student.getCourses().add(course);

        courseRepository.save(course);
        studentRepository.save(student);
    }

    public void changeMajor(Integer student_id, String major){
        Student student=studentRepository.findStudentById(student_id);
        if (student==null) {
            throw new ApiException("not found");
        }
            student.setMajor(major);
            student.getCourses().clear();
            studentRepository.save(student);
        }

public Set<Student> getAllStudentByCourse(Integer course_id){
      return courseRepository.findCourseById(course_id).getStudents();
}


    }



