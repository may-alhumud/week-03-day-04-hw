package com.example.schoolmanagement.service;

import com.example.schoolmanagement.exceptions.InvalidIdException;
import com.example.schoolmanagement.modle.Classroom;
import com.example.schoolmanagement.repository.ClassroomRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomService {
    private final ClassroomRepository classroomRepository;

    public List<Classroom> getClassroom() {
        return classroomRepository.findAll();
    }

    public void addClassroom(Classroom classroom) {
        classroomRepository.save(classroom);
    }

    public void checkClassroom(Integer id) {
        Classroom classroom=classroomRepository.findById(id)
                .orElseThrow(
                        ()->new InvalidIdException("Invalid id"));

    }

    public void add(Classroom classroom) {
        classroomRepository.save(classroom);
    }
}
