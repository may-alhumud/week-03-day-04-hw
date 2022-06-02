package com.example.schoolmanagement.service;

import com.example.schoolmanagement.DTO.ClassroomDTO;
import com.example.schoolmanagement.exceptions.InvalidIdException;
import com.example.schoolmanagement.modle.Student;
import com.example.schoolmanagement.modle.Teacher;
import com.example.schoolmanagement.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServicce {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeacher() {

        return teacherRepository.findAll();
    }

//    public Teacher getTeacherClassroom(ClassroomDTO classroomDTO){
//        return teacherRepository.findById(classroomDTO.getTeacherId()).get();
//    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);

    }


    public void checkTeacher(Integer id) {
        Teacher teacher=teacherRepository.findById(id)
                .orElseThrow(
                        ()->new InvalidIdException("Invalid id"));


    }
}
