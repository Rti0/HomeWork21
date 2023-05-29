package com.example.school_anagement_software.Service;


import com.example.school_anagement_software.ApiException.ApiException;
import com.example.school_anagement_software.Model.Course;
import com.example.school_anagement_software.Model.Teacher;
import com.example.school_anagement_software.Repository.CourseRepository;
import com.example.school_anagement_software.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    public List<Course>getAllCourses(){
       return courseRepository.findAll();
    }
public void addNewCourse(Course course){
    courseRepository.save(course);
}


public void updateCourse(Course course,Integer id){
    Course oldC=courseRepository.findCourseById(id);

    if (oldC==null){
        throw new ApiException("id wrong");
    }

oldC.setId(course.getId());
    oldC.setName(course.getName());
    courseRepository.save(oldC);


}

public void deleteCourse(Integer id){
        Course course=courseRepository.findCourseById(id);
        if (course==null){
            throw new ApiException("Not Deleted");
        }
        courseRepository.delete(course);
}

    public void assignTeacherToCourse(Integer teacher_id,Integer course_id){
        Course course = courseRepository.findCourseById(course_id);
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        if (course==null || teacher==null) {
            throw new ApiException("id wrong");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }
public String teacherNameForClass(Integer course_Id) {
    Course course = courseRepository.findCourseById(course_Id);
        if (course.getTeacher() == null) {
            throw new ApiException("Not Found");

        }
    return course.getTeacher().getName();
    }
}