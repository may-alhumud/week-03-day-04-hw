package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.DTO.API;
import com.example.schoolmanagement.modle.Student;
import com.example.schoolmanagement.service.StudentService;
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
@RequestMapping("api/v1/student")
public class StudentController {
    private final StudentService studentService;
    Logger logger= LoggerFactory.getLogger(StudentController.class);

    @GetMapping
    public ResponseEntity<List<Student>> getStudent(){
        logger.info(" GET ALL STUDENT");
        List<Student> student=studentService.getStudent();
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @PostMapping("/register")
    public ResponseEntity<API> addStudent(@RequestBody @Valid Student student) {
        logger.info("add student");
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new API("New user added !",201));
    }

    @GetMapping("/student1/{id}")
    public ResponseEntity<API> checkStudentIsValid(@PathVariable Integer id){
        logger.info("check Student is valid");
        studentService.checkStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body(new API("Valid user",200));
    }




}
