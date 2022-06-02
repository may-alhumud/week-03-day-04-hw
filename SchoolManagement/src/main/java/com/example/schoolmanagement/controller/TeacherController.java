package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.DTO.API;
import com.example.schoolmanagement.modle.Student;
import com.example.schoolmanagement.modle.Teacher;
import com.example.schoolmanagement.service.TeacherServicce;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/teacher")
public class TeacherController {
    private final TeacherServicce teacherService;
    Logger logger= LoggerFactory.getLogger(TeacherController.class);


    @GetMapping
    public ResponseEntity<List<Teacher>> getTeacher(){
        logger.info("get all teacher");
        List<Teacher> teachers=teacherService.getTeacher();
        return ResponseEntity.status(HttpStatus.OK).body(teachers);
    }

    @PostMapping("/register")
    public ResponseEntity<API> addTeacher(@RequestBody @Valid Teacher teacher) {
        logger.info("add teacher");
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new API("New user added !",201));
    }

    @GetMapping("/teacher1/{id}")
    public ResponseEntity<API> checkTeacherIsValid(@PathVariable Integer id){
        logger.info("check teacher is invalid");
        teacherService.checkTeacher(id);
        return ResponseEntity.status(HttpStatus.OK).body(new API("Valid user",200));
    }
}
