package com.example.schoolmanagement.service;

import com.example.schoolmanagement.exceptions.InvalidIdException;
import com.example.schoolmanagement.modle.Student;
import com.example.schoolmanagement.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void checkStudent(Integer id) {

        Student student=studentRepository.findById(id)
                .orElseThrow(
                        ()->new InvalidIdException("Invalid id"));


    }
}
