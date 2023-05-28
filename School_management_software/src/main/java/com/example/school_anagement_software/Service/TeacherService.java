package com.example.school_anagement_software.Service;

import com.example.school_anagement_software.ApiException.ApiException;
import com.example.school_anagement_software.Model.Teacher;
import com.example.school_anagement_software.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
//All CRUD
    public List<Teacher>getAll(){
       return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Teacher teacher, Integer id){
        Teacher old=teacherRepository.findTeacherById(id);
        if (old==null){
            throw new ApiException("Not updated");

        }
        old.setId(teacher.getId());
        old.setName(teacher.getName());
        old.setAge(teacher.getAge());
        old.setEmail(teacher.getEmail());
        old.setSalary(teacher.getSalary());
        teacherRepository.save(old);
    }

    public void deleteTeacher(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if (teacher==null){
            throw new ApiException("Not Deleted");
        }
        teacherRepository.delete(teacher);
    }
    public Teacher getDetails(Integer id){
        return teacherRepository.findTeacherById(id);
    }

}
